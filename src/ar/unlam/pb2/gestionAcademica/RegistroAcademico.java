package ar.unlam.pb2.gestionAcademica;

public class RegistroAcademico {
	
	private Materia materia;
	private Integer notaFinal;
	
	public RegistroAcademico(Materia materia, Integer nota) {
		this.materia = materia;
		this.notaFinal = notaFinal;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Integer getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Integer notaFinal) {
		this.notaFinal = notaFinal;
	}
	
}
