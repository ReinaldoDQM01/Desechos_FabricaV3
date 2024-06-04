package actividad3.desechosfabrica.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import actividad3.desechosfabrica.commons.Response;
import actividad3.desechosfabrica.models.entities.Productor;
import actividad3.desechosfabrica.models.repositories.IProductorRepository;

@Service
public class ProductorService implements IProductorService {
  
    private IProductorRepository productorRepository;

    @Autowired
    ProductorService(IProductorRepository productorRepository) {
        this.productorRepository = productorRepository;
    }

    @Override
    public Response<Optional<Productor>> Get(long id) {
        try {
            
            //Se consulta el productor por su id
            Optional<Productor> productor = productorRepository.findById(id);
            
            return new Response<Optional<Productor>>(
                true, 
                "", 
                productor
            );
        
        } catch (Exception e) {
            return new Response<Optional<Productor>>(
                false,
                "Error al tratar de consultar el Productor ",
                null
            );
        }
    }

    @Override
    public Response<List<Productor>> List() {
        try{
            List<Productor> productores = productorRepository.findAll();
            return new Response<List<Productor>>(true, null, productores);
        }
        catch(Exception ex){
            return new Response<List<Productor>>(false, "Error al tratar de consultar los productores" +  ex.getMessage(), null);
        }
    }

    @Override
    public Response<Productor> Guardar(Productor productor) {
        try{
            Productor productorResult = productorRepository.save(productor);
            return new Response<Productor>(true, "Guardado correctamente", productorResult);
        }
        catch(Exception ex){
            return new Response<Productor>(false, ex.getMessage(), null);
        }
    }

    @Override
    public Response<Boolean> Eliminar(Long id) {
        try{
            Optional<Productor> productor = productorRepository.findById(id);
            if(!productor.isEmpty()){
                productorRepository.delete(productor.get());
                return new Response<Boolean>(true, "Productor eliminado", true);
            }
            else{
                return new Response<Boolean>(false, "El productor no existe", false);
            }

        }
        catch(Exception ex){
            return new Response<Boolean>(false, ex.getMessage(), false);
        }
    }
}
