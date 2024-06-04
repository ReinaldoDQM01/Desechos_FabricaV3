package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Traslado;
import actividad3.desechosfabrica.models.repositories.ITrasladoRepository;

@Service
public class TrasladoService implements ITrasladoService {

    private ITrasladoRepository repository;

    @Autowired
    public TrasladoService(ITrasladoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response<Optional<Traslado>> GetTraslado(long id) {
       try {
        Optional<Traslado> traslado = repository.findById(id);
        return new Response<Optional<Traslado>>(true, "", traslado);
       } catch (Exception ex) {
        return new Response<Optional<Traslado>>(false, ex.getMessage(), null);
       }
    }

    @Override
    public Response<List<Traslado>> ListarTraslado() {
        // TODO Auto-generated method stub
        try {
            List<Traslado> Traslado = repository.findAll();
            return new Response<List<Traslado>>(true, null, Traslado);
        } catch (Exception ex) {
            return new Response<List<Traslado>>(false, "Error al tratar de consultar los Traslado" + ex.getMessage(),
                    null);
        }
    }

    @Override
    public Response<Traslado> GuardarTraslado(Traslado Traslado) {
        // TODO Auto-generated method stub
        try {
            Traslado TrasladoResult = repository.save(Traslado);
            return new Response<Traslado>(true, "Guardado correctamente", TrasladoResult);
        } catch (Exception ex) {
            return new Response<Traslado>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<Boolean> EliminarTraslado(Long id) {
        // TODO Auto-generated method stub
        try {
            Optional<Traslado> Traslado = repository.findById(id);
            if (!Traslado.isEmpty()) {
                repository.delete(Traslado.get());
                return new Response<Boolean>(true, "Traslado eliminado", true);
            } else {
                return new Response<Boolean>(false, "El Traslado no existe", false);
            }

        } catch (Exception ex) {
            return new Response<Boolean>(false, ex.getMessage(), false);
        }
    }
}
