package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Habitacion;
import aplicaciones.spring.repositorios.IHabitacion;
@Service("habitacion")
public class HabitacionService {
	@Autowired
	private IHabitacion iHabitacion;
	public void guardar(Habitacion habitacion) {
		iHabitacion.save(habitacion);
	}	
	public List<Habitacion> listar (){
		 return iHabitacion.findAll();
	}	
	public  Habitacion buscar(int id) {
		return  iHabitacion.findById(id);
	}	
	public boolean eliminar (int id) {
		try {
			iHabitacion.delete(iHabitacion.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
