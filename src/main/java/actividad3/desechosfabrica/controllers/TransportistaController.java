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
import actividad3.desechosfabrica.models.entities.Transportista;
import actividad3.desechosfabrica.models.services.ITransportistaService;


@RestController
@RequestMapping("/api")
public class TransportistaController {
     
    @Autowired
    private ITransportistaService service;

    
    @GetMapping("/Transportista/{id}")
    public Response<Optional<Transportista>> GetProdutor(@RequestParam Long id) {
        return service.GetTransportista(id);
    }

    @GetMapping("/Transportistaes")
    public Response<List<Transportista>> GetTransportistaes() {
        return service.ListarTransportistas();
    }
    
    @PostMapping("/Transportista")
    public Response<Transportista> SetTransportista(@RequestBody Transportista Transportista){
        return service.GuardarTransportista(Transportista);
    }

    @DeleteMapping("/Transportista/{id}")
    public Response<Boolean> DeleteTransportista(@RequestParam Long id){
        return service.EliminarTransportista(id);
    }

}
