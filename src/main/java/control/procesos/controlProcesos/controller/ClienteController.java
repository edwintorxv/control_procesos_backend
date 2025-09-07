package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.Cliente;
import control.procesos.controlProcesos.response.ClienteResponseRest;
import control.procesos.controlProcesos.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controlProcesos")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponseRest> crearCliente(@RequestBody Cliente cliente) {
        ResponseEntity<ClienteResponseRest> crearClienteResponseRest = iClienteService.crearCliente(cliente);
        return crearClienteResponseRest;
    }

    @GetMapping("/cliente")
    public ResponseEntity<ClienteResponseRest> lstClientes() {
        ResponseEntity<ClienteResponseRest> clienteResponseRest = iClienteService.lstClientes();
        return clienteResponseRest;
    }

    @PutMapping("cliente/{idCliente}")
    public ResponseEntity<ClienteResponseRest> editarCliente(@RequestBody Cliente cliente, @PathVariable Integer idCliente) {
        ResponseEntity<ClienteResponseRest> clienteResponseRest = iClienteService.editarCliente(cliente, idCliente);
        return clienteResponseRest;
    }

    @DeleteMapping("/cliente/{idCliente}")
    public ResponseEntity<ClienteResponseRest> eliminarCliente(@PathVariable  Integer idCliente) {
        ResponseEntity<ClienteResponseRest> clienteResponseRest = iClienteService.eliminarCliente(idCliente);
        return clienteResponseRest;
    }
}
