package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.Empleado;
import lombok.Data;

import java.util.List;

@Data
public class EmpleadoResponse {

    public List<Empleado> lstEmpleado;

    public Empleado empleado;

}
