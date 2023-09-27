package ar.unlam.pb2.gestionAcademica;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class Test {

	@org.junit.Test
	public void queNoSePuedanAgregarDosMateriasConElMismoCodigo() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 1;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		assertTrue(sistema.agregarMateria(materia1));
		assertFalse(sistema.agregarMateria(materia2));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarAlumnosConElMismoDNI() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		String nombreAlumno1="Brenda", nombreAlumno2="Romi", apellidoAlumno1="Diaz", apellidoAlumno2="Gutierrez";
		Integer dniAlumno1 = 42156466, dniAlumno2 = 42156466;
		LocalDate fechaDeNacAlumno1= LocalDate.parse("1998-08-03"), fechaDeNacAlumno2= LocalDate.parse("1996-05-13");
		LocalDate fechaDeIngAlumno1= LocalDate.now(), fechaDeIngAlumno2= LocalDate.now();
		Alumno alumno1 = new Alumno(nombreAlumno1, apellidoAlumno1, dniAlumno1, fechaDeNacAlumno1, fechaDeIngAlumno1);
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumno2, dniAlumno2, fechaDeNacAlumno2, fechaDeIngAlumno2);
		assertTrue(sistema.agregarAlumno(alumno1));
		assertFalse(sistema.agregarAlumno(alumno2));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarProfesoresConElMismoDNI() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		String nombreProfe1="Brenda", nombreProfe2="Romi", apellidoProfe1="Diaz", apellidoProfe2="Gutierrez";
		Integer dniProfe1 = 42156466, dniProfe2 = 42156466;
		LocalDate fechaDeNacProfe1= LocalDate.of(1998, 8, 3), fechaDeNacProfe2= LocalDate.of(1996, 7, 9);
		LocalDate fechaDeIngProfe1= LocalDate.now(), fechaDeIngProfe2= LocalDate.now();
		Profesor profe1 = new Profesor(nombreProfe1, apellidoProfe1, dniProfe1, fechaDeNacProfe1, fechaDeIngProfe1);
		Profesor profe2 = new Profesor(nombreProfe2, apellidoProfe2, dniProfe2, fechaDeNacProfe2, fechaDeIngProfe2);
		assertTrue(sistema.agregarProfesor(profe1));
		assertFalse(sistema.agregarProfesor(profe2));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarCiclosLectivosConElMismoIDYNoSeSuperponganFechas() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		Integer codigoDeCicloLectivo1 = 1, codigoDeCicloLectivo2 = 2, codigoDeCicloLectivo3 = 3;
		LocalDate fechaDeInicioComision1= LocalDate.of(2023, 4, 5), fechaDeFinComision1= LocalDate.of(2023, 8, 1);
		LocalDate fechaDeInicioComision2= LocalDate.of(2023, 5, 5), fechaDeFinComision2= LocalDate.of(2023, 6, 1);
		LocalDate fechaDeInicioComision3= LocalDate.of(2024, 5, 5), fechaDeFinComision3= LocalDate.of(2024, 6, 1);
		LocalDate fechaDeInscComision1= LocalDate.of(2023, 3, 10), fechaDeInscComision2= LocalDate.of(2023, 3, 10), fechaDeInscComision3= LocalDate.of(2023, 12, 10);
		CicloLectivo cicloLectivo1 = new CicloLectivo(codigoDeCicloLectivo1, fechaDeInicioComision1, fechaDeFinComision1, fechaDeInscComision1);
		CicloLectivo cicloLectivo2 = new CicloLectivo(codigoDeCicloLectivo2, fechaDeInicioComision2, fechaDeFinComision2, fechaDeInscComision2);
		CicloLectivo cicloLectivo3 = new CicloLectivo(codigoDeCicloLectivo3, fechaDeInicioComision3, fechaDeFinComision3, fechaDeInscComision3);
		assertTrue(sistema.agregarCicloLectivo(cicloLectivo1));
		assertFalse(sistema.agregarCicloLectivo(cicloLectivo2));
		assertTrue(sistema.agregarCicloLectivo(cicloLectivo3));
		assertFalse(sistema.agregarCicloLectivo(cicloLectivo1));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarComisionesConLaMismaMateriaCicloLectivoYTurno() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 2;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		sistema.agregarMateria(materia1);
		sistema.agregarMateria(materia2);
		Integer codigoDeCicloLectivo1 = 1, codigoDeCicloLectivo2 = 2;
		LocalDate fechaDeInicioComision1= LocalDate.of(2023, 4, 5), fechaDeFinComision1= LocalDate.of(2023, 8, 1);
		LocalDate fechaDeInicioComision2= LocalDate.of(2023, 9, 5), fechaDeFinComision2= LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInscComision1= LocalDate.of(2023, 3, 10), fechaDeInscComision2= LocalDate.of(2023, 7, 10);
		CicloLectivo cicloLectivo1 = new CicloLectivo(codigoDeCicloLectivo1, fechaDeInicioComision1, fechaDeFinComision1, fechaDeInscComision1);
		CicloLectivo cicloLectivo2 = new CicloLectivo(codigoDeCicloLectivo2, fechaDeInicioComision2, fechaDeFinComision2, fechaDeInscComision2);
		sistema.agregarCicloLectivo(cicloLectivo1);
		sistema.agregarCicloLectivo(cicloLectivo2);
		String turno1 = "tarde";
		String turno2 = "mañana";
		Integer codigoDeComision1 = 1, codigoDeComision2 = 2;
		Comision comision1 = new Comision(codigoDeComision1, materia1, cicloLectivo1, turno1);
		Comision comision2 = new Comision(codigoDeComision2, materia2, cicloLectivo2, turno2);
		assertTrue(sistema.agregarComision(comision1));
		assertTrue(sistema.agregarComision(comision2));
		assertFalse(sistema.agregarComision(comision1));
	}
	
	@org.junit.Test
	public void queNoSePuedaAgregarUnaCorrelativaALaMateriaSiNoExistenLosCodigosDeLasMaterias() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 2, codigoDeMateria3 = 3;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		Materia materia3 = new Materia("Programacion Web II", codigoDeMateria3);
		sistema.agregarMateria(materia1);
		sistema.agregarMateria(materia2);
		sistema.agregarMateria(materia3);
		assertTrue(sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria2, codigoDeMateria1));
		assertTrue(sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria2));
		assertFalse(sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria1));
	}
	
	@org.junit.Test
	public void queNoSePuedaEliminarUnaCorrelativaALaMateriaSiNoExistenLosCodigosDeLasMaterias() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 2, codigoDeMateria3 = 3;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		Materia materia3 = new Materia("Programacion Web II", codigoDeMateria3);
		sistema.agregarMateria(materia1);
		sistema.agregarMateria(materia2);
		sistema.agregarMateria(materia3);
		assertTrue(sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria2, codigoDeMateria1));
		assertTrue(sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria2));
		assertTrue(sistema.eliminarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria2));
		assertFalse(sistema.eliminarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria1));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarAlumnosALaComisionQueNoEstenDadosDeAlta() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		String nombreAlumno1="Brenda", nombreAlumno2="Romi", apellidoAlumno1="Diaz", apellidoAlumno2="Gutierrez";
		Integer dniAlumno1 = 42156466, dniAlumno2 = 42156467;
		LocalDate fechaDeNacAlumno1= LocalDate.parse("1998-08-03"), fechaDeNacAlumno2= LocalDate.parse("1996-05-13");
		LocalDate fechaDeIngAlumno1= LocalDate.now(), fechaDeIngAlumno2= LocalDate.now();
		Alumno alumno1 = new Alumno(nombreAlumno1, apellidoAlumno1, dniAlumno1, fechaDeNacAlumno1, fechaDeIngAlumno1);
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumno2, dniAlumno2, fechaDeNacAlumno2, fechaDeIngAlumno2);
		sistema.agregarAlumno(alumno1);
		sistema.agregarAlumno(alumno2);
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 2;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		sistema.agregarMateria(materia1);
		sistema.agregarMateria(materia2);
		Integer codigoDeCicloLectivo1 = 1, codigoDeCicloLectivo2 = 2;
		LocalDate fechaDeInicioComision1= LocalDate.of(2023, 4, 5), fechaDeFinComision1= LocalDate.of(2023, 8, 1);
		LocalDate fechaDeInicioComision2= LocalDate.of(2023, 9, 5), fechaDeFinComision2= LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInscComision1= LocalDate.of(2023, 3, 10), fechaDeInscComision2= LocalDate.of(2023, 7, 10);
		CicloLectivo cicloLectivo1 = new CicloLectivo(codigoDeCicloLectivo1, fechaDeInicioComision1, fechaDeFinComision1, fechaDeInscComision1);
		CicloLectivo cicloLectivo2 = new CicloLectivo(codigoDeCicloLectivo2, fechaDeInicioComision2, fechaDeFinComision2, fechaDeInscComision2);
		sistema.agregarCicloLectivo(cicloLectivo1);
		sistema.agregarCicloLectivo(cicloLectivo2);
		String turno1 = "tarde";
		String turno2 = "mañana";
		Integer codigoDeComision1 = 1, codigoDeComision2 = 2;
		Comision comision1 = new Comision(codigoDeComision1, materia1, cicloLectivo1, turno1);
		Comision comision2 = new Comision(codigoDeComision2, materia2, cicloLectivo2, turno2);
		sistema.agregarComision(comision1);
		sistema.agregarComision(comision2);
	}
	
	@org.junit.Test
	public void queSePuedanRegistrarLasNotasDeLasMaterias() {
		String nombreSistema = "Gestion";
		SistemaGestionAcademica sistema = new SistemaGestionAcademica(nombreSistema);
		//Agregar materias y su correlativa
		Integer codigoDeMateria1 = 1, codigoDeMateria2 = 2, codigoDeMateria3 = 3;
		Materia materia1 = new Materia("Base de datos I", codigoDeMateria1);
		Materia materia2 = new Materia("Base de datos II", codigoDeMateria2);
		Materia materia3 = new Materia("Programacion Web II", codigoDeMateria3);
		sistema.agregarMateria(materia1);
		sistema.agregarMateria(materia2);
		sistema.agregarMateria(materia3);
		sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria2, codigoDeMateria1);
		sistema.agregarCorrelatividadAUnaMateria(codigoDeMateria3, codigoDeMateria2);
		//Agregar alumnos
		String nombreAlumno1="Brenda", nombreAlumno2="Romi", apellidoAlumno1="Diaz", apellidoAlumno2="Gutierrez";
		Integer dniAlumno1 = 42156466, dniAlumno2 = 42156467;
		LocalDate fechaDeNacAlumno1= LocalDate.parse("1998-08-03"), fechaDeNacAlumno2= LocalDate.parse("1996-05-13");
		LocalDate fechaDeIngAlumno1= LocalDate.now(), fechaDeIngAlumno2= LocalDate.now();
		Alumno alumno1 = new Alumno(nombreAlumno1, apellidoAlumno1, dniAlumno1, fechaDeNacAlumno1, fechaDeIngAlumno1);
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumno2, dniAlumno2, fechaDeNacAlumno2, fechaDeIngAlumno2);
		sistema.agregarAlumno(alumno1);
		sistema.agregarAlumno(alumno2);
		//Agregrar comisiones
		Integer codigoDeCicloLectivo1 = 1, codigoDeCicloLectivo2 = 2, codigoDeCicloLectivo3 = 3;
		LocalDate fechaDeInicioComision1= LocalDate.of(2023, 4, 5), fechaDeFinComision1= LocalDate.of(2023, 8, 1);
		LocalDate fechaDeInicioComision2= LocalDate.of(2023, 9, 5), fechaDeFinComision2= LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioComision3= LocalDate.of(2024, 9, 5), fechaDeFinComision3= LocalDate.of(2024, 12, 1);
		LocalDate fechaDeInscComision1= LocalDate.of(2023, 3, 10), fechaDeInscComision2= LocalDate.of(2023, 7, 10), fechaDeInscComision3= LocalDate.of(2023, 7, 10);
		CicloLectivo cicloLectivo1 = new CicloLectivo(codigoDeCicloLectivo1, fechaDeInicioComision1, fechaDeFinComision1, fechaDeInscComision1);
		CicloLectivo cicloLectivo2 = new CicloLectivo(codigoDeCicloLectivo2, fechaDeInicioComision2, fechaDeFinComision2, fechaDeInscComision2);
		CicloLectivo cicloLectivo3 = new CicloLectivo(codigoDeCicloLectivo3, fechaDeInicioComision3, fechaDeFinComision3, fechaDeInscComision3);
		sistema.agregarCicloLectivo(cicloLectivo1);
		sistema.agregarCicloLectivo(cicloLectivo2);
		String turno1 = "tarde";
		String turno2 = "mañana";
		String turno3 = "mañana";
		Integer codigoDeComision1 = 1, codigoDeComision2 = 2, codigoDeComision3 = 3;
		Comision comision1 = new Comision(codigoDeComision1, materia1, cicloLectivo1, turno1);
		Comision comision2 = new Comision(codigoDeComision2, materia2, cicloLectivo2, turno2);
		Comision comision3 = new Comision(codigoDeComision3, materia3, cicloLectivo3, turno3);
		sistema.agregarComision(comision1);
		sistema.agregarComision(comision2);
		//Probar metodo
		Integer notaAlumno1 = 10;
		Integer notaAlumno2 = 4;
		Integer notaAlumno3 = 2;
		String tipoDeExamen = "Primer Parcial";
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision1, notaAlumno1, TipoDeParcial.PRIMER_PARCIAL));
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision1, notaAlumno1, TipoDeParcial.SEGUNDO_PARCIAL));
		System.out.println("correlativas " + sistema.siAlumnoAproboLasCorrelativas(alumno1, comision1));
		System.out.println(comision1.getPrimerosParciales().get(0).getNota());
		System.out.println(comision1.getSegundosParciales());
		
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision2, notaAlumno1, TipoDeParcial.PRIMER_PARCIAL));
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision2, notaAlumno1, TipoDeParcial.SEGUNDO_PARCIAL));
		
		System.out.println("correlativas " + sistema.siAlumnoAproboLasCorrelativas(alumno1, comision1));
		System.out.println("materias aprobadas" + alumno1.getMateriasAprobadas());
		System.out.println(comision1.getSegundosParciales());
		
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision3, notaAlumno1, TipoDeParcial.PRIMER_PARCIAL));
		assertTrue(sistema.registrarNota(dniAlumno1, codigoDeComision3, notaAlumno1, TipoDeParcial.SEGUNDO_PARCIAL));
		
//		System.out.println("Estado materia " + comision1.getPrimerosParciales().get(0).getPromocionado());
//		System.out.println("Materia aprobada del alumno " + alumno1.getMateriasAprobadas());
		assertTrue(sistema.registrarNota(dniAlumno2, codigoDeComision1, notaAlumno3, TipoDeParcial.PRIMER_PARCIAL));
	}
	
	

}
