package baseDdatos;

public class Historial {
	private String fecha, hora, codUsuario, codAfectado, desc;

	public Historial(String fecha, String hora, String codUsuario, String codAfectado, String desc) {
		this.fecha = fecha;
                this.hora = hora;
		this.codUsuario = codUsuario;
		this.codAfectado = codAfectado;
		this.desc = desc;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
        
        public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodAfectado() {
		return codAfectado;
	}

	public void setCodAfectado(String codAfectado) {
		this.codAfectado = codAfectado;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}	
}
