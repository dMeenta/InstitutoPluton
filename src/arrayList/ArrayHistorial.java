package arrayList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import baseDdatos.Enlace;
import baseDdatos.Historial;

public class ArrayHistorial {
	public ArrayList<Historial>ListarHistorial(){
		ArrayList<Historial>historial = new ArrayList<>();
		try {
			CallableStatement clstm = Enlace.getEnlace().prepareCall("{call historial_Listar()}");
			ResultSet rs = clstm.executeQuery();
			Historial h;
			while(rs.next()){
				h = new Historial(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				historial.add(h);
			}
		} catch (Exception e) {}
		return historial;
	}	
}
