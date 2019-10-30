package co.com.ceiba.restaurantapp.dominio.exception.error;

public class Error {

	private String exceptionName;
	private String message;

	public Error(String excepcionName, String mensaje) {
		this.exceptionName = excepcionName;
		this.message = mensaje;
	}
 
	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
 