package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.Departamento;
import lombok.Data;

import java.util.List;

@Data
public class DepartamentoResponse {

    public List<Departamento> lstDepartamento;
}
