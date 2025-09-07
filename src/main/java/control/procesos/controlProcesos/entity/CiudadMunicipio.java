package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ciudad_municipio")
public class CiudadMunicipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "codigo_dane")
    private String codigoDane;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_departamento")
    private Departamento departamento;

}
