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

import aplicaciones.spring.modelo.Usuario;
import aplicaciones.spring.servicios.UsuarioService;
@Controller
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioController {
	@Autowired
	@Qualifier("usuario")
	UsuarioService usuarioService;
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Usuario> usuario=usuarioService.listar();
		model.addAttribute("usuarios",usuario);
		model.addAttribute("titulo","Lista de Usuarios");
		return "usuarioListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Usuario usuario= new Usuario();
		model.put("usuario",usuario);
		model.put("btn", "Crear Usuario");
		return "usuarioForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id")int id,Model model) {
		model.addAttribute("usuario",usuarioService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "usuarioForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Usuario usuario,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			usuario = new Usuario();
			model.addAttribute("usuario",usuario);
			model.addAttribute("btn", "Crear Usuario");
			return "usuarioForm";
		}else {
			usuarioService.guardar(usuario);
		return "redirect:/usuario/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		usuarioService.eliminar(id);
		return"redirect:/usuario/listar";
	}	
}
