package EjercicioHibernate1.EjercicioHibernate1.entities.xmlmapping;

import java.io.Serializable;

public class Departamento implements Serializable {

	private int codigoDepartamento;
	private String nombre;
	private int codigoResponsable;
	
	public Departamento() {
		super();
	}

	public Departamento(int codigoDepartamento, String nombre, int codigoResponsable) {
		super();
		this.codigoDepartamento = codigoDepartamento;
		this.nombre = nombre;
		this.codigoResponsable = codigoResponsable;
	}

	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoResponsable() {
		return codigoResponsable;
	}

	public void setCodigoResponsable(int codigoResponsable) {
		this.codigoResponsable = codigoResponsable;
	}

	@Override
	public String toString() {
		return "Departamento [codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombre + ", codigoResponsable="
				+ codigoResponsable + "]";
	}
	
	
	
}
