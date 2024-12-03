package awakelab.Prado_del_bosque.controladores;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/")
public class HomeController {


	/** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(path = { "/", "/{nombre}" }, method=RequestMethod.GET) 
    	public ModelAndView mostrarInicio() {
    		return new ModelAndView("inicio");
    }

}
