package ar.unlam.pb2.gestionAcademica;

public class Examen {
	
	private Alumno alumno;
	private Integer nota;
	private Boolean promocionado;
	private Boolean desaprobado;
	private Boolean aprobado;
	
    public Examen(Integer nota, Alumno alumno) {
		this.alumno = alumno;
		this.nota=nota;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Boolean getPromocionado() {
		return promocionado;
	}

	public void setPromocionado(Boolean promocionado) {
		this.promocionado = promocionado;
	}

	public Boolean getDesaprobado() {
		return desaprobado;
	}

	public void setDesaprobado(Boolean desaprobado) {
		this.desaprobado = desaprobado;
	}

	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}
	
	public void estadoFinaldeMaterias() {
		
	}
}
