package aplicaciones.spring.modelo;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idReserva")
	private int id;
	
	@Column(name="Usuarios_idLogin")
	private int idUser;
	
	@Column(name="FechaIn")
	private Date fechain;
	
	@Column(name="FechaOut")
	private Date fechaout;
	
	@Column(name="Consumo_idConsumo")
	private int idconsumo;
	
	@Column(name="Habitacion_idHabitacion")
	private int idhabitacion;
	
	@Column(name="Habitacion_Hotel_idData")
	private int idHotel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getFechain() {
		return fechain;
	}

	public void setFechain(Date fechain) {
		this.fechain = fechain;
	}

	public Date getFechaout() {
		return fechaout;
	}

	public void setFechaout(Date fechaout) {
		this.fechaout = fechaout;
	}

	public int getIdconsumo() {
		return idconsumo;
	}

	public void setIdconsumo(int idconsumo) {
		this.idconsumo = idconsumo;
	}

	public int getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	
}
