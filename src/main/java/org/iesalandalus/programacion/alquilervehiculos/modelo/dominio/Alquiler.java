package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA = 20;

	private Cliente cliente;
	private Turismo turismo;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;

	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {

		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}

	public Alquiler(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}

		this.cliente = alquiler.cliente;
		this.turismo = alquiler.turismo;
		this.fechaAlquiler = alquiler.fechaAlquiler;
		this.fechaDevolucion = alquiler.fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}

		this.cliente = cliente;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}

		this.turismo = turismo;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		LocalDate hoy = LocalDate.now();
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(hoy)) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		LocalDate hoy = LocalDate.now();
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(hoy)) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isEqual(fechaAlquiler) || fechaDevolucion.isBefore(fechaAlquiler)) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (this.fechaDevolucion != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		setFechaDevolucion(fechaDevolucion);

	}

	public int getPrecio() {
		int precioAlquiler;
		if (getFechaDevolucion() == null) {
			precioAlquiler = 0;
		} else {
			int factorCilindrada = (turismo.getCilindrada()) / 10;

			Period numDias = Period.between(fechaAlquiler, fechaDevolucion);

			precioAlquiler = ((PRECIO_DIA + factorCilindrada) * numDias.getDays());
		}

		return precioAlquiler;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		String mensaje = "Aún no devuelto";
		if (fechaDevolucion == null) {
			return String.format("%s <---> %s, %s - %s (%s€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA), mensaje, getPrecio());
		}
		return String.format("%s <---> %s, %s - %s (%s€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA), fechaDevolucion.format(FORMATO_FECHA), getPrecio());
	}
}
