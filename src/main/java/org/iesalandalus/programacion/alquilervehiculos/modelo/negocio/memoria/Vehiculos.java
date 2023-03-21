package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;


public class Vehiculos implements IVehiculos {
	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {

		coleccionVehiculos = new ArrayList<>();

	}

	@Override
	public List<Vehiculo> get() {
		return new ArrayList<>(coleccionVehiculos);

	}

	@Override
	public int getCantidad() {
		return coleccionVehiculos.size();

	}

	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
		coleccionVehiculos.add(vehiculo);
	}

	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {

		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		Vehiculo comprobacionTurismo;
		int indiceLista = coleccionVehiculos.indexOf(vehiculo);
		if (coleccionVehiculos.indexOf(vehiculo) == -1) {
			comprobacionTurismo = coleccionVehiculos.get(indiceLista);
		} else {
			comprobacionTurismo = null;
		}

		return comprobacionTurismo;
	}

	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (!coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		} else {
			coleccionVehiculos.remove(vehiculo);
		}
	}

}
