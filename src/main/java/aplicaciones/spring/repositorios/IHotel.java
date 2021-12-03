package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Hotel;
@Repository
public interface IHotel extends JpaRepository<Hotel,Serializable>{
	public abstract Hotel findById(int id);
}
