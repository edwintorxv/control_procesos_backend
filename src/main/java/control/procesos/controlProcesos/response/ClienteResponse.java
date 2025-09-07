package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.Cliente;
import lombok.Data;

import java.util.List;

@Data
public class ClienteResponse {

    private List<Cliente> lstCliente;

    private Cliente cliente;
}
