package actividad3.desechosfabrica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/home")
public class InicioController {
    
    @GetMapping("")
    public static String Inicio() {
        return "Hola mundo";
    }
}
