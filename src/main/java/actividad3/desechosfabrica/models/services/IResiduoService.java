package actividad3.desechosfabrica.models.services;

import java.util.Optional;
import java.util.List;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Residuo;

public interface IResiduoService {
    public Response<Optional<Residuo>> GetResiduo(long id);
    public Response<List<Residuo>> ListarResiduo();
    public Response<Residuo> GuardarResiduo(Residuo residuo);
    public Response<Boolean> EliminarResiduo(Long id);

}
