package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Tratamiento;

public interface ITratamientoService {
    public Response<Optional<Tratamiento>> GetTratamiento(long id);
    public Response<List<Tratamiento>> ListarTratamiento();
    public Response<Tratamiento> GuardarTratamiento(Tratamiento tratamiento);
    public Response<Boolean> EliminarTratamiento(long id);
    
}
