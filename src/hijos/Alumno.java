package hijos;

import interfaces.Aulas;
import interfaces.Persona;

public class Alumno implements Persona, Aulas{
	private String codAlumno, nomAlumno, apeAlumno, codAula;
	private int edadAlumno;
	private double n1, n2, n3, prom;
	
	public Alumno(String codAlumno, String nomAlumno, String apeAlumno, int edadAlumno, String codAula, double n1, double n2, double n3) {
		this.codAlumno = codAlumno;
		this.nomAlumno = nomAlumno;
		this.apeAlumno = apeAlumno;
		this.edadAlumno = edadAlumno;
		this.codAula = codAula;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	@Override
	public String getCodigo() {
		return codAlumno;
	}
	
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	@Override
	public String getNombre() {
		return nomAlumno;
	}
	
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	@Override
	public String getApellido() {
		return apeAlumno;
	}
	
	public void setApeAlumno(String apeAlumno) {
		this.apeAlumno = apeAlumno;
	}
	public String getCodAul() {
		return codAula;
	}

	public void setCodAula(String codAula) {
		this.codAula = codAula;
	}

	@Override
	public int getEdad(){
		return edadAlumno;
	}
	public void setEdadAlumno(int edadAlumno){
		this.edadAlumno = edadAlumno;
	}
        

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getN3() {
		return n3;
	}

	public void setN3(double n3) {
		this.n3 = n3;
	}
	@Override
	public String getAula() {
		return codAula;
	}
	public void setAula(String codAula){
		this.codAula = codAula;
	}
        
	public double ObtenerPromedio(){
		prom = (n1+n2+n3)/3.0;
		return prom;
	}
}
