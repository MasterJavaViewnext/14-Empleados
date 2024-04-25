package com.cursojava.empleados.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cursojava.empleados.Empleado;

public class Insert {
	
	public static String INSERT = "INSERT INTO empleados (nombre, apellido, fecha_nacimiento, salario) VALUES (?, ?, ?, ?)";

	public static void insertEmpleado (Connection conexion, Empleado...empleados) throws SQLException {
		
		conexion.setAutoCommit(false); 
		PreparedStatement statement = conexion.prepareStatement(INSERT);

		for (Empleado empleado : empleados) {
			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellido());
			statement.setDate(3, empleado.getFecha_nacimientoDate());
			statement.setDouble(4, empleado.getSalario());
			statement.addBatch();
		}
		statement.executeBatch();
        conexion.commit();
		conexion.setAutoCommit(true); 
	}
	
	
}
