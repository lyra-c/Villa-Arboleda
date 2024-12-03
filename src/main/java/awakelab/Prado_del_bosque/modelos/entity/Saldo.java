package awakelab.Prado_del_bosque.modelos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="saldos")
public class Saldo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsaldos")
	private int idsaldos;	// Or maybe Long datatype
	
	private String rut;
	private float saldo;
	private int estado;
	
	@OneToOne(mappedBy = "idsaldos", fetch = FetchType.LAZY)	//	Previamente contaba con  cascade = CascadeType.ALL
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Propietario propietario;

	
	// Constructor con parámetros
	public Saldo(int idsaldos, String rut, float saldo, int estado) {
		this.idsaldos = idsaldos;
		this.rut = rut;
		this.saldo = saldo;
		this.estado = estado;
	}
	
	// Constructor sin parámetros
	public Saldo() {
		
	}

	public int getIdsaldos() {
		return idsaldos;
	}

	public void setIdsaldos(int idsaldos) {
		this.idsaldos = idsaldos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
