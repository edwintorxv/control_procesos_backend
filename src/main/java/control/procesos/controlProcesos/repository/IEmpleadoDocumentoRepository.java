package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.EmpleadoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoDocumentoRepository extends JpaRepository<EmpleadoDocumento, Integer> {

    @Query(value = "SELECT * FROM empleado_documento de WHERE de.fk_empleado =:idEmpleado AND de.fk_documento_maestro =:idDocumentoMaestro", nativeQuery = true)
    Optional<EmpleadoDocumento> validarExistenciaEmpleadoDocumento(@Param("idEmpleado") Integer idEmpleado, @Param("idDocumentoMaestro") Integer idDocumentoMaestro);

    @Query(value = "SELECT * FROM empleado_documento de WHERE de.fk_empleado =:idEmpleado", nativeQuery = true)
    List<EmpleadoDocumento> lstDocumentoPorEmpleado(@Param("idEmpleado") Integer idEmpleado);
}
