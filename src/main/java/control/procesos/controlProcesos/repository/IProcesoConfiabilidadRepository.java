package control.procesos.controlProcesos.repository;

import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProcesoConfiabilidadRepository extends JpaRepository<ProcesoConfiabilidad, Integer> {

    @Query(value = "SELECT * FROM proceso_confiabilidad " +
            "WHERE identificacion =:identificacion " +
            "AND fecha_solicitud =:fechaSolicitud " +
            "AND fk_documento_maestro =:idDocumentoMaestro", nativeQuery = true)
    Optional<ProcesoConfiabilidad> optValidarSolicitudEnCusro(@Param("identificacion") String identificacion,
                                                              @Param("fechaSolicitud") LocalDate fechaSolicitud,
                                                              @Param("idDocumentoMaestro") Integer idDocumentoMaestro);


    @Query(value = "SELECT * FROM proceso_confiabilidad WHERE estado_proceso =:estadoProceso", nativeQuery = true)
    List<ProcesoConfiabilidad> lstProcesoConfiabilidadPendiente(@Param("estadoProceso") String estadoProceso);


    @Query(value = "SELECT * FROM proceso_confiabilidad WHERE fk_cliente =:idCliente", nativeQuery = true)
    List<ProcesoConfiabilidad> lstProcesoConfiabilidadCliente(@Param("idCliente") Integer idCliente);


}
