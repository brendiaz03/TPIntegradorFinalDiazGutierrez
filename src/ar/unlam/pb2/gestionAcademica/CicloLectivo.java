package ar.unlam.pb2.gestionAcademica;

import java.time.LocalDate;

public class CicloLectivo {
	
	private Integer codigoCicloLectivo;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFinalizacion;
	private LocalDate fechasDeInscripcion;
	
	public CicloLectivo(Integer codigoCicloLectivo, LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, LocalDate fechaDeIns) {
		this.codigoCicloLectivo=codigoCicloLectivo;
		this.fechaDeInicio=fechaDeInicio;
		this.fechaDeFinalizacion=fechaDeFinalizacion;
		this.fechasDeInscripcion=fechaDeIns;
	}
	
	public CicloLectivo() {
		
	}

	public Integer getCodigoCicloLectivo() {
		return codigoCicloLectivo;
	}

	public void setCodigoCicloLectivo(Integer codigoCicloLectivo) {
		this.codigoCicloLectivo = codigoCicloLectivo;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}

	public LocalDate getFechasDeInscripcion() {
		return fechasDeInscripcion;
	}

	public void setFechasDeInscripcion(LocalDate fechasDeInscripcion) {
		this.fechasDeInscripcion = fechasDeInscripcion;
	}

}
