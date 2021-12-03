package aplicaciones.spring.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HABITACION")
public class Habitacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idHabitacion")
	private int id;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Estado_idEstado")
	private int estado;
	
	@Column(name="Hotel_idData")
	private int hotel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	
}
