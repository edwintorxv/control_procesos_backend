package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.EmpleadoLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoLaboralRepository extends JpaRepository<EmpleadoLaboral, Integer> {

    @Query(value = "SELECT * FROM empleado_laboral el WHERE el.nombre_empresa =:nombreEmpresa AND el.fk_empleado =:idEmpleado", nativeQuery = true)
    Optional<EmpleadoLaboral> optEmpleadoLaboral(@Param("nombreEmpresa") String nombreEmpresa, @Param("idEmpleado") Integer idEmpleado);

    @Query(value = "SELECT * FROM empleado_laboral el WHERE el.fk_empleado =:idEmpleado", nativeQuery = true)
    List<EmpleadoLaboral> empleadoLaboralPorEmpleado(@Param("idEmpleado") Integer idEmpleado);


}
