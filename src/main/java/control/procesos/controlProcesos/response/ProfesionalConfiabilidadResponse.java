package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.ProfesionalConfiabilidad;
import lombok.Data;

import java.util.List;

@Data
public class ProfesionalConfiabilidadResponse {

    public List<ProfesionalConfiabilidad> lstProfesionaConfiabilidad;
}
