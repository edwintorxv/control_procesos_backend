package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.EmpleadoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoFamiliarRepository extends JpaRepository<EmpleadoFamiliar, Integer> {

    @Query(value = "SELECT * FROM empleado_familiar ef WHERE ef.fk_empleado =:idEmpleado AND ef.numero_identificacion =:identificacionFamiliar", nativeQuery = true)
    Optional<EmpleadoFamiliar> optionalEmpleadoFamiliar(@Param("idEmpleado") Integer idEmpleado, @Param("identificacionFamiliar") String identificacionFamiliar);

    @Query(value = "SELECT * FROM empleado_familiar ef WHERE ef.fk_empleado =:idEmpleado", nativeQuery = true)
    List<EmpleadoFamiliar> lstEmpleadoFamiliar(@Param("idEmpleado") Integer idEmpleado);

}
