package objetos;

public class visitaGuiada {
	private int nVisita;
	private String nombre;
	private int maxVisitantes;
	private String puntoPartida;
	private String cursoAcademico;
	private String tematica;
	private double coste;
	private int idEmple;
	
	public visitaGuiada(int nVisita, String nombre, int maxVisitantes, String puntoPartida, String cursoAcademico,
			String tematica, double coste, int idEmple) {
		super();
		this.nVisita = nVisita;
		this.nombre = nombre;
		this.maxVisitantes = maxVisitantes;
		this.puntoPartida = puntoPartida;
		this.cursoAcademico = cursoAcademico;
		this.tematica = tematica;
		this.coste = coste;
		this.idEmple = idEmple;
	}

	public int getnVisita() {
		return nVisita;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMaxVisitantes() {
		return maxVisitantes;
	}

	public void setMaxVisitantes(int maxVisitantes) {
		this.maxVisitantes = maxVisitantes;
	}

	public String getPuntoPartida() {
		return puntoPartida;
	}

	public void setPuntoPartida(String puntoPartida) {
		this.puntoPartida = puntoPartida;
	}

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getIdEmple() {
		return idEmple;
	}

	public void setIdEmple(int idEmple) {
		this.idEmple = idEmple;
	}

	@Override
	public String toString() {
		return "visitaGuiada [nVisita=" + nVisita + ", nombre=" + nombre + ", maxVisitantes=" + maxVisitantes
				+ ", puntoPartida=" + puntoPartida + ", cursoAcademico=" + cursoAcademico + ", tematica=" + tematica
				+ ", coste=" + coste + ", idEmple=" + idEmple + "]";
	}
	
	
}
