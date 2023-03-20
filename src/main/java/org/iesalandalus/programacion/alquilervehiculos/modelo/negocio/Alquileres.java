package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {
	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {

		coleccionAlquileres = new ArrayList<>();

	}

	public List<Alquiler> get() {
		return new ArrayList<>(coleccionAlquileres);

	}

	public List<Alquiler> get(Cliente cliente) {
		List<Alquiler> listaCliente = new ArrayList<>();

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				listaCliente.add(alquiler);
			}
		}
		return listaCliente;

	}

	public List<Alquiler> get(Turismo turismo) {
		List<Alquiler> listaTurismo = new ArrayList<>();

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				listaTurismo.add(alquiler);
			}
		}
		return listaTurismo;

	}

	public int getCantidad() {
		return coleccionAlquileres.size();

	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getFechaDevolucion() == null) {
				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				} else {
					if (alquiler.getTurismo().equals(turismo)) {
						throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
					}
				}
			} else {
				if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
					if (alquiler.getCliente().equals(cliente)) {
						throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
					} else {
						if (alquiler.getTurismo().equals(turismo)) {
							throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
						}
					}
				}
			}
		}

	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if (buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		buscar(alquiler).devolver(fechaDevolucion);
	}

	public Alquiler buscar(Alquiler alquiler) {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		Alquiler comprobacionAlquiler;
		int indiceLista = coleccionAlquileres.indexOf(alquiler);
		if (coleccionAlquileres.indexOf(alquiler) == -1) {
			comprobacionAlquiler = coleccionAlquileres.get(indiceLista);
		} else {
			comprobacionAlquiler = null;
		}

		return comprobacionAlquiler;
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		} else {
			coleccionAlquileres.remove(alquiler);
		}
	}

}
