package aplicaciones.spring.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idData")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Correo")
	private String correo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
