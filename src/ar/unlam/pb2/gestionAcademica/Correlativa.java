package ar.unlam.pb2.gestionAcademica;

public class Correlativa {
	
	private Materia materia;
	private Boolean aprobadas;
	
	public Correlativa(Materia materia, Boolean aprobada) {
		this.materia = materia;
		this.aprobadas = aprobada;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Boolean getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(Boolean aprobadas) {
		this.aprobadas = aprobadas;
	}

}
