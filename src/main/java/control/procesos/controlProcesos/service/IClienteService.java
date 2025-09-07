package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.entity.Cliente;
import control.procesos.controlProcesos.response.ClienteResponseRest;
import org.springframework.http.ResponseEntity;

public interface IClienteService {

    public ResponseEntity<ClienteResponseRest> crearCliente(Cliente cliente);

    public ResponseEntity<ClienteResponseRest> lstClientes();

    public ResponseEntity<ClienteResponseRest> editarCliente(Cliente cliente, Integer idCliente);

    public ResponseEntity<ClienteResponseRest> eliminarCliente(Integer idCliente);

}
