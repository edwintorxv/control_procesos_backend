package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "fk_documento_maestro")
    private DocumentoMaestro documentoMaestro;

    @Column(name="numero_identificacion")
    private String numeroIdentificacion;

    @ManyToOne
    @JoinColumn(name ="fk_ciudad_municipio")
    private CiudadMunicipio ciudadMunicipio;

    @Column(name = "direccion_residencia")
    private String direccionResidencia;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @ManyToOne
    @JoinColumn(name= "fk_nivel_academico")
    private NivelAcademico nivelAcademico;

    @ManyToOne
    @JoinColumn(name = "fk_estado_civil")
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name="fk_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "fk_estado")
    private Estado estado;

    @Column(name="fecha_ingreso")
    private Date fechaIngreso;

    @Column(name="fecha_retiro")
    private Date fechaRetiro;


;



}
