package arrayList;

import java.util.ArrayList;
import java.sql.*;
import baseDdatos.Enlace;
import hijos.Alumno;

public class ArrayAlumno {
	public ArrayList<Alumno>ListarAlumno(){
		ArrayList<Alumno>lista = new ArrayList<>();
		try {
			CallableStatement clstm = Enlace.getEnlace().prepareCall("{call alumnos_Listar()}");
			ResultSet rs = clstm.executeQuery();
			Alumno alumno;
			while (rs.next()){
				alumno = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8));
				lista.add(alumno);
			}
		} catch (Exception e) {}
		return lista;
	}
	public ArrayList<Alumno>Busqueda(String cod){
		ArrayList<Alumno>lista = new ArrayList<Alumno>();
		try {
			Statement stm = Enlace.getEnlace().createStatement();
			ResultSet rs = stm.executeQuery("Select * from Alumnos where codAlumno like  '%"+cod+"%'");
			Alumno alumno;
			while (rs.next()) {
				alumno = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8));
				lista.add(alumno);
			}
		} catch (Exception e) {	}
		return lista;
	}
	public void InsertarAlumno(String nombres, String apellidos, int edad, String codAula){
		try {
			Connection cn = Enlace.getEnlace();
			CallableStatement clstm = cn.prepareCall("{call alumno_Insertar(?,?,?,?)}");
			clstm.setString(1, nombres);
			clstm.setString(2, apellidos);
			clstm.setInt(3, edad);
			clstm.setString(4, codAula);
			clstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		}
	}
	public void EliminarAlumno(String cod){
		try {
			Connection cn = Enlace.getEnlace();
			CallableStatement clstm = cn.prepareCall("{call alumno_Eliminar(?)}");
			clstm.setString(1, cod);
			clstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		}
	}
	public void Admin_EditarAlumno(String cod, String nombres, String apellidos, int edad, String codAula){
		try {
			Connection cn = Enlace.getEnlace();
			CallableStatement clstm = cn.prepareCall("{call admin_editarAlumno(?,?,?,?,?)}");
			clstm.setString(1, cod);
			clstm.setString(2, nombres);
			clstm.setString(3, apellidos);
			clstm.setInt(4, edad);
			clstm.setString(5, codAula);
			clstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		}
	}
	public void Docente_EditarAlumno(String cod, double n1, double n2, double n3){
		try {
			Connection cn = Enlace.getEnlace();
			CallableStatement clstm = cn.prepareCall("{call docente_editarNotasAlumno(?,?,?,?)}");
			clstm.setString(1, cod);
			clstm.setDouble(2, n1);
			clstm.setDouble(3, n2);
			clstm.setDouble(4, n3);
			clstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		}
	}
}
