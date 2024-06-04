package actividad3.desechosfabrica.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import actividad3.desechosfabrica.models.entities.Productor;

@Repository
@EnableJpaRepositories
public interface IProductorRepository extends JpaRepository<Productor, Long>{
    
}
