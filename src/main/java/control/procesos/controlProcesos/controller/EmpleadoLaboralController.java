package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.EmpleadoLaboral;
import control.procesos.controlProcesos.response.EmpleadoLaboralResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controlProcesos")
public class EmpleadoLaboralController {

    @Autowired
    private IEmpleadoLaboralService iEmpleadoLaboralService;

    @PostMapping("empleadoLaboral")
    public ResponseEntity<EmpleadoLaboralResponseRest> crearEmpleadoLaboral(@RequestBody EmpleadoLaboral empleadoLaboral) {
        ResponseEntity<EmpleadoLaboralResponseRest> empleadoLaboralResponseRest =
                iEmpleadoLaboralService.crearEmpleadoLaboral(empleadoLaboral);
        return empleadoLaboralResponseRest;
    }

    @GetMapping("/empleadoLaboral/{idEmpleado}")
    public ResponseEntity<EmpleadoLaboralResponseRest> lstEmpleadoLaboralPorEmpleado(@PathVariable Integer idEmpleado) {
        ResponseEntity<EmpleadoLaboralResponseRest> empleadoLaboralResponseRest =
                iEmpleadoLaboralService.lstEmpleadoLaboralPoEmpleado(idEmpleado);
        return empleadoLaboralResponseRest;
    }

    @PutMapping("/empleadoLaboral/{idEmpleado}")
    public ResponseEntity<EmpleadoLaboralResponseRest> editarEmpleadoLaboral(@RequestBody EmpleadoLaboral empleadoLaboral,
                                                                             @PathVariable Integer idEmpleadoLaboral) {
        ResponseEntity<EmpleadoLaboralResponseRest> empleadoLaboralResponseRest =
                iEmpleadoLaboralService.editarEmpleadolaboral(empleadoLaboral, idEmpleadoLaboral);
        return empleadoLaboralResponseRest;
    }

    @DeleteMapping("/empleadoLaboral/{idEmpleadoLaboral}")
    public ResponseEntity<EmpleadoLaboralResponseRest> eliminarEmpleadoLaboral(@PathVariable Integer idEmpleadoLaboral) {
        ResponseEntity<EmpleadoLaboralResponseRest> empleadoLaboralResponseRest =
                iEmpleadoLaboralService.eliminarEmpleadoLaboral(idEmpleadoLaboral);
        return empleadoLaboralResponseRest;
    }

}
