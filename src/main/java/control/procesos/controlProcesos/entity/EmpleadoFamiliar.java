package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empleado_familiar")
public class EmpleadoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_familiar")
    private TipoFamiliar tipoFamiliar;

    @ManyToOne
    @JoinColumn(name = "fk_documento_maestro")
    private DocumentoMaestro documentoMaestro;

    @ManyToOne
    @JoinColumn(name = "fk_empleado")
    private Empleado empleado;

    @Column(name = "vive_con_empleado")
    private Boolean viveConEmpleado;
}
