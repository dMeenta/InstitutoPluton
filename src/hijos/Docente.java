package hijos;

import interfaces.Aulas;
import interfaces.Persona;
import interfaces.Usuario;

public class Docente implements Persona, Usuario, Aulas {
	private String codDoc, nomDoc, apeDoc, codAulaD;
	private int passwordDoc, edadDoc, telfDoc;
	
	public Docente(String codDoc, String nomDoc, String apeDoc, int telfDoc, int edadDoc, String codAulaD,
			int passwordDoc) {
		this.codDoc = codDoc;
		this.nomDoc = nomDoc;
		this.apeDoc = apeDoc;
		this.codAulaD = codAulaD;
		this.passwordDoc = passwordDoc;
		this.edadDoc = edadDoc;
		this.telfDoc = telfDoc;
	}
	@Override
	public String getCodigo(){
		return codDoc;
	}
	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}
	@Override
	public String getNombre() {
		return nomDoc;
	}
	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}
	@Override
	public String getApellido() {
		return apeDoc;
	}
	public void setApeDoc(String apeDoc) {
		this.apeDoc = apeDoc;
	}
	@Override
	public int getPassword() {
		return passwordDoc;
	}
	public void setPasswordDoc(int passwordDoc) {
		this.passwordDoc = passwordDoc;
	}
	@Override
	public int getEdad(){
		return edadDoc;
	}
	public void setEdadDoc(int edadDoc){
		this.edadDoc = edadDoc;
	}
	@Override
	public int getTelf(){
		return telfDoc;
	}
	public void setTelfDoc(int telfDoc){
		this.telfDoc = telfDoc;
	}
	@Override
	public String getAula() {
		return codAulaD;
	}
	public void setAula(String codAulaD){
		this.codAulaD = codAulaD;
	}
}
