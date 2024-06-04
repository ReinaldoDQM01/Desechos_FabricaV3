package actividad3.desechosfabrica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Traslado;
import actividad3.desechosfabrica.models.services.ITrasladoService;

@RestController
@RequestMapping("/api")
public class TrasladoController {
    
     @Autowired
    private ITrasladoService service;

    
    @GetMapping("/Traslado/{id}")
    public Response<Optional<Traslado>> GetProdutor(@RequestParam Long id) {
        return service.GetTraslado(id);
    }

    @GetMapping("/Trasladoes")
    public Response<List<Traslado>> GetTraslados() {
        return service.ListarTraslado();
    }
    
    @PostMapping("/Traslado")
    public Response<Traslado> SetTraslado(@RequestBody Traslado Traslado){
        return service.GuardarTraslado(Traslado);
    }

    @DeleteMapping("/Traslado/{id}")
    public Response<Boolean> DeleteTraslado(@RequestParam Long id){
        return service.EliminarTraslado(id);
    }
}
