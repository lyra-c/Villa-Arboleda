package awakelab.Prado_del_bosque.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "propietarios")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpropietario")
	private int idpropietario;	
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Saldo.class)	// 
	@JoinColumn(name = "saldos_idsaldos", nullable = false)
	private Saldo idsaldos;	// Foreign Key

	// Constructor con parámetros
	public Propietario(int idpropietario, String nombre, String apellido, String correo, String telefono,
			Saldo idsaldos) {
		this.idpropietario = idpropietario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.idsaldos = idsaldos;
	}
	
	// Constructor sin parámetros
	public Propietario() {
		
	}

	public int getIdpropietario() {
		return idpropietario;
	}

	public void setIdpropietario(int idpropietario) {
		this.idpropietario = idpropietario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Saldo getSaldos_idsaldos() {
		return idsaldos;
	}

	public void setSaldos_idsaldos(Saldo idsaldos) {
		this.idsaldos = idsaldos;
	}
	
	
}

/*
 * Rut previo (eliminado pero mantengo esta sección como respaldo)
 * @OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "rut", nullable = false)
private Saldo rut;	// Primary Key

 * */
