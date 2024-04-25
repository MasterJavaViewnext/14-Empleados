package com.cursojava.empleados.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	
	private static final String UPDATE_SALARIO = "UPDATE empleados SET salario = ? WHERE id_empleado = ?";
	
	public static void updateSalario (Connection conexion, int id_empleado, double salario) throws SQLException {
		PreparedStatement statement = conexion.prepareStatement(UPDATE_SALARIO);
		
		statement.setInt(2, id_empleado);
		statement.setDouble(1, salario);
		statement.executeUpdate();
	}
	

	public static void updateVarargs(Connection conexion, String query, String... parametros) throws SQLException {
		PreparedStatement statement = conexion.prepareStatement(query);

		for (int i = 0; i < parametros.length; i++) {
			statement.setString(i + 1, parametros[i]);
		}

		statement.executeUpdate();
	}
}
