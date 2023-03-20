package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;

	public Modelo() {

	}

	public void comenzar() {

		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();

	}

	public void terminar() {

		System.out.print("El modelo ha terminado ^^");

	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(cliente);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {

		turismos.insertar(turismo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente clienteEncontrado = clientes.buscar(alquiler.getCliente());
		Turismo turismoEncontrado = turismos.buscar(alquiler.getTurismo());
		if (clienteEncontrado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (turismoEncontrado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

		alquileres.insertar(new Alquiler(alquiler));

	}

	public Cliente buscar(Cliente cliente) {

		return clientes.buscar(cliente);

	}

	public Turismo buscar(Turismo turismo) {

		return turismos.buscar(turismo);

	}

	public Alquiler buscar(Alquiler alquiler) {

		
		return alquileres.buscar(alquiler);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: El alquiler no puede ser nulo.");
		}
		if (alquileres.buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		for (Alquiler alquiler : alquileres.get(cliente)) {
			borrar(alquiler);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			borrar(alquiler);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		alquileres.borrar(alquiler);

	}

	public List<Cliente> getClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaCliente.add(new Cliente(cliente));
		}
		return listaCliente;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTurismo = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaAlquiler = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaAlquiler.add(new Alquiler(alquiler));
		}
		return listaAlquiler;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaAlquilerConCliente = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(cliente)) {
			listaAlquilerConCliente.add(new Alquiler(alquiler));
		}
		return listaAlquilerConCliente;
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaAlquilerConTurismo = new ArrayList<>();

		for (Alquiler alquiler : alquileres.get(turismo)) {
			listaAlquilerConTurismo.add(new Alquiler(alquiler));
		}
		return listaAlquilerConTurismo;
	}
}
