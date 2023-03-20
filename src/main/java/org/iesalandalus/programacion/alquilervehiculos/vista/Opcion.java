package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {

	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres con clientes"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres con turismo");

	private String texto;

	private Opcion(String texto) {
		this.texto = texto;
	}
	private static boolean esOrdinalValido(int ordinal) {
		boolean ordinalValido = true;
		if (ordinal < 0 || ordinal > Opcion.values().length) {
			ordinalValido = false;
		}
		return ordinalValido;
		
	}
	public static Opcion get(int ordinal) throws OperationNotSupportedException {
		if (!esOrdinalValido(ordinal)) {
			throw new OperationNotSupportedException("ERROR: El ordinal debe existir");
		}
		
		return Opcion.values()[ordinal];
		
	}
	
	@Override
	public String toString() {
		return String.format("%s",texto);
	}
}
