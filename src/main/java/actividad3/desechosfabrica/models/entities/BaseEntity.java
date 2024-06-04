package actividad3.desechosfabrica.models.entities;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import java.time.LocalDateTime;


@MappedSuperclass
public class BaseEntity {


  private Long id;

  @Column(name="fecha_creacion")
  private LocalDateTime fechaCreacion;


  @Column
  private int estado;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
 
  public int getEstado() {
    return estado;
  }


  public void setEstado(int estado) {
    this.estado = estado;
  }

  public BaseEntity(Long id, LocalDateTime fechaCreacion, int estado) {
    this.id = id;
    this.fechaCreacion = fechaCreacion;
    this.estado = estado;
  }

  public BaseEntity(){

  }
}
