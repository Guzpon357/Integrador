package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Usuario;
@Repository
public interface IUsuario extends JpaRepository<Usuario,Serializable>{
	public abstract Usuario findById(int id);
}
