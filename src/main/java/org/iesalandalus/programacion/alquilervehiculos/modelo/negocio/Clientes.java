package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {
	private List<Cliente> coleccionCliente;

	public Clientes() {

		coleccionCliente = new ArrayList<>();

	}

	public List<Cliente> get() {
		return new ArrayList<>(coleccionCliente);

	}

	public int getCantidad() {
		return coleccionCliente.size();

	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (coleccionCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		coleccionCliente.add(cliente);
	}

	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		int indiceLista = coleccionCliente.indexOf(cliente);
		Cliente comprobacionCliente;
		if (coleccionCliente.indexOf(cliente) == -1) {
			comprobacionCliente = coleccionCliente.get(indiceLista);
		} else {
			comprobacionCliente = null;
		}

		return comprobacionCliente;
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccionCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			coleccionCliente.remove(cliente);
		}
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
	    buscar(cliente);
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (!coleccionCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		if (nombre != null && !nombre.isBlank()) {
			cliente.setNombre(nombre);
		}
		if (telefono != null && !telefono.isBlank()) {
			cliente.setTelefono(telefono);
		}
	}

}
