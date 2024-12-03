package awakelab.Prado_del_bosque.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import awakelab.Prado_del_bosque.modelos.entity.Propietario;
import awakelab.Prado_del_bosque.modelos.servicios.PropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietariosController {

	@Autowired
	private PropietarioService propService;
	
    @GetMapping("/listar")
    public String listarPropietarios(Model model) {
        List<Propietario> listaPropietarios = propService.getAll();
        model.addAttribute("propietarios", listaPropietarios);
        return "listarPropietarios"; // Nombre de la vista JSP
    }
}
