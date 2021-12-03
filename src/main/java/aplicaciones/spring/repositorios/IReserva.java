package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Reserva;
@Repository
public interface IReserva extends JpaRepository<Reserva,Serializable>{
	public abstract Reserva findById(int id);
}
