package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Transportista;

public interface ITransportistaService {
    public Response<Optional<Transportista>> GetTransportista(Long id);
    public Response<List<Transportista>> ListarTransportistas();
    public Response<Transportista> GuardarTransportista(Transportista transportista);
    public Response<Boolean> EliminarTransportista(Long id);
    
}