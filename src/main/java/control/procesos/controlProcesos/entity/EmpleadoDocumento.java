package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "empleado_documento")
public class EmpleadoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "fk_documento_maestro")
    private DocumentoMaestro documentoMaestro;

    @Column(name = "fecha_inicial")
    private Date fechaInicial;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "url_archivo")
    private String urlArchivo;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

}
