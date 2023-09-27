package ar.unlam.pb2.gestionAcademica;

import java.time.LocalDate;

public class Profesor extends Persona {
	
	private Comision comisiones[];

	public Comision[] getComisiones() {
		return comisiones;
	}

	public void setComisiones(Comision[] comisiones) {
		this.comisiones = comisiones;
	}

	public Profesor(String nombre, String apellido, Integer dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso) {
		super(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		// TODO Auto-generated constructor stub
	}

}
