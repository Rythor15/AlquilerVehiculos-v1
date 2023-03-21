package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Autobus extends Vehiculo {

	private static final int FACTOR_PLAZAS = 2;

	private int plazas;

	public Autobus(String marca, String modelo, int plazas, String matricula) {
		super(marca, modelo, matricula);
		setPlazas(plazas);
	}

	public Autobus(Autobus autobus) {
		super(autobus);
		plazas = autobus.getPlazas();

	}

	public int getPlazas() {
		return plazas;
	}

	private void setPlazas(int plazas) {

		if (plazas <= 6 || plazas > 100) {
			throw new IllegalArgumentException("ERROR: Las plazas no son correctas.");
		}
		this.plazas = plazas;
	}

	@Override
	public int getFactorPrecio() {
		return plazas * FACTOR_PLAZAS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(plazas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Autobus))
			return false;
		Autobus other = (Autobus) obj;
		return plazas == other.plazas;
	}

	@Override
	public String toString() {
		return String.format("%s %s (%s plazas) - %s", marca, modelo, plazas, matricula);
	}

}