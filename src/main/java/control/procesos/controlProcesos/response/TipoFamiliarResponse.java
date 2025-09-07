package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.TipoFamiliar;
import lombok.Data;

import java.util.List;

@Data
public class TipoFamiliarResponse {

    public List<TipoFamiliar> lstTipoFamiliar;
}
