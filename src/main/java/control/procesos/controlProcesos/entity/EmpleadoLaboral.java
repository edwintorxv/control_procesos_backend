package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "empleado_laboral")
public class EmpleadoLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_empleado")
    private Empleado empleado;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "direccion_empresa")
    private String direccionEmpresa;

    @Column(name = "telefono")
    private String telefono;

    @Column(name="nombre_jefe_directo")
    private String nombreJefeDirecto;

    @Column(name = "cargo_desempenio")
    private String cargoDesempenio;

    @Column(name ="fecha_ingreso")
    private Date fechaIngreso;

    @Column(name ="fecha_retiro")
    private Date fechaRetiro;

}
