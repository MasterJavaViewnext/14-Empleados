package com.cursojava.empleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cursojava.empleados.crud.Insert;
import com.cursojava.empleados.crud.Select;
import com.cursojava.empleados.crud.Update;

public class Principal {

	public static final String URL = "jdbc:mysql://localhost:3306/bdpersonas";
	public static final String USER = "root";
	public static final String PWD = "root";

	public static void main(String[] args) throws SQLException {

		try (Connection conexion = DriverManager.getConnection(URL, USER, PWD)) {

			//INSERTAR EMPLEADO
			//Insert.insertEmpleado(conexion, new Empleado(1, "Pedriña", "Aguirre", LocalDate.of(1998, 1, 10), 1208),  new Empleado(1, "Raul Copia", "Rodal", LocalDate.of(2001, 1, 10), 1208));
			
			//UPDATE EMPELADO
			//Update.updateVarargs(conexion, "update empleados set nombre = ? where apellido  = ?", "Pedriño", "Aguirre");
			//Update.updateSalario(conexion, 1, 1210);
			
			//SELECT * Y MOSTRAR POR CONSOLA
			//for (Empleado empleado : resultSetToList(Select.consultaTodoApellido(conexion, "Aguirre"))) {
			for (Empleado empleado : resultSetToList(Select.consultaTodo(conexion))) {
				System.out.println(empleado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que transforma el ResultSet de un SELECT * de la tabla empleados 
	 * en un ArrayList de Empleado
	 * @param rs
	 * @return List<Empleado>
	 * @throws SQLException
	 */
	public static List<Empleado> resultSetToList(ResultSet rs) throws SQLException{
		List<Empleado> empleados = new ArrayList<>();
		
		while (rs.next()) {
			Empleado empleado = new Empleado();
			empleado.setId_empleado(rs.getInt(1));
			empleado.setNombre(rs.getString(2));
			empleado.setApellido(rs.getString(3));
			empleado.setFecha_nacimiento(rs.getDate(4).toLocalDate());
			empleado.setSalario(rs.getDouble(5));
			
			empleados.add(empleado);
		}
		return empleados;
	}

}
