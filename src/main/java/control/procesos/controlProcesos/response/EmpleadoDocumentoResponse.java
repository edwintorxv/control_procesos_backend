package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.EmpleadoDocumento;
import lombok.Data;

import java.util.List;

@Data
public class EmpleadoDocumentoResponse {

    public List<EmpleadoDocumento> lstEmpleadoDocumento;

    public EmpleadoDocumento empleadoDocumento;


}
