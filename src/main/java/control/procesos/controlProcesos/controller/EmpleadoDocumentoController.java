package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.EmpleadoDocumento;
import control.procesos.controlProcesos.response.EmpleadoDocumentoResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/controlProcesos")
public class EmpleadoDocumentoController {

    @Autowired
    private IEmpleadoDocumentoService iEmpleadoDocumentoService;

    @GetMapping("/documentoEmpleado")
    public ResponseEntity<EmpleadoDocumentoResponseRest> listadoEmpladoDocumento() {
        ResponseEntity<EmpleadoDocumentoResponseRest> empleadoDocumentoResponseRest = iEmpleadoDocumentoService.lstEmpleadoDocumento();
        return empleadoDocumentoResponseRest;
    }

    @PostMapping("/documentoEmpleado")
    public ResponseEntity<EmpleadoDocumentoResponseRest> crearEmpleadoDocumento(@RequestBody EmpleadoDocumento empleadoDocumento) {
        ResponseEntity<EmpleadoDocumentoResponseRest> empleadoDocumentoResponseRest = iEmpleadoDocumentoService.crearEmpleadoDocumento(empleadoDocumento);
        return empleadoDocumentoResponseRest;
    }

    @DeleteMapping("/documentoEmpleado/{idEmpleadoDocumento}")
    public ResponseEntity<EmpleadoDocumentoResponseRest> eliminarEmpleadoDocumento(@PathVariable Integer idEmpleadoDocumento) {
        ResponseEntity<EmpleadoDocumentoResponseRest> empleadoDocumentoResponseRest = iEmpleadoDocumentoService.eliminarEmpleadoDocumento(idEmpleadoDocumento);
        return empleadoDocumentoResponseRest;
    }

    @GetMapping("documentoEmpleado/empleado/{idEmpleado}")
    public ResponseEntity<EmpleadoDocumentoResponseRest> lstEmpleadoDocumentoPorEmpleado(@PathVariable Integer idEmpleado) {
        ResponseEntity<EmpleadoDocumentoResponseRest> empleadoDocumentoResponseRest = iEmpleadoDocumentoService.lstEmpleadoDocumentoPorEmpleado(idEmpleado);
        return empleadoDocumentoResponseRest;
    }

}
