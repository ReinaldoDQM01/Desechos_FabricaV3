package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Transportista;
import actividad3.desechosfabrica.models.repositories.ITransportistaRepository;

@Service
public class TransportistaService implements ITransportistaService {

    private ITransportistaRepository transportistaRepository;

    @Autowired
    public TransportistaService(ITransportistaRepository repository){
        this.transportistaRepository = repository;
    }

    @Override
    public Response<Optional<Transportista>> GetTransportista(Long id) {
        try {
            Optional<Transportista> transportista = transportistaRepository.findById(id);
            return new Response<Optional<Transportista>>(true, "", transportista);
        } catch (Exception ex) {
            return new Response<Optional<Transportista>>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<List<Transportista>> ListarTransportistas() {
        try {
            List<Transportista> transportistas = transportistaRepository.findAll();
            return new Response<List<Transportista>>(true, null, transportistas);
        } catch (Exception ex) {
            return new Response<List<Transportista>>(false, "Error al tratar de consultar los transportistas: " + ex.getMessage(), null);
        }
    }

    @Override
    public Response<Transportista> GuardarTransportista(Transportista transportista) {
        try {
            Transportista transportistaResult = transportistaRepository.save(transportista);
            return new Response<Transportista>(true, "Guardado correctamente", transportistaResult);
        } catch (Exception ex) {
            return new Response<Transportista>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<Boolean> EliminarTransportista(Long id) {
        try {
            Optional<Transportista> transportista = transportistaRepository.findById(id);
            if (transportista.isPresent()) {
                transportistaRepository.delete(transportista.get());
                return new Response<Boolean>(true, "Transportista eliminado", true);
            } else {
                return new Response<Boolean>(false, "El transportista no existe", false);
            }
        } catch (Exception ex) {
            return new Response<Boolean>(false, ex.getMessage(), false);
        }
    }


}
