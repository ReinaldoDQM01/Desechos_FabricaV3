package actividad3.desechosfabrica.models.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "envases")
public class Envase extends BaseEntity {

  @Column
  private String tipo;

  @OneToMany(mappedBy = "envase")
  private Set<Traslado> traslados;

  @OneToMany(mappedBy = "envase")
  private Set<Residuo> residuos;

  public Envase(String Tipo, Set<Traslado> traslados, Long id, LocalDateTime fechaCreacion, int estado) {
    super(id, fechaCreacion, estado);
    this.tipo = Tipo;
    this.traslados = traslados;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String Tipo) {
    this.tipo = Tipo;
  }

  public Set<Traslado> getTraslados() {
    return traslados;
  }

  public void setTraslados(Set<Traslado> traslados) {
    this.traslados = traslados;
  }
}
