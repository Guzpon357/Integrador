package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Habitacion;
@Repository
public interface IHabitacion extends JpaRepository<Habitacion, Serializable>{
	public abstract Habitacion findById(int id);
}
