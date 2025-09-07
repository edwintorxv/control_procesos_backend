package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.EmpleadoFamiliar;
import control.procesos.controlProcesos.response.EmpleadoFamiliarResponseRest;
import org.springframework.http.ResponseEntity;

public interface IEmpleadoFamiliarService {

    public ResponseEntity<EmpleadoFamiliarResponseRest> lstEmpleadoFamilar();

    public ResponseEntity<EmpleadoFamiliarResponseRest> crearEmpleadoFamiliar(EmpleadoFamiliar empleadoFamiliar);

    public ResponseEntity<EmpleadoFamiliarResponseRest> editarEmpleadoFamiliar(EmpleadoFamiliar empleadoFamiliar, Integer idEmpleadoFamiliar);

    public ResponseEntity<EmpleadoFamiliarResponseRest> lstFamiliarPorEmpleado(Integer idEmpleado);

    public ResponseEntity<EmpleadoFamiliarResponseRest> eliminarEmpleadoFamiliar(Integer idEmpleadoFamiliar);

}
