package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import control.procesos.controlProcesos.response.ProcesoConfiabilidadResponseRest;
import org.springframework.http.ResponseEntity;

public interface IProcesoConfiabilidadService {

    public ResponseEntity<ProcesoConfiabilidadResponseRest> crearProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> lstProcesoConfiabilidadPorEstado(String estadoProceso);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> editarProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad, Integer idProceso);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> lsrProcesoConfiabilidadPorCliente(Integer fkCliente);

}
