package actividad3.desechosfabrica.models.services;

import java.util.Optional;
import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Productor;
import java.util.List;

public interface IProductorService  {
    public Response<Optional<Productor>> Get(long id);
    public Response<List<Productor>> List();
    public Response<Productor> Guardar(Productor productor);
    public Response<Boolean> Eliminar(Long id); 
}
