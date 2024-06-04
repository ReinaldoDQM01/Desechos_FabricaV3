package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Vehiculo;
import actividad3.desechosfabrica.models.repositories.IVehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService {
 
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Response<Optional<Vehiculo>> GetVehiculo(long id) {
        try {
            Optional<Vehiculo> vehiculo = vehiculoRepository.findById(null);
            return new Response<Optional<Vehiculo>>(false, "", vehiculo);
        }    catch (Exception ex) {
            return new Response<Optional<Vehiculo>>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<List<Vehiculo>> ListarVehiculo() {
        try {
            List<Vehiculo> Vehiculos = vehiculoRepository.findAll();
            return new Response<List<Vehiculo>>(true, null, Vehiculos);
        } catch (Exception ex) {
            return new Response<List<Vehiculo>>(false, "Error al tratar de consultar los Vehiculos: " + ex.getMessage(), null);
        }}

    @Override
    public Response<Vehiculo> GuardarVehiculo(Vehiculo vehiculo) {
        try {
            Vehiculo VehiculoResult = vehiculoRepository.save(vehiculo);
            return new Response<Vehiculo>(true, "Guardado correctamente", VehiculoResult);
        } catch (Exception ex) {
            return new Response<Vehiculo>(false, ex.getMessage(), null);
        }}

    @Override
    public Response<Boolean> EliminarVehiculo(long id) {
     try {
            Optional<Vehiculo> Vehiculo = vehiculoRepository.findById(id);
            if (Vehiculo.isPresent()) {
                vehiculoRepository.delete(Vehiculo.get());
                return new Response<Boolean>(true, "Vehiculo eliminado", true);
            } else {
                return new Response<Boolean>(false, "El Vehiculo no existe", false);
            }
        } catch (Exception ex) {
            return new Response<Boolean>(false, ex.getMessage(), false);
        }   
    }
}

   
