package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import baseDdatos.Enlace;
import compo.Aula;

public class ArrayAula {
	public ArrayList<Aula>ListarAula(){
		ArrayList<Aula>lista = new ArrayList<>();
		try {
			CallableStatement clstm = Enlace.getEnlace().prepareCall("{call aula_Listar()}");
			ResultSet rs = clstm.executeQuery();
			Aula aula;
			while (rs.next()){
				aula = new Aula(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				lista.add(aula);
			}
		} catch (Exception e) {}
		return lista;
	}
	public void CambiarEstado(String cod, String estado){
		try {
			Connection cn = Enlace.getEnlace();
			CallableStatement clstm = cn.prepareCall("{call aula_Cambiar_Estado(?,?)}");
			clstm.setString(1, cod);
			clstm.setString(2, estado);
			clstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		}
	}
}
