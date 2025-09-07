package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.EmpleadoFamiliar;
import lombok.Data;

import java.util.List;

@Data
public class EmpleadoFamiliarResponse {

    public List<EmpleadoFamiliar> lstEmpleadoFamiliar;

    public EmpleadoFamiliar empleadoFamiliar;
}
