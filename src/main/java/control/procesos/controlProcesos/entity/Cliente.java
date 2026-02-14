package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nit")
    private String nit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "representante")
    private String representante;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "fk_estado")
    private Estado estado;

    /*@ManyToOne
    @JoinColumn(name = "fk_ciudad_municipio")
    private CiudadMunicipio ciudadMunicipio;*/
}
