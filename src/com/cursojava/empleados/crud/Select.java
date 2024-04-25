package com.cursojava.empleados.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Select {

	private static final String SELECT_ALL = "SELECT * FROM empleados";
	private static final String SELECT_ALL_APELLIDO = "SELECT * FROM empleados WHERE apellido = ?";

	public static ResultSet consultaTodo(Connection conexion) throws SQLException  {
		return conexion.prepareStatement(SELECT_ALL).executeQuery();
	}
	
	public static ResultSet consultaTodoApellido(Connection conexion, String apellido) throws SQLException  {
		PreparedStatement statement = conexion.prepareStatement(SELECT_ALL_APELLIDO);
		
		statement.setString(1, apellido);
	
		return statement.executeQuery();
	}
	
	public static ResultSet generarResultSetParametrizada(Connection conexion, String sql, String...parametros)throws SQLException {
		PreparedStatement statement = conexion.prepareStatement(sql);

		for (int i = 0; i < parametros.length; i++) {
			statement.setString(i+1, parametros[i]);
		}

		return statement.executeQuery();
	}

}
