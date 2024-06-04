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
import actividad3.desechosfabrica.models.entities.Residuo;
import actividad3.desechosfabrica.models.services.IResiduoService;

@RestController
@RequestMapping("/api")
public class ResiduoController {
    
    @Autowired
    private IResiduoService service;

    @GetMapping("/Reiduo/{id}")
    public Response<Optional<Residuo>> GetResiduo(@RequestParam Long id) {
        return service.GetResiduo(id);

    }

     @GetMapping("/Residuo")
    public Response<List<Residuo>> GetResiduo() {
        return service.ListarResiduo();
    }
    
    @PostMapping("/Residuo")
    public Response<Residuo> SetResiduo(@RequestBody Residuo Residuo){
        return service.GuardarResiduo(Residuo);
    }

    @DeleteMapping("/Residuo/{id}")
    public Response<Boolean> DeleteResiduo(@RequestParam Long id){
        return service.EliminarResiduo(id);
    }
}
