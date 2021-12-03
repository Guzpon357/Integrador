package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Hotel;
import aplicaciones.spring.repositorios.IHotel;
@Service("hotel")
public class HotelService {
	@Autowired
	private IHotel iHotel;
	public void guardar(Hotel hotel) {
		iHotel.save(hotel);
	}	
	public List<Hotel> listar (){
		 return iHotel.findAll();
	}	
	public  Hotel buscar(int id) {
		return  iHotel.findById(id);
	}	
	public boolean eliminar (int id) {
		try {
			iHotel.delete(iHotel.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
