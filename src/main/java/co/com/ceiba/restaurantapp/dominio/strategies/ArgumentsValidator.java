package co.com.ceiba.restaurantapp.dominio.strategies;

import co.com.ceiba.restaurantapp.dominio.exception.ExceptionsForRstrictions;

public class ArgumentsValidator {

	public static void restrictionForNull(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}
	
	public static void restrictionForNulle(Object valor, String mensaje) {
		if (valor == "") {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

	public static void restrictionForValueZero(int valor, String mensaje) {
		if (valor == 0) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

	public static void restrictionForValueZero(float valor, String mensaje) {
		if (valor == 0) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

}
