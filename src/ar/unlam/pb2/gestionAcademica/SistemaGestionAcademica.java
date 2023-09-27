package ar.unlam.pb2.gestionAcademica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaGestionAcademica {

	private String nombreSistema;
	private List<Materia> materias;
	private List<Alumno> alumnos;
	private List<Profesor> profesores;
	private List<CicloLectivo> ciclosLectivos;
	private List<Comision> comisiones;

	public SistemaGestionAcademica(String nombreDeSistema) {
		this.nombreSistema = nombreDeSistema;
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.comisiones = new ArrayList<>();
	}

	public SistemaGestionAcademica() {

	}

	public String getNombreSistema() {
		return nombreSistema;
	}

	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public List<Comision> getComisiones() {
		return comisiones;
	}

	public Boolean agregarMateria(Materia materia) {
		Boolean encontrado = false;
		for (int i = 0; i < materias.size(); i++) {
			if (materia.getCodidoDeMateria().equals(materias.get(i).getCodidoDeMateria())) {
				encontrado = true;
			}
		}
		if (encontrado) {
			return false;
		} else {
			materias.add(materia);
			return true;
		}
	}

	public Boolean agregarAlumno(Alumno alumno) {
		Boolean dniRepetido = false;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumno.getDni().equals(alumnos.get(i).getDni())) {
				dniRepetido = true;
			}
		}
		if (!dniRepetido) {
			alumnos.add(alumno);
			return true;
		} else {
			return false;
		}
	}

	public Boolean agregarProfesor(Profesor profesor) {
		Boolean dniRepetido = false;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesor.getDni().equals(profesores.get(i).getDni())) {
				dniRepetido = true;
			}
		}
		if (!dniRepetido) {
			profesores.add(profesor);
			return true;
		} else {
			return false;
		}
	}

	public Boolean agregarCicloLectivo(CicloLectivo nuevo) {
		Boolean codRepetido = false;
		Boolean fechasRepetidas = hayFechasTraspuestas(nuevo);
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (nuevo.getCodigoCicloLectivo().equals(ciclosLectivos.get(0).getCodigoCicloLectivo())) {
				codRepetido = true;
			}
		}

		if (codRepetido || fechasRepetidas) {
			return false;
		} else {
			ciclosLectivos.add(nuevo);
			return true;
		}
	}

	public Boolean hayFechasTraspuestas(CicloLectivo nuevo) {
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (nuevo.getFechaDeInicio().isBefore(ciclosLectivos.get(i).getFechaDeFinalizacion())
					|| nuevo.getFechaDeInicio().isEqual(ciclosLectivos.get(i).getFechaDeFinalizacion())) {
				return true;
			}
		}
		return false;
	}

	public Boolean agregarComision(Comision comision) {
		Materia nuevaMateria = buscarMateria(comision.getMateria().getCodidoDeMateria());
		CicloLectivo nuevoCiclo = buscarCicloLectivo(comision.getCicloLectivo().getCodigoCicloLectivo());
		Boolean repetido = false;
		for (Comision c : comisiones) {
			if(c.getMateria().equals(nuevaMateria) && c.getCicloLectivo().equals(nuevoCiclo) && c.getTurno().equals(comision.getTurno())) {
				repetido = true;
			}
		}
//		for (int i = 0; i < comisiones.size(); i++) {
//			if (comisiones.get(i).getMateria().equals(nuevaMateria)
//					|| comisiones.get(i).getCicloLectivo().equals(nuevoCiclo)
//					|| comision.getTurno().toLowerCase().equals(comisiones.get(i).getTurno().toLowerCase())) {
//				repetido = true;
//			}
//		}
		if (repetido) {
			return false;
		} else {
			comisiones.add(comision);
			return true;
		}
	}

	public Materia buscarMateria(Integer codigoDeMateria) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCodidoDeMateria().equals(codigoDeMateria)) {
				Materia materiadd = materias.get(i);
				return materiadd;
			}
		}
		return null;
	}

	public CicloLectivo buscarCicloLectivo(Integer codigoCiclo) {
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (ciclosLectivos.get(i).getCodigoCicloLectivo().equals(codigoCiclo)) {
				CicloLectivo cicloGuardado = ciclosLectivos.get(i);
				return cicloGuardado;
			}
		}
		return null;
	}

	public Alumno buscarAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dni)) {
				Alumno alumnoGuardado = alumnos.get(i);
				return alumnoGuardado;
			}
		}
		return null;
	}

	public Comision buscarComision(Integer codigoComision) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (comisiones.get(i).getCodigoDeComision().equals(codigoComision)) {
				Comision comisionGuardada = comisiones.get(i);
				return comisionGuardada;
			}
		}
		return null;
	}

	public Boolean agregarCorrelatividadAUnaMateria(Integer codigoDeMateria, Integer codigoDeCorrelativa) {
		Materia materia = buscarMateria(codigoDeMateria);
		Materia correlativa = buscarMateria(codigoDeCorrelativa);
		if (materia != null && correlativa != null) {
			Correlativa nueva = new Correlativa(correlativa, false);
			if (materia.agregarCorrelativa(nueva)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean eliminarCorrelatividadAUnaMateria(Integer codigoDeMateria, Integer codigoDeCorrelativa) {
		Materia materia = buscarMateria(codigoDeMateria);
		Materia correlativa = buscarMateria(codigoDeCorrelativa);
		if (materia != null && correlativa != null) {
			Correlativa nueva = new Correlativa(correlativa, false);
			if (materia.eliminarCorrelativa(nueva)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean inscribirAlumnoAComision(Integer dniAlumno, Integer codigoComision) {

		return false;
	}

	public Boolean isAlumnoEnOtrasComisiones() {
		return false;
	}

	public Boolean siAlumnoAproboLasCorrelativas(Alumno alumno, Comision comision) {
		List<RegistroAcademico> materiasAlumno = alumno.getMateriasAprobadas();
		List<Correlativa> materiasCor = comision.getMateria().getCorrelativas();
		if (materiasCor.equals(null)) {
			for (Correlativa correlativas : materiasCor) {
				if (materiasAlumno.contains(correlativas)) {

					 } else {
					return false;
					 }
				}
			}
		return true;
		
	}

	public Boolean registrarNota(Integer dniAlumno, Integer codigoDeComision, Integer notaAlumno,
			TipoDeParcial tipoParcial) {
		Alumno alumno = buscarAlumno(dniAlumno);
		Comision comision = buscarComision(codigoDeComision);
		if (notaAlumno > 10 || notaAlumno < 1 || alumno == null || comision == null) {
			return false;
		}
		Boolean correlativas = siAlumnoAproboLasCorrelativas(alumno, comision);
		if (correlativas == false) {
			if (notaAlumno >= 7) {
				notaAlumno = 6;
			}
		}
		switch (tipoParcial) {
		case PRIMER_PARCIAL:
			PrimerParcial nuevoPrimero = new PrimerParcial(notaAlumno, alumno);
			comision.getPrimerosParciales().add(nuevoPrimero);
			comision.setearEstadoDeParciales(alumno.getDni());
			break;

		case SEGUNDO_PARCIAL:
			SegundoParcial nuevoSegundo = new SegundoParcial(notaAlumno, alumno);
			comision.getSegundosParciales().add(nuevoSegundo);
			comision.setearEstadoDeParciales(alumno.getDni());
			break;

		case RECUPERATORIO_PRIMER_PARCIAL:
			if (comision.dioElPrimerRecuperatorio(alumno.getDni())) {
				return false;
			} else {
				RecuperatorioPrimerParcial nuevoRecuperatorio1 = new RecuperatorioPrimerParcial(notaAlumno, alumno);
				comision.getRecuperatoriosPrimerParcial().add(nuevoRecuperatorio1);
				comision.setearEstadoDeParciales(alumno.getDni());
			}

			break;

		case RECUPERATORIO_SEGUNDO_PARCIAL:
			if (comision.dioElSegundoRecuperatorio(alumno.getDni())) {
				return false;
			} else {
				RecuperatorioSegundoParcial nuevoRecuperatorio2 = new RecuperatorioSegundoParcial(notaAlumno, alumno);
				comision.getRecuperatoriosSegundoParcial().add(nuevoRecuperatorio2);
				comision.setearEstadoDeParciales(alumno.getDni());
			}
			break;

		case FINAL:
			if (comision.estanElPrimerYSegundoParcialAprobados(alumno.getDni())) {
				Final nuevoFinal = new Final(notaAlumno, alumno);
				comision.getFinales().add(nuevoFinal);
				comision.setearEstadoDeParciales(alumno.getDni());
			}
			break;
		}
		comision.estanPrimerYSegundoParcialPromocionados(alumno.getDni(), comision.getMateria());
		comision.estanPrimerParcialYSegundoRecuPromocionados(alumno.getDni(), comision.getMateria());
		comision.estanPrimerRecuYSegundoParcialPromocionados(alumno.getDni(), comision.getMateria());
		return true;
	}

	public Boolean setearCorrelativasAprobadasDelAlumno(Alumno alumno) {
		for (RegistroAcademico aprobadas : alumno.getMateriasAprobadas()) {
			for (Correlativa corre : aprobadas.getMateria().getCorrelativas()) {
				if (aprobadas.getMateria().getCodidoDeMateria().equals(corre.getMateria().getCodidoDeMateria())) {
					corre.setAprobadas(true);
				}
			}
		}
		return true;
	}

	public Boolean agregarAlumnoALaComision(Integer dniAlumno, Integer codigoComision) {
		Alumno alumno = buscarAlumno(dniAlumno);
		Comision comision = buscarComision(codigoComision);
		if (alumno == null || comision == null) {
			return false;
		}
		setearCorrelativasAprobadasDelAlumno(alumno);
		System.out.println("Hola entre");
		return false;
	}
}