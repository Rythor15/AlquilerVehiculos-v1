package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {

		if ((controlador != null)) {
				this.controlador = controlador;
		}
	}

	public void comenzar() {

		Consola.mostrarMenu();
	
		
	}

	public void terminar() {
		System.out.print("Hasta luego.");
	}

	private void ejecutar(Opcion inopcion) {
		
	}

	private void insertarCliente() {

	}

	private void insertarTurismo() {

	}

	private void insertarAlquiler() {

	}

	private void buscarCliente() {

	}

	private void buscarTurismo() {

	}

	private void buscarAlquiler() {

	}

	private void modificarCliente() {

	}

	private void devolverAlquiler() {

	}

	private void borrarCliente() {

	}

	private void borrarTurismo() {

	}

	private void borrarAlquiler() {

	}

	private void listarClientes() {

	}

	private void listarTurismos() {

	}

	private void listarAlquileres() {

	}

	private void listarAlquileresCliente() {

	}

	private void listarAlquileresTurismo() {

	}
}
