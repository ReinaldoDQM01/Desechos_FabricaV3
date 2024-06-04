package actividad3.desechosfabrica.controllers;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Envase;
import actividad3.desechosfabrica.models.services.IEnvaseService;

@RestController
@RequestMapping("/api")
public class EnvaseController {
    
    @Autowired
    private IEnvaseService service;


    @GetMapping("/Envase/{id}")
    public Response<Optional<Envase>> GetEnvase(Long id){
        return service.GetEnvase(id);
    }

    @GetMapping("/Envases")
    public Response<List<Envase>> GetEnvases() {
        return service.ListarEnvases();
    }

    @PostMapping("/Envase")
    public Response<Envase> SetEnvase(@RequestBody Envase envase){
        return service.GuardarEnvase(envase);
    }

    @DeleteMapping("/Productor/{id}")
    public Response<Boolean> DeleteEnvase(@RequestParam Long id){
        return service.EliminarEnvase(id);
    }
}
