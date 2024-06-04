package actividad3.desechosfabrica.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Table(name = "vehiculos")
public class Vehiculo extends BaseEntity {

  @ManyToOne(targetEntity = Transportista.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "transportista_id")
  private Transportista transportista;
  
  @Column(name = "tipo_memdio_transporte")
  private String tipoMedioTransporte;

  public Vehiculo(int transportistaId, Transportista transportista, String tipoMedioTransporte, Long id, LocalDateTime fechaCreacion, int estado) {
    super(id, fechaCreacion, estado);
   
    this.transportista = transportista;
    this.tipoMedioTransporte = tipoMedioTransporte;
  }

  public String getTipoMedioTransporte() {
    return tipoMedioTransporte;
  }

  public void setTipoMedioTransporte(String tipoMedioTransporte) {
    this.tipoMedioTransporte = tipoMedioTransporte;
  }


  public Transportista getTransportista() {
    return transportista;
  }

  public void setTransportista(Transportista transportista) {
    this.transportista = transportista;
  }

}
