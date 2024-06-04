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
import actividad3.desechosfabrica.models.entities.Vehiculo;
import actividad3.desechosfabrica.models.services.IVehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoController {

     @Autowired
    private IVehiculoService service;

    
    @GetMapping("/Vehiculo/{id}")
    public Response<Optional<Vehiculo>> GetVehiculo(@RequestParam Long id) {
        return service.GetVehiculo(id);
    }

    @GetMapping("/Vehiculos")
    public Response<List<Vehiculo>> GetVehiculos() {
        return service.ListarVehiculo();
    }
    
    @PostMapping("/Vehiculo")
    public Response<Vehiculo> SetVehiculo(@RequestBody Vehiculo Vehiculo){
        return service.GuardarVehiculo(Vehiculo);
    }

    @DeleteMapping("/Vehiculo/{id}")
    public Response<Boolean> DeleteVehiculo(@RequestParam Long id){
        return service.EliminarVehiculo(id);
    }
    
}
