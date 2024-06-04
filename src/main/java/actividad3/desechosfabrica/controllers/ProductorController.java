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
import actividad3.desechosfabrica.models.entities.Productor;
import actividad3.desechosfabrica.models.services.IProductorService;


@RestController
@RequestMapping("/api")
public class ProductorController {
     
    @Autowired
    private IProductorService service;

    
    @GetMapping("/Productor/{id}")
    public Response<Optional<Productor>> GetProductor(@RequestParam Long id) {
        return service.Get(id);
    }

    @GetMapping("/Productores")
    public Response<List<Productor>> GetProductores() {
        return service.List();
    }
    
    @PostMapping("/Productor")
    public Response<Productor> SetProductor(@RequestBody Productor productor){
        return service.Guardar(productor);
    }

    @DeleteMapping("/Productor/{id}")
    public Response<Boolean> DeleteProductor(@RequestParam Long id){
        return service.Eliminar(id);
    }

}
