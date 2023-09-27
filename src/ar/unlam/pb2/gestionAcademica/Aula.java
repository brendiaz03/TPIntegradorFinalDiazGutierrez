package ar.unlam.pb2.gestionAcademica;

public class Aula {
	
	private Integer numero;
	private Integer capacidadMaxima;
	
	public Aula(Integer numero, Integer capacidadMaxima) {
		this.numero=numero;
		this.capacidadMaxima=capacidadMaxima;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

}
