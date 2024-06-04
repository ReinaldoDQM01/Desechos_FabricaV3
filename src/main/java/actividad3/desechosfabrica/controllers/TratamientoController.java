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
import actividad3.desechosfabrica.models.entities.Tratamiento;
import actividad3.desechosfabrica.models.services.ITratamientoService;

@RestController
@RequestMapping("/api")
public class TratamientoController {

     @Autowired
    private ITratamientoService service;

    
    @GetMapping("/Tratamiento/{id}")
    public Response<Optional<Tratamiento>> GetTratamiento(@RequestParam Long id) {
        return service.GetTratamiento(id);
    }

    @GetMapping("/Tratamientoes")
    public Response<List<Tratamiento>> GetTratamientos() {
        return service.ListarTratamiento();
    }
    
    @PostMapping("/Tratamiento")
    public Response<Tratamiento> SetTratamiento(@RequestBody Tratamiento Tratamiento){
        return service.GuardarTratamiento(Tratamiento);
    }

    @DeleteMapping("/Tratamiento/{id}")
    public Response<Boolean> DeleteTratamiento(@RequestParam Long id){
        return service.EliminarTratamiento(id);
    }
}
