package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.EmpleadoFamiliar;
import control.procesos.controlProcesos.response.EmpleadoFamiliarResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/controlProcesos")
public class EmpleadoFamiliarController {

    @Autowired
    private IEmpleadoFamiliarService iEmpleadoFamiliarService;

    @GetMapping("/empleadoFamiliar")
    public ResponseEntity<EmpleadoFamiliarResponseRest> lstEmpleadoFamiliar() {
        ResponseEntity<EmpleadoFamiliarResponseRest> empleadoFamiliarResponseRest = iEmpleadoFamiliarService.lstEmpleadoFamilar();
        return empleadoFamiliarResponseRest;
    }

    @PostMapping("/empleadoFamiliar")
    public ResponseEntity<EmpleadoFamiliarResponseRest> crearEmpleadoFamiliar(@RequestBody EmpleadoFamiliar empleadoFamiliar) {
        ResponseEntity<EmpleadoFamiliarResponseRest> empleadoFamiliarResponseRest = iEmpleadoFamiliarService.crearEmpleadoFamiliar(empleadoFamiliar);
        return empleadoFamiliarResponseRest;
    }

    @PutMapping("/empleadoFamiliar/{idEmpleadoFamiliar}")
    public ResponseEntity<EmpleadoFamiliarResponseRest> editarEmpleadoFamiliar(@RequestBody EmpleadoFamiliar empleadoFamiliar,
                                                                               @PathVariable Integer idEmpleadoFamiliar) {
        ResponseEntity<EmpleadoFamiliarResponseRest> empleadoFamiliarResponseRest =
                iEmpleadoFamiliarService.editarEmpleadoFamiliar(empleadoFamiliar, idEmpleadoFamiliar);
        return empleadoFamiliarResponseRest;
    }

    @GetMapping("/empleadoFamiliar/{idEmpleado}")
    public ResponseEntity<EmpleadoFamiliarResponseRest> lstEmpleadoFamiliarPorEmpleado(@PathVariable Integer idEmpleado){
        ResponseEntity<EmpleadoFamiliarResponseRest> empleadoFamiliarResponseRest = iEmpleadoFamiliarService.lstFamiliarPorEmpleado(idEmpleado);
        return empleadoFamiliarResponseRest;
    }

    @DeleteMapping("empleadoFamiliar/{idFamiliar}")
    public ResponseEntity<EmpleadoFamiliarResponseRest> eliminiarEmpleadoFamiliar(@PathVariable Integer idFamiliar){
        ResponseEntity<EmpleadoFamiliarResponseRest> empleadoFamiliarResponseRest = iEmpleadoFamiliarService.eliminarEmpleadoFamiliar(idFamiliar);
        return empleadoFamiliarResponseRest;
    }


}
