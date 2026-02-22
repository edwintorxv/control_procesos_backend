package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Cliente;
import control.procesos.controlProcesos.repository.IClienteRespository;
import control.procesos.controlProcesos.response.ClienteResponseRest;
import control.procesos.controlProcesos.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRespository iClienteRespository;

    @Override
    public ResponseEntity<ClienteResponseRest> crearCliente(Cliente cliente) {
        ClienteResponseRest clienteResponseRest = new ClienteResponseRest();

        try {
            Optional<Cliente> opCliente = iClienteRespository.validacionExisteCliente(cliente.getNit());

            if (opCliente.isPresent()) {
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_DUPLICADO);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
            }

            Cliente crearCliente = new Cliente();
            dataCliente(crearCliente, cliente);
            iClienteRespository.save(crearCliente);
            List<Cliente> lstCliente = new ArrayList<>();

            lstCliente.add(crearCliente);

            clienteResponseRest.getClienteResponse().setLstCliente(lstCliente);
            clienteResponseRest.getClienteResponse().setLstCliente(lstCliente);
            clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);

            return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA);

            return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ClienteResponseRest> lstClientes() {
        ClienteResponseRest clienteResponseRest = new ClienteResponseRest();

        try {
            List<Cliente> lstClientes = iClienteRespository.findAll();

            if (!lstClientes.isEmpty()) {
                clienteResponseRest.getClienteResponse().setLstCliente(lstClientes);
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.OK);
            } else {
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClienteResponseRest> editarCliente(Cliente cliente, Integer idCliente) {
        ClienteResponseRest clienteResponseRest = new ClienteResponseRest();

        try {
            Optional<Cliente> opCliente = iClienteRespository.findById(idCliente);

            if (opCliente.isPresent()) {

                Cliente editarCliente = opCliente.get();
                dataCliente(editarCliente, cliente);
                iClienteRespository.save(editarCliente);
                List<Cliente> lstCliente = new ArrayList<>();
                lstCliente.add(editarCliente);

                clienteResponseRest.getClienteResponse().setLstCliente(lstCliente);
                clienteResponseRest.getClienteResponse().setLstCliente(lstCliente);
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_EDICION_OK);

                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.OK);
            } else {
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ClienteResponseRest> eliminarCliente(Integer idCliente) {
        ClienteResponseRest clienteResponseRest = new ClienteResponseRest();

        try {
            Optional<Cliente> optCliente = iClienteRespository.findById(idCliente);
            if (optCliente.isPresent()) {
                iClienteRespository.deleteById(idCliente);
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_ELIMINACION_OK);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.OK);
            } else {
                clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
                return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            clienteResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
            return new ResponseEntity<ClienteResponseRest>(clienteResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void dataCliente(Cliente destinoCliente, Cliente origenCliente) {

        destinoCliente.setNombre(origenCliente.getNombre());
        destinoCliente.setNit(origenCliente.getNit());
        destinoCliente.setDireccion(origenCliente.getDireccion());
        destinoCliente.setRepresentante(origenCliente.getRepresentante());
        destinoCliente.setTelefono(origenCliente.getTelefono());
        destinoCliente.setEstado(origenCliente.getEstado());
        destinoCliente.setCiudadMunicipio(origenCliente.getCiudadMunicipio());

    }

}
