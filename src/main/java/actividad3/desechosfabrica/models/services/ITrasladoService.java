package actividad3.desechosfabrica.models.services;

import java.util.Optional;

import java.util.List;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Traslado;

public interface ITrasladoService {
    public Response<Optional<Traslado>> GetTraslado(long id);
    public Response<List<Traslado>> ListarTraslado();
    public Response<Traslado> GuardarTraslado(Traslado traslado);
    public Response<Boolean> EliminarTraslado(Long id);
    
}
