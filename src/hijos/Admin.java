package hijos;

import interfaces.Persona;
import interfaces.Usuario;

public class Admin implements Persona, Usuario{
	private String codAdmin, nomAdmin, apeAdmin;
	private int edadAdmin, telfAdmin, passwordAdmin;
	
	public Admin(String codAdmin, String nomAdmin, String apeAdmin, int telfAdmin, int edadAdmin, int passwordAdmin) {
		this.codAdmin = codAdmin;
		this.nomAdmin = nomAdmin;
		this.apeAdmin = apeAdmin;
		this.telfAdmin = telfAdmin;
		this.edadAdmin = edadAdmin;
		this.passwordAdmin = passwordAdmin;
	}
	@Override
	public String getCodigo(){
		return codAdmin;
	}
	public void setCodSec(String codAdmin) {
		this.codAdmin = codAdmin;
	}
	@Override
	public String getNombre(){
		return nomAdmin;
	}
	public void setNomSec(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	@Override
	public String getApellido(){
		return apeAdmin;
	}
	public void setApeSec(String apeAdmin) {
		this.apeAdmin = apeAdmin;
	}
	@Override
	public int getPassword(){
		return passwordAdmin;
	}
	public void setPasswordSec(int passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	@Override
	public int getEdad(){
		return edadAdmin;
	}
	public void setEdadSec(int edadAdmin){
		this.edadAdmin = edadAdmin;
	}
	@Override
	public int getTelf(){
		return telfAdmin;
	}
	public void setTelfDoc(int telfAdmin){
		this.telfAdmin = telfAdmin;
	}
}
