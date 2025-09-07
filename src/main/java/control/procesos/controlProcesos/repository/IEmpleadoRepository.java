package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "SELECT * FROM empleado WHERE numero_identificacion =:numeroCedula", nativeQuery = true)
    Optional<Empleado> buscarPorNumeroIdentificacion(@Param("numeroCedula") String numeroCedula);
}
