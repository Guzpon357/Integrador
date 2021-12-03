package aplicaciones.spring.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicaciones.spring.modelo.Hotel;
import aplicaciones.spring.servicios.HotelService;

@Controller
@RequestMapping("/hoteles")
@SessionAttributes("hotel")
public class HotelController {
	@Autowired
	@Qualifier("hotel")
	HotelService hotelService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Hotel> hotel=hotelService.listar();
		model.addAttribute("hotel",hotel);
		model.addAttribute("titulo","Lista de Hoteles");
		return "hotelListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Hotel hotel= new Hotel();
		model.put("hotel",hotel);
		model.put("btn", "Crear Hotel");
		return "hotelForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id")int id,Model model) {
		model.addAttribute("hotel",hotelService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "hotelForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Hotel hotel,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			hotel = new Hotel();
			model.addAttribute("hotel",hotel);
			return "hotelForm";
		}else {
			hotelService.guardar(hotel);
		return "redirect:/hoteles/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		hotelService.eliminar(id);
		return"redirect:/hoteles/listar";
	}
}
