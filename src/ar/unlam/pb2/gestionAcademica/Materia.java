package ar.unlam.pb2.gestionAcademica;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	
	private String nombre;
	private Integer codidoDeMateria;
	private List<Correlativa> correlativas;
	
	public Materia(String nombre, Integer codigoDeMateria) {
		this.nombre = nombre;
		this.codidoDeMateria = codigoDeMateria;
		this.correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodidoDeMateria() {
		return codidoDeMateria;
	}

	public void setCodidoDeMateria(Integer codidoDeMateria) {
		this.codidoDeMateria = codidoDeMateria;
	}

	public List<Correlativa> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Correlativa> correlativas) {
		this.correlativas = correlativas;
	}
	
	public void deleteCorrelativas(List<Correlativa> correlativasAEliminar) {
		for(int i = 0; i<correlativas.size(); i++) {
			for(int k = 0; k<correlativasAEliminar.size(); k++) {
				if(correlativas.get(i).getMateria().equals(correlativasAEliminar.get(k).getMateria())) {
					correlativas.remove(i);
				}
			}		
		}
	}
	
	public Boolean agregarCorrelativa(Correlativa correlativa) {
		Boolean materiaRepetida = false;
		setCorrelativas(correlativa.getMateria().getCorrelativas());
		for(int i = 0; i<correlativas.size();i++) {
			if(correlativa.getMateria().getCodidoDeMateria().equals(correlativas.get(i).getMateria().getCodidoDeMateria())) {
				materiaRepetida = true;
			}
		}
		if(materiaRepetida) {
			return false;
		}else {
			correlativas.add(correlativa);
			return true;	
		}
		
	}
	
	public Boolean eliminarCorrelativa(Correlativa correlativa) {
		Boolean materiaRepetida = false;
		deleteCorrelativas(correlativa.getMateria().getCorrelativas());
		for(int i = 0; i<correlativas.size();i++) {
			if(correlativa.getMateria().getCodidoDeMateria().equals(correlativas.get(i).getMateria().getCodidoDeMateria())) {
				materiaRepetida = true;
			}
		}
		if(materiaRepetida) {
			correlativas.remove(correlativa);
			return true;
		}else {
			return false;
		}
		
	}
}
