package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "documento_maestro")
@Data
public class DocumentoMaestro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sigla")
    private String sigla;
}
