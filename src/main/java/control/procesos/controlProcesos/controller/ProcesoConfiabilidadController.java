package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import control.procesos.controlProcesos.response.ProcesoConfiabilidadResponseRest;
import control.procesos.controlProcesos.service.IProcesoConfiabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controlProcesos")
public class ProcesoConfiabilidadController {

    @Autowired
    private IProcesoConfiabilidadService iProcesoConfiabilidadService;

    @PostMapping("/procesoConfiabilidad")
    public ResponseEntity<ProcesoConfiabilidadResponseRest> crearProcesoConfiabilidad(@RequestBody ProcesoConfiabilidad procesoConfiabilidad) {
        ResponseEntity<ProcesoConfiabilidadResponseRest> procesoConfiabilidadResponseRest;
        procesoConfiabilidadResponseRest = iProcesoConfiabilidadService.crearProcesoConfiabilidad(procesoConfiabilidad);
        return procesoConfiabilidadResponseRest;
    }

    @GetMapping("/procesoConfiabilidad/{estadoProceso}")
    public ResponseEntity<ProcesoConfiabilidadResponseRest> lstProcesosConfiabilidad(@PathVariable String estadoProceso) {
        ResponseEntity<ProcesoConfiabilidadResponseRest> procesoConfiabilidadResponseRest;
        procesoConfiabilidadResponseRest = iProcesoConfiabilidadService.lstProcesoConfiabilidadPorEstado(estadoProceso);
        return procesoConfiabilidadResponseRest;
    }

    @PutMapping("/procesoConfiabilidad/{idProceso}")
    public ResponseEntity<ProcesoConfiabilidadResponseRest> editarProcesConfiabilidad(@RequestBody ProcesoConfiabilidad procesoConfiabilidad, @PathVariable Integer idProceso) {
        ResponseEntity<ProcesoConfiabilidadResponseRest> procesoConfiabilidadResponseRest;
        procesoConfiabilidadResponseRest = iProcesoConfiabilidadService.editarProcesoConfiabilidad(procesoConfiabilidad, idProceso);
        return procesoConfiabilidadResponseRest;
    }

    @GetMapping("/procesoConfiabilidadCliente/{idCliente}")
    public ResponseEntity<ProcesoConfiabilidadResponseRest> lstProcesosConfiabilidad(@PathVariable Integer idCliente) {
        ResponseEntity<ProcesoConfiabilidadResponseRest> procesoConfiabilidadResponseRest;
        procesoConfiabilidadResponseRest = iProcesoConfiabilidadService.lsrProcesoConfiabilidadPorCliente(idCliente);
        return procesoConfiabilidadResponseRest;
    }

}
