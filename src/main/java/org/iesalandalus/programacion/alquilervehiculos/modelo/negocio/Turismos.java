package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {
	private List<Turismo> coleccionTurismos;

	public Turismos() {

		coleccionTurismos = new ArrayList<>();

	}

	public List<Turismo> get() {
		return new ArrayList<>(coleccionTurismos);

	}

	public int getCantidad() {
		return coleccionTurismos.size();

	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
		coleccionTurismos.add(turismo);
	}

	public Turismo buscar(Turismo turismo) {

		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		Turismo comprobacionTurismo;
		int indiceLista = coleccionTurismos.indexOf(turismo);
		if (coleccionTurismos.indexOf(turismo) == -1) {
			comprobacionTurismo = coleccionTurismos.get(indiceLista);
		} else {
			comprobacionTurismo = null;
		}

		return comprobacionTurismo;
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (!coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		} else {
			coleccionTurismos.remove(turismo);
		}
	}

}
