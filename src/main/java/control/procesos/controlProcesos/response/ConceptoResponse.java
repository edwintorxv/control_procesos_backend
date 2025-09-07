package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.Concepto;
import lombok.Data;

import java.util.List;

@Data
public class ConceptoResponse {

    private List<Concepto> lstConcepto;
}
