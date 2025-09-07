package control.procesos.controlProcesos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profesional_confiabilidad")
public class ProfesionalConfiabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_empleado")
    private Empleado empleado;

}
