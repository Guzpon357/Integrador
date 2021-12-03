package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Consumo;
import aplicaciones.spring.repositorios.IConsumo;
@Service("consumo")
public class ConsumoService {
	@Autowired
	private IConsumo iConsumo;
	public void guardar(Consumo consumo) {
		iConsumo.save(consumo);
	}	
	public List<Consumo> listar (){
		 return iConsumo.findAll();
	}	
	public  Consumo buscar(int id) {
		return  iConsumo.findById(id);
	}	
	public boolean eliminar (int id) {
		try {
			iConsumo.delete(iConsumo.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
