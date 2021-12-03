package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Usuario;
import aplicaciones.spring.repositorios.IUsuario;
@Service("usuario")
public class UsuarioService {
	@Autowired
	private IUsuario iUsuario;
	public void guardar(Usuario usuario) {
		iUsuario.save(usuario);
	}	
	public List<Usuario> listar (){
		 return iUsuario.findAll();
	}	
	public  Usuario buscar(int id) {
		return  iUsuario.findById(id);
	}	
	public boolean eliminar (int id) {
		try {
			iUsuario.delete(iUsuario.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
