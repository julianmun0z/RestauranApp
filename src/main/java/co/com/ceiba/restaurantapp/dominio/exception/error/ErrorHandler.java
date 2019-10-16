package co.com.ceiba.restaurantapp.dominio.exception.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import co.com.ceiba.restaurantapp.dominio.exception.ExceptionsForRstrictions;

public class ErrorHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ErrorHandler.class);
	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ErrorHandler() {
		CODIGOS_ESTADO.put(ExceptionsForRstrictions.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> resultado;

		String excepcionName = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionName);

		if (codigo != null) {
			Error error = new Error(excepcionName, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));

		} else {
			LOGGER_ERROR.error(excepcionName, exception);
			Error error = new Error(excepcionName, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return resultado;
	}

}
