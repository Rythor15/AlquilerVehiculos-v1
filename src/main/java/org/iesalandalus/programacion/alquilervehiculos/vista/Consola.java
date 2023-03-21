package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehículo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static final void mostrarCabecera(String mensaje) {

		int i = 0;
		if (mensaje == null) {
			throw new NullPointerException("El mensaje no puede ser nulo");
		}
		System.out.printf("%s", mensaje);
		do {
			System.out.print("_");
			i++;
		} while (i < mensaje.length());
	}

	public static final void mostrarMenu() {
		Consola.mostrarCabecera(PATRON_FECHA);
		for (int i = 0; i < Opcion.values().length; i++) {
			System.out.printf("%s", Opcion.valueOf(PATRON_FECHA));
		}
	}

	private static final String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();

	}

	private static final Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();

	}

	private static final LocalDate leerFecha(String mensaje) {
		System.out.printf("%s", mensaje);
		LocalDate fecha = null;
		try {
			fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeException e) {
				e.getMessage();
		}

		return fecha;
	}

	public static final Opcion elegirOpcion() {
		Consola.leerEntero(null);
		return null;

	}

	public static final Cliente leerCliente() {

		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final Cliente leerClienteDni() {
		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final String leerNombre() {
		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final String leerTelefono() {
		System.out.printf("%s", Consola.leerEntero(null));
		return null;
	}

	public static final Vehículo leerTurismo() {
		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final Vehículo leerTursimoMatricula() {
		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final Alquiler leerAlquiler() {
		System.out.printf("%s", Consola.leerCadena(null));
		return null;
	}

	public static final LocalDate leerFechaDevolucion() {
		System.out.printf("%s", Consola.leerFecha(null));
		return null;
	}

}
