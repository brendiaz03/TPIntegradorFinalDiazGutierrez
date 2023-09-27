package ar.unlam.pb2.gestionAcademica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{
	
	private List<RegistroAcademico> materiasAprobadas;
	private List<Materia> materiasCursando;

	public Alumno(String nombre, String apellido,Integer dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso) {
		super(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		this.materiasAprobadas = new ArrayList<>();
		this.materiasCursando = new ArrayList<>();
	}

	public List<RegistroAcademico> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(List<RegistroAcademico> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public List<Materia> getMateriasCursando() {
		return materiasCursando;
	}

	public void setMateriasCursando(List<Materia> materiasCursando) {
		this.materiasCursando = materiasCursando;
	}

	public Boolean buscarMateriaAprobadaDelAlumno(Materia materia) {
		for(int i = 0; i<materiasAprobadas.size();i++) {
			if(materiasAprobadas.get(i).getMateria().getCodidoDeMateria().equals(materia.getCodidoDeMateria())) {
				return true;
			}
		}
		return false;
	}

}
