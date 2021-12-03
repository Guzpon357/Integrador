package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Reserva;
import aplicaciones.spring.repositorios.IReserva;

@Service("reserva")
public class ReservaService {
	@Autowired
	private IReserva iReserva;
	public void guardar(Reserva reserva) {
		iReserva.save(reserva);
	}	
	public List<Reserva> listar (){
		 return iReserva.findAll();
	}	
	public  Reserva buscar(int id) {
		return  iReserva.findById(id);
	}	
	public boolean eliminar (int id) {
		try {
			iReserva.delete(iReserva.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
