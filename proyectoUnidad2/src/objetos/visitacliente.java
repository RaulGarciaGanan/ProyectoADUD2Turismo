package objetos;

import java.sql.Date;

public class visitacliente {
	private int idCliente;
	private int idVisita;
	private int nClientesApuntados;
	private Date fecha;
	public visitacliente(int idCliente, int idVisita, int nClientesApuntados, Date fecha) {
		super();
		this.idCliente = idCliente;
		this.idVisita = idVisita;
		this.nClientesApuntados = nClientesApuntados;
		this.fecha = fecha;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}
	public int getnClientesApuntados() {
		return nClientesApuntados;
	}
	public void setnClientesApuntados(int nClientesApuntados) {
		this.nClientesApuntados = nClientesApuntados;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "visitaclienteSQL [idCliente=" + idCliente + ", idVisita=" + idVisita + ", nClientesApuntados="
				+ nClientesApuntados + ", fecha=" + fecha + "]";
	}
	
	
	

}
