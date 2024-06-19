package compo;

import hijos.Alumno;
import hijos.Docente;
import hijos.Admin;

public class Instituto {
	private Aula aula;
	private Alumno alumno;
	private Docente docente;
	private Admin secretaria;
	private String nomInstituto, direccion;
	private int codInstituto, telfInstituto;
	
	public Instituto(String nomInstituto, String direccion, int codInstituto, int telfInstituto) {
		this.nomInstituto = nomInstituto;
		this.direccion = direccion;
		this.codInstituto = codInstituto;
		this.telfInstituto = telfInstituto;
	}
	
	public Instituto(){
		nomInstituto = null;
		direccion = null;
		codInstituto = 0;
		telfInstituto = 0;
		aula = new Aula();
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getNomInstituto() {
		return nomInstituto;
	}

	public void setNomInstituto(String nomInstituto) {
		this.nomInstituto = nomInstituto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodInstituto() {
		return codInstituto;
	}

	public void setCodInstituto(int codInstituto) {
		this.codInstituto = codInstituto;
	}

	public int getTelfInstituto() {
		return telfInstituto;
	}

	public void setTelfInstituto(int telfInstituto) {
		this.telfInstituto = telfInstituto;
	}
}
