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

import aplicaciones.spring.modelo.Consumo;
import aplicaciones.spring.servicios.ConsumoService;

@Controller
@RequestMapping("/consumos")
@SessionAttributes("consumo")
public class ConsumoController {
	@Autowired
	@Qualifier("consumo")
	ConsumoService consumoService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Consumo> consumo=consumoService.listar();
		model.addAttribute("consumo",consumo);
		model.addAttribute("titulo","Lista de Consumidores");
		return "consumoListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Consumo consumo= new Consumo();
		model.put("consumo",consumo);
		model.put("btn", "Crear Consumo");
		return "consumoForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id")int id,Model model) {
		model.addAttribute("consumo",consumoService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "consumoForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Consumo consumo,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			consumo = new Consumo();
			model.addAttribute("consumo",consumo);
			model.addAttribute("btn", "Crear Consumo");
			return "consumoForm";
		}else {
			consumoService.guardar(consumo);
		return "redirect:/consumo/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		consumoService.eliminar(id);
		return"redirect:/consumo/listar";
	}	
}
