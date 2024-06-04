package actividad3.desechosfabrica.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Tratamiento;
import actividad3.desechosfabrica.models.repositories.ITratamientoRepository;

@Service
public class TratamientoService implements ITratamientoService{

    private ITratamientoRepository tratamientoRepository;

    @Autowired
    public TratamientoService(ITratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }
    
    @Override
    public Response<Optional<Tratamiento>> GetTratamiento(long id) {
        try {
            Optional<Tratamiento> tratamiento = tratamientoRepository.findById(id);

            return new Response<Optional<Tratamiento>>(true, "", tratamiento);
        } catch(Exception ex) {
            return new Response<Optional<Tratamiento>>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<List<Tratamiento>> ListarTratamiento() {
       try {
        List<Tratamiento> tratamiento = tratamientoRepository.findAll();
        return new Response<List<Tratamiento>>(true, null, tratamiento);
       } catch(Exception ex) {
            return new Response<List<Tratamiento>>(false, "", null);
       }
    }

    @Override
    public Response<Tratamiento> GuardarTratamiento(Tratamiento tratamiento) {
    try {
            Tratamiento TratamientoResult = tratamientoRepository.save(tratamiento);
            return new Response<Tratamiento>(true, "Guardado correctamente", TratamientoResult);
        } catch (Exception ex) {
            return new Response<Tratamiento>(false, ex.getMessage(), null);
        }
    
    }

    @Override
    public Response<Boolean> EliminarTratamiento(long id) {
        try{
            Optional<Tratamiento> Tratamiento = tratamientoRepository.findById(id);
            if(!Tratamiento.isEmpty()){
                tratamientoRepository.delete(Tratamiento.get());
                return new Response<Boolean>(true, "Tratamiento eliminado", true);
            }
            else{
                return new Response<Boolean>(false, "El Tratamiento no existe", false);
            }

        }
        catch(Exception ex){
            return new Response<Boolean>(false, ex.getMessage(), false);
        }
    
    }
}
