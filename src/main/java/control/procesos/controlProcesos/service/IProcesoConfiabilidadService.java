package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import control.procesos.controlProcesos.response.ProcesoConfiabilidadResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProcesoConfiabilidadService {

    public ResponseEntity<ProcesoConfiabilidadResponseRest> crearProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> lstProcesoConfiabilidadPorEstado(List<String> estadoProceso);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> editarProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad, Integer idProceso);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> lsrProcesoConfiabilidadPorCliente(Integer fkCliente);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> buscarProcesoPorId(Integer idProceso);

    public ResponseEntity<ProcesoConfiabilidadResponseRest> buscarPorCedulaEvaluado(String cedulaEvaluado);

}
