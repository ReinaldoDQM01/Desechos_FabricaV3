package actividad3.desechosfabrica.models.services;

import java.util.Optional;
import java.util.List;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Envase;

public interface IEnvaseService {
    public Response<Optional<Envase>> GetEnvase(Long id);
    public Response<List<Envase>> ListarEnvases();
    public Response<Envase> GuardarEnvase(Envase envase);
    public Response<Boolean> EliminarEnvase(Long id); 
    
}
