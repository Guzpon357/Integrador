package aplicaciones.spring.modelo;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONSUMO")
public class Consumo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idConsumo")
	private int id;
	
	@Column(name="Recibo")
	private Blob recibo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blob getRecibo() {
		return recibo;
	}
	public void setRecibo(Blob recibo) {
		this.recibo = recibo;
	}
	
}
