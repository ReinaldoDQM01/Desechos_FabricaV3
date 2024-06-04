package actividad3.desechosfabrica.models.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "transportistas")
public class Transportista extends BaseEntity {

  @Column
  private String nombre;

  @OneToMany(targetEntity = Vehiculo.class, mappedBy = "transportista")
  private Set<Vehiculo> vehiculos;
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String Nombre) {
    this.nombre = Nombre;
  }

  public Transportista(String Nombre, long id, LocalDateTime fechaCreacion,
      int estado) {
    super(id, fechaCreacion, estado);
    this.nombre = Nombre;
  }
}
