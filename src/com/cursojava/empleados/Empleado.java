package com.cursojava.empleados;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int id_empleado;
	private String nombre;
	private String apellido;
	private LocalDate fecha_nacimiento;
	private double salario;
	
	public Empleado() {
	}
		
	public Empleado(int id_empleado, String nombre, String apellido,
			LocalDate fecha_nacimiento, double salario) {
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.salario = salario;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public Date getFecha_nacimientoDate() {
		return Date.valueOf(fecha_nacimiento);
	}
	public String getFecha_nacimientoFormated() {
		return fecha_nacimiento.format(FORMATTER);
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento.toString());
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado ").append(id_empleado).append(", nombre: ").append(nombre)
				.append(", apellido: ").append(apellido).append(", fecha_nacimiento: ")
				.append(getFecha_nacimientoFormated()).append(", salario: ").append(salario);
		return builder.toString();
	}
	
	
	
}
