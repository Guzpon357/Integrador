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

import aplicaciones.spring.modelo.Habitacion;
import aplicaciones.spring.servicios.HabitacionService;
@Controller
@RequestMapping("/habitaciones")
@SessionAttributes("habitacion")
public class HabitacionController {
	@Autowired
	@Qualifier("habitacion")
	HabitacionService habitacionService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Habitacion> habitacion=habitacionService.listar();
		model.addAttribute("habitacion",habitacion);
		model.addAttribute("titulo","Lista de Habitaciones");
		return "habitacionListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Habitacion habitacion= new Habitacion();
		model.put("habitacion",habitacion);
		model.put("btn", "Crear Habitacion");
		return "habitacionForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id")int id,Model model) {
		model.addAttribute("habitacion",habitacionService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "habitacionForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Habitacion habitacion,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			habitacion = new Habitacion();
			model.addAttribute("habitacion",habitacion);
			model.addAttribute("btn", "Crear Habitacion");
			return "habitacionForm";
		}else {
			habitacionService.guardar(habitacion);
		return "redirect:/habitacion/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		habitacionService.eliminar(id);
		return"redirect:/habitacion/listar";
	}	
}
