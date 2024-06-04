package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Residuo;
import actividad3.desechosfabrica.models.repositories.IResiduoRepository;

@Service
public class ResiduoService implements IResiduoService {

    private IResiduoRepository repository;

    @Autowired
    public ResiduoService(IResiduoRepository repository) {
        this.repository = repository;
    } 

    @Override
    public Response<Optional<Residuo>> GetResiduo(long id) {
        try {
            // Se consulta el residuo por su id
            Optional<Residuo> residuo = repository.findById(id);
            return new Response<>(true, "", residuo);
        } catch (Exception ex) {
            return new Response<>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<List<Residuo>> ListarResiduo() {
        try {
            List<Residuo> residuos = repository.findAll();
            return new Response<>(true, null, residuos);
        } catch (Exception ex) {
            return new Response<>(false, "Error al tratar de consultar los residuos: " + ex.getMessage(), null);
        }    
    }

    @Override
    public Response<Residuo> GuardarResiduo(Residuo residuo) {
        try {
            Residuo residuoGuardado = repository.save(residuo);
            return new Response<>(true, "Guardado correctamente", residuoGuardado);
        } catch (Exception ex) {
            return new Response<>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<Boolean> EliminarResiduo(Long id) {
        try {
            Optional<Residuo> residuo = repository.findById(id);
            if (residuo.isPresent()) {
                repository.delete(residuo.get());
                return new Response<>(true, "Residuo eliminado", true);
            } else {
                return new Response<>(false, "El Residuo no existe", false);
            }
        } catch (Exception ex) {
            return new Response<>(false, ex.getMessage(), false);
        }
    }
}
