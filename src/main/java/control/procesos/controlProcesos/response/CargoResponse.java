package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.Cargo;
import lombok.Data;

import java.util.List;

@Data
public class CargoResponse {
    public List<Cargo> lstCargo;
}
