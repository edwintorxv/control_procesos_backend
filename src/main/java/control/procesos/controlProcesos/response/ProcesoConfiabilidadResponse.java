package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import lombok.Data;

import java.util.List;

@Data
public class ProcesoConfiabilidadResponse {

    public List<ProcesoConfiabilidad> lstProcesoConfiabilidad;

    public ProcesoConfiabilidad procesoConfiabilidad;

}
