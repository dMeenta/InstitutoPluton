package compo;

public class Aula {
	private String codigoAula, estado;
	private int piso, cantidad;
	
	public Aula(String codigoAula, int piso, int cantidad, String estado) {
		this.codigoAula = codigoAula;
		this.piso = piso;
		this.cantidad = cantidad;
		this.estado = estado;
	}

	public Aula(){
		codigoAula = null;
		piso = 0;
		cantidad = 0;
		estado = null;
	}

	public String getCodigoAula() {
		return codigoAula;
	}

	public void setCodigoAula(String codigoAula) {
		this.codigoAula = codigoAula;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	
}
