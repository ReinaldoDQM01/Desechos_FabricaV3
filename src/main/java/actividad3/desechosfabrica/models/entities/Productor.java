package actividad3.desechosfabrica.models.entities;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productores")
public class Productor extends BaseEntity {

  @Column
  private String nombre;

  @Column
  private String direccion;

  @Column(name = "tipo_actividad")
  private String tipoActividad;

  @OneToMany(mappedBy = "productor", targetEntity = Residuo.class)
  private Set<Residuo> residuos;

  public Productor(String nombre, String direccion, String tipoActividad, Set<Residuo> residuos, Long id, LocalDateTime fechaCreacion, int estado) {
    super(id, fechaCreacion, estado);
    this.nombre = nombre;
    this.direccion = direccion;
    this.tipoActividad = tipoActividad;
    this.residuos = residuos;
  }

  public Productor()  {
    
  }
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTipoActividad() {
    return tipoActividad;
  }

  public void setTipoActividad(String tipoActividad) {
    this.tipoActividad = tipoActividad;
  }

  public Set<Residuo> getResiduos() {
    return residuos;
  }

  public void setResiduos(Set<Residuo> residuos) {
    this.residuos = residuos;
  }

}
