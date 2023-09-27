package ar.unlam.pb2.gestionAcademica;

import java.util.ArrayList;
import java.util.List;

public class Comision {
	
	private Integer codigoDeComision;
	private Materia materia;
	private List<Alumno> alumnos;
	private List<Profesor> profesores;
	private List<PrimerParcial> primerosParciales;
	private List<SegundoParcial> segundosParciales;
	private List<RecuperatorioPrimerParcial> recuperatoriosPrimerParcial;
	private List<RecuperatorioSegundoParcial> recuperatoriosSegundoParcial;
	private List<Final> finales;
	private CicloLectivo cicloLectivo;
	private Aula aula;
	private String turno;

	public Comision(Integer codigoDeComision,Materia materia, CicloLectivo cicloLectivo, String turno) {
		this.codigoDeComision = codigoDeComision;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.primerosParciales = new ArrayList<>();
		this.segundosParciales = new ArrayList<>();
		this.recuperatoriosPrimerParcial = new ArrayList<>();
		this.recuperatoriosSegundoParcial = new ArrayList<>();
		this.finales = new ArrayList<>();
		this.turno = turno;
		
	}

	public Integer getCodigoDeComision() {
		return codigoDeComision;
	}

	public void setCodigoDeComision(Integer codigoDeComision) {
		this.codigoDeComision = codigoDeComision;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
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

	public List<PrimerParcial> getPrimerosParciales() {
		return primerosParciales;
	}

	public void setPrimerosParciales(List<PrimerParcial> primerosParciales) {
		this.primerosParciales = primerosParciales;
	}

	public List<SegundoParcial> getSegundosParciales() {
		return segundosParciales;
	}

	public void setSegundosParciales(List<SegundoParcial> segundosParciales) {
		this.segundosParciales = segundosParciales;
	}

	public List<RecuperatorioPrimerParcial> getRecuperatoriosPrimerParcial() {
		return recuperatoriosPrimerParcial;
	}

	public void setRecuperatoriosPrimerParcial(List<RecuperatorioPrimerParcial> recuperatoriosPrimerParcial) {
		this.recuperatoriosPrimerParcial = recuperatoriosPrimerParcial;
	}

	public List<RecuperatorioSegundoParcial> getRecuperatoriosSegundoParcial() {
		return recuperatoriosSegundoParcial;
	}

	public void setRecuperatoriosSegundoParcial(List<RecuperatorioSegundoParcial> recuperatoriosSegundoParcial) {
		this.recuperatoriosSegundoParcial = recuperatoriosSegundoParcial;
	}

	public List<Final> getFinales() {
		return finales;
	}

	public void setFinales(List<Final> finales) {
		this.finales = finales;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public Alumno buscarAlumnoEnLaComision(Integer dniAlumno) {
		for(int i = 0; i<alumnos.size(); i++) {
			if(alumnos.get(i).getDni().equals(dniAlumno)) {
				Alumno alumnoGuardado = alumnos.get(i);
				return alumnoGuardado;
			}
		}
		return null;
	}
	
	public Boolean inscribirAlumno(Alumno alumno) {
		Boolean alumnoRepetido = false;
		for(int i = 0; i<alumnos.size(); i++) {
			if(alumnos.get(i).getDni().equals(alumno.getDni())) {
				alumnoRepetido = true;
			}
		}
		if(alumnoRepetido) {
			return false;
		}else {
			alumnos.add(alumno);
			return true;
		}
	}
	
	public void setearEstadoDeParciales(Integer dniAlumno) {
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		if(alumnoEncontrado != null) {
			System.out.println("entro al mayor a 7");
		for(PrimerParcial primero : primerosParciales) {
			if(primero.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(primero.getNota()>=7){
					System.out.println("entro al mayor a 7");
					primero.setPromocionado(true);
				}
				if(primero.getNota() <=6 && primero.getNota() >=4) {
					primero.setAprobado(true);
				}
				if(primero.getNota() <=3) {
					primero.setDesaprobado(true);
				}
			}
		}
		for(int i = 0; i<segundosParciales.size(); i++) {
			if(segundosParciales.get(i).getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(segundosParciales.get(i).getNota() >=7) {
					segundosParciales.get(i).setPromocionado(true);
				}
				if(segundosParciales.get(i).getNota() <=6 || segundosParciales.get(i).getNota() >=4) {
					segundosParciales.get(i).setAprobado(true);
				}
				if(segundosParciales.get(i).getNota() <3) {
					segundosParciales.get(i).setDesaprobado(true);
				}
			}
		}
		for(int i = 0; i<recuperatoriosPrimerParcial.size(); i++) {
			if(recuperatoriosPrimerParcial.get(i).getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(recuperatoriosPrimerParcial.get(i).getNota() >=7) {
					recuperatoriosPrimerParcial.get(i).setPromocionado(true);
				}
				if(recuperatoriosPrimerParcial.get(i).getNota() <=6 || recuperatoriosPrimerParcial.get(i).getNota() >=4) {
					recuperatoriosPrimerParcial.get(i).setAprobado(true);
				}
				if(recuperatoriosPrimerParcial.get(i).getNota() <3) {
					recuperatoriosPrimerParcial.get(i).setDesaprobado(true);
				}
			}
		}
		for(int i = 0; i<recuperatoriosSegundoParcial.size(); i++) {
			if(recuperatoriosSegundoParcial.get(i).getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(recuperatoriosSegundoParcial.get(i).getNota() >=7) {
					recuperatoriosSegundoParcial.get(i).setPromocionado(true);
				}
				if(recuperatoriosSegundoParcial.get(i).getNota() <=6 || recuperatoriosSegundoParcial.get(i).getNota() >=4) {
					recuperatoriosSegundoParcial.get(i).setAprobado(true);
				}
				if(recuperatoriosSegundoParcial.get(i).getNota() <3) {
					recuperatoriosSegundoParcial.get(i).setDesaprobado(true);
				}
			}
		}
		}
		}
	
	public Boolean dioElPrimerRecuperatorio(Integer dniAlumno) {
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		for(RecuperatorioPrimerParcial recu : recuperatoriosPrimerParcial) {
			if(recu.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				return true;
			}
		}
		return false;
		
	}
	
	public Boolean dioElSegundoRecuperatorio(Integer dniAlumno) {
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		for(RecuperatorioSegundoParcial recu : recuperatoriosSegundoParcial) {
			if(recu.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean estanElPrimerYSegundoParcialAprobados(Integer dniAlumno) {
		Boolean primerParcialAprobado = false;
		Boolean segundoParcialAprobado = false;
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		for(PrimerParcial primer: primerosParciales) {
			if(primer.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(primer.getPromocionado() || primer.getAprobado()) {
					primerParcialAprobado = true;
				}
			}
		}
		for(SegundoParcial segundo: segundosParciales) {
			if(segundo.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(segundo.getPromocionado() || segundo.getAprobado()) {
					segundoParcialAprobado = true;
				}
			}
		}
		
		if(primerParcialAprobado && segundoParcialAprobado) {
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean estanPrimerYSegundoParcialPromocionados(Integer dniAlumno, Materia materia) {
		Boolean primerExamenPromocionado = false;
		Boolean segundoExamenPromocionado = false;
		Integer sumaDeNotas = 0;
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		if(alumnoEncontrado == null) {
			return false;
		}
		for(PrimerParcial primer : primerosParciales) {
			if(primer.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(primer.getPromocionado()) {
					sumaDeNotas = primer.getNota();
					primerExamenPromocionado = true;
				}
			}
		}
		for(SegundoParcial segundo : segundosParciales) {
			if(segundo.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(segundo.getPromocionado()) {
					sumaDeNotas = segundo.getNota();
					segundoExamenPromocionado = true;
				}
			}
		}
		
		if(primerExamenPromocionado && segundoExamenPromocionado) {
			sumaDeNotas = sumaDeNotas/2;
			RegistroAcademico registro = new RegistroAcademico(materia, sumaDeNotas);
			alumnoEncontrado.getMateriasAprobadas().add(registro);
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean estanPrimerParcialYSegundoRecuPromocionados(Integer dniAlumno, Materia materia) {
		Boolean primerExamenPromocionado = false;
		Boolean recuSegundoExamenPromocionado = false;
		Integer sumaDeNotas = 0;
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		if(alumnoEncontrado == null) {
			return false;
		}
		for(PrimerParcial primer : primerosParciales) {
			if(primer.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(primer.getPromocionado()) {
					sumaDeNotas = primer.getNota();
					primerExamenPromocionado = true;
				}
			}
		}
		for(RecuperatorioSegundoParcial segundo : recuperatoriosSegundoParcial) {
			if(segundo.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(segundo.getPromocionado()) {
					sumaDeNotas = segundo.getNota();
					recuSegundoExamenPromocionado = true;
				}
			}
		}
		
		if(primerExamenPromocionado && recuSegundoExamenPromocionado) {
			sumaDeNotas = sumaDeNotas/2;
			RegistroAcademico registro = new RegistroAcademico(materia, sumaDeNotas);
			alumnoEncontrado.getMateriasAprobadas().add(registro);
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean estanPrimerRecuYSegundoParcialPromocionados(Integer dniAlumno, Materia materia) {
		Boolean recuPrimerExamenPromocionado = false;
		Boolean segundoExamenPromocionado = false;
		Integer sumaDeNotas = 0;
		Alumno alumnoEncontrado = buscarAlumnoEnLaComision(dniAlumno);
		if(alumnoEncontrado == null) {
			return false;
		}
		for(RecuperatorioPrimerParcial primer : recuperatoriosPrimerParcial) {
			if(primer.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(primer.getPromocionado()) {
					sumaDeNotas = primer.getNota();
					recuPrimerExamenPromocionado = true;
				}
			}
		}
		for(RecuperatorioSegundoParcial segundo : recuperatoriosSegundoParcial) {
			if(segundo.getAlumno().getDni().equals(alumnoEncontrado.getDni())) {
				if(segundo.getPromocionado()) {
					sumaDeNotas = segundo.getNota();
					segundoExamenPromocionado = true;
				}
			}
		}
		
		if(recuPrimerExamenPromocionado && segundoExamenPromocionado) {
			sumaDeNotas = sumaDeNotas/2;
			RegistroAcademico registro = new RegistroAcademico(materia, sumaDeNotas);
			alumnoEncontrado.getMateriasAprobadas().add(registro);
			return true;
		}else {
			return false;
		}
	}
	
}
