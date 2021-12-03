package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Consumo;
@Repository
public interface IConsumo extends JpaRepository<Consumo, Serializable>{
	public abstract Consumo findById(int id);
}
