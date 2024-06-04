package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Envase;
import actividad3.desechosfabrica.models.repositories.IEnvaseRepository;

@Service
public class EnvaseService implements IEnvaseService {

    private IEnvaseRepository repository;

    @Autowired
    public EnvaseService(IEnvaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response<Optional<Envase>> GetEnvase(Long id) {
        try {
            //Se consulta el envase por su id
            Optional<Envase> envase = repository.findById(id);

            return new Response<Optional<Envase>>(true, "", envase);
        } catch (Exception ex) {
            return new Response<Optional<Envase>>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<List<Envase>> ListarEnvases() {
        // TODO Auto-generated method stub
        try {
            List<Envase> Envases = repository.findAll();
            return new Response<List<Envase>>(true, null, Envases);
        } catch (Exception ex) {
            return new Response<List<Envase>>(false, "Error al tratar de consultar los Envases" + ex.getMessage(),
                    null);
        }
    }

    @Override
    public Response<Envase> GuardarEnvase(Envase envase) {
        // TODO Auto-generated method stub
        try {
            Envase EnvaseResult = repository.save(envase);
            return new Response<Envase>(true, "Guardado correctamente", EnvaseResult);
        } catch (Exception ex) {
            return new Response<Envase>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<Boolean> EliminarEnvase(Long id) {
        // TODO Auto-generated method stub
        try {
            Optional<Envase> Envase = repository.findById(id);
            if (!Envase.isEmpty()) {
                repository.delete(Envase.get());
                return new Response<Boolean>(true, "Envase eliminado", true);
            } else {
                return new Response<Boolean>(false, "El Envase no existe", false);
            }

        } catch (Exception ex) {
            return new Response<Boolean>(false, ex.getMessage(), false);
        }
    }
}