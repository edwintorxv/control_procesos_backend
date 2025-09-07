package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.Empleado;
import control.procesos.controlProcesos.response.EmpleadoResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controlProcesos")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService iEmpleadoService;

    @GetMapping("/listadoEmpleado")
    public ResponseEntity<EmpleadoResponseRest> obtenerEmpleados(){
        ResponseEntity<EmpleadoResponseRest> empleadoResponseRest = iEmpleadoService.lstEmpleados();
        return empleadoResponseRest;
    }

    @PostMapping("/crearEmpleado")
    public ResponseEntity<EmpleadoResponseRest> crearEmpleado(@RequestBody Empleado empleado){
        ResponseEntity<EmpleadoResponseRest> empleadoResponseRest = iEmpleadoService.crearEmpleado(empleado);
        return empleadoResponseRest;
    }

    @PutMapping("/editarEmpleado/{idEmpleado}")
    public ResponseEntity<EmpleadoResponseRest> editarEmpleado(@RequestBody Empleado empleado, @PathVariable Integer idEmpleado){
        ResponseEntity<EmpleadoResponseRest> empleadoResponseRest = iEmpleadoService.editarEmpleado(empleado, idEmpleado);
        return empleadoResponseRest;
    }

    @GetMapping("/empleado/{cedula}")
    public ResponseEntity<EmpleadoResponseRest> buscarEmpleado(@PathVariable String cedula){
        ResponseEntity<EmpleadoResponseRest> empleadoResponseRest = iEmpleadoService.buscarEmpleadoPorCedula(cedula);
        return empleadoResponseRest;
    }

}
