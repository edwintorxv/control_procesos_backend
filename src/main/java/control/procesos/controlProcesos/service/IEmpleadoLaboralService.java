package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.EmpleadoLaboral;
import control.procesos.controlProcesos.response.EmpleadoLaboralResponseRest;
import org.springframework.http.ResponseEntity;

public interface IEmpleadoLaboralService {

    public ResponseEntity<EmpleadoLaboralResponseRest> crearEmpleadoLaboral(EmpleadoLaboral empleadoLaboral);

    public ResponseEntity<EmpleadoLaboralResponseRest> lstEmpleadoLaboralPoEmpleado(Integer idEmpleado);

    public ResponseEntity<EmpleadoLaboralResponseRest> editarEmpleadolaboral (EmpleadoLaboral empleadoLaboral,
                                                                              Integer idEmpleadoLaboral);

    public ResponseEntity<EmpleadoLaboralResponseRest> eliminarEmpleadoLaboral (Integer idEmpladoLaboral);
}
