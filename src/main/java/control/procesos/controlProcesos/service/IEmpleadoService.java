package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.Empleado;
import control.procesos.controlProcesos.response.EmpleadoResponseRest;
import org.springframework.http.ResponseEntity;

public interface IEmpleadoService {

    public ResponseEntity<EmpleadoResponseRest> lstEmpleados();

    public ResponseEntity<EmpleadoResponseRest> crearEmpleado(Empleado empleado);

    public ResponseEntity<EmpleadoResponseRest> buscarEmpleadoPorCedula(String cedula);

    public ResponseEntity<EmpleadoResponseRest> editarEmpleado(Empleado empleado, Integer idEmpleado);
}
