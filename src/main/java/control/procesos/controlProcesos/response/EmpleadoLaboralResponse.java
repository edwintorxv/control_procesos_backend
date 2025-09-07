package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.EmpleadoLaboral;
import lombok.Data;

import java.util.List;

@Data
public class EmpleadoLaboralResponse {

    public List<EmpleadoLaboral> lstEmpleadoLaboral;

    public EmpleadoLaboral empleadoLaboral;

}
