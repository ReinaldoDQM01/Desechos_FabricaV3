package actividad3.desechosfabrica.models.services;

import java.util.Optional;
import java.util.List;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Vehiculo;

public interface IVehiculoService {
    public Response<Optional<Vehiculo>> GetVehiculo(long id);
    public Response<List<Vehiculo>> ListarVehiculo();
    public Response<Vehiculo> GuardarVehiculo(Vehiculo vehiculo);
    public Response<Boolean> EliminarVehiculo(long id);

}
