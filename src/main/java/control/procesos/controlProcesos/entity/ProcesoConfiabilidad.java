package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "proceso_confiabilidad")
public class ProcesoConfiabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "fk_documento_maestro")
    private DocumentoMaestro documentoMaestro;

    @ManyToOne
    @JoinColumn(name = "fk_concepto")
    private Concepto concepto;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "fecha_atencion")
    private LocalDate fechaAtencion;

    @Column(name = "ampliacion")
    private String ampliacion;

    @Column(name = "estado_proceso")
    private String estadoProceso;

    @ManyToOne
    @JoinColumn(name = "fk_profesional_confiabilidad")
    private ProfesionalConfiabilidad profesionalConfiabilidad;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "url_archivo")
    private String urlArchivo;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

}
