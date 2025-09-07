package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.EmpleadoFamiliar;
import control.procesos.controlProcesos.repository.IEmpleadoFamiliarRepository;
import control.procesos.controlProcesos.response.EmpleadoFamiliarResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoFamiliarServiceImpl implements IEmpleadoFamiliarService {

    @Autowired
    private IEmpleadoFamiliarRepository iEmpleadoFamiliarRepository;


    @Override
    public ResponseEntity<EmpleadoFamiliarResponseRest> lstEmpleadoFamilar() {

        EmpleadoFamiliarResponseRest empleadoFamiliarResponseRest = new EmpleadoFamiliarResponseRest();

        try {
            List<EmpleadoFamiliar> lstEmpleadoFamiliar = iEmpleadoFamiliarRepository.findAll();
            if (!lstEmpleadoFamiliar.isEmpty()) {
                empleadoFamiliarResponseRest.getEmpleadoFamiliarResponse().setLstEmpleadoFamiliar(lstEmpleadoFamiliar);

                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.OK);

            } else {
                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmpleadoFamiliarResponseRest> crearEmpleadoFamiliar(EmpleadoFamiliar empleadoFamiliar) {
        EmpleadoFamiliarResponseRest empleadoFamiliarResponseRest = new EmpleadoFamiliarResponseRest();

        try {
            Optional<EmpleadoFamiliar> optionalEmpleadoFamiliar = iEmpleadoFamiliarRepository.optionalEmpleadoFamiliar(empleadoFamiliar.getEmpleado().getId(),
                    empleadoFamiliar.getNumeroIdentificacion());

            if (optionalEmpleadoFamiliar.isPresent()) {
                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_DUPLICADO);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.BAD_REQUEST);
            }

            EmpleadoFamiliar nuevoEmpleadoFamiliar = new EmpleadoFamiliar();
            dataEmpleadoFamiliar(nuevoEmpleadoFamiliar, empleadoFamiliar);
            iEmpleadoFamiliarRepository.save(nuevoEmpleadoFamiliar);

            List<EmpleadoFamiliar> lstEmpleadoFamiliar = new ArrayList<>();

            lstEmpleadoFamiliar.add(nuevoEmpleadoFamiliar);
            empleadoFamiliarResponseRest.getEmpleadoFamiliarResponse().setLstEmpleadoFamiliar(lstEmpleadoFamiliar);

            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmpleadoFamiliarResponseRest> editarEmpleadoFamiliar(EmpleadoFamiliar empleadoFamiliar, Integer idEmpleadoFamiliar) {
        EmpleadoFamiliarResponseRest empleadoFamiliarResponseRest = new EmpleadoFamiliarResponseRest();
        try {
            Optional<EmpleadoFamiliar> optionalEmpleadoFamiliar = iEmpleadoFamiliarRepository.optionalEmpleadoFamiliar(empleadoFamiliar.getEmpleado().getId(),
                    empleadoFamiliar.getNumeroIdentificacion());

            if (optionalEmpleadoFamiliar.isPresent()) {

                EmpleadoFamiliar editarEmpleadoFamiliar = optionalEmpleadoFamiliar.get();
                dataEmpleadoFamiliar(editarEmpleadoFamiliar, empleadoFamiliar);
                iEmpleadoFamiliarRepository.save(editarEmpleadoFamiliar);

                List<EmpleadoFamiliar> lstEmpleadoFamiliar = new ArrayList<>();

                lstEmpleadoFamiliar.add(editarEmpleadoFamiliar);
                empleadoFamiliarResponseRest.getEmpleadoFamiliarResponse().setLstEmpleadoFamiliar(lstEmpleadoFamiliar);

                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_EDICION_OK);
                empleadoFamiliarResponseRest.getEmpleadoFamiliarResponse().setEmpleadoFamiliar(editarEmpleadoFamiliar);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.OK);

            } else {

                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmpleadoFamiliarResponseRest> lstFamiliarPorEmpleado(Integer idEmpleado) {
        EmpleadoFamiliarResponseRest empleadoFamiliarResponseRest = new EmpleadoFamiliarResponseRest();

        try {
            List<EmpleadoFamiliar> lstEmpleadoFamiliar = iEmpleadoFamiliarRepository.lstEmpleadoFamiliar(idEmpleado);

            if (!lstEmpleadoFamiliar.isEmpty()) {
                empleadoFamiliarResponseRest.getEmpleadoFamiliarResponse().setLstEmpleadoFamiliar(lstEmpleadoFamiliar);
                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.OK);
            } else {
                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmpleadoFamiliarResponseRest> eliminarEmpleadoFamiliar(Integer idEmpleadoFamiliar) {

        EmpleadoFamiliarResponseRest empleadoFamiliarResponseRest = new EmpleadoFamiliarResponseRest();

        try {
            Optional<EmpleadoFamiliar> optionalEmpleadoFamiliar = iEmpleadoFamiliarRepository.findById(idEmpleadoFamiliar);
            if (optionalEmpleadoFamiliar.isPresent()) {
                iEmpleadoFamiliarRepository.deleteById(idEmpleadoFamiliar);

                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_ELIMINACION_OK);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.OK);
            } else {
                empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
                return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
            return new ResponseEntity<EmpleadoFamiliarResponseRest>(empleadoFamiliarResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void dataEmpleadoFamiliar(EmpleadoFamiliar destinoEmpleadoFamiliar, EmpleadoFamiliar origenEmpleadoFamiliar) {

        destinoEmpleadoFamiliar.setNombre(origenEmpleadoFamiliar.getNombre());
        destinoEmpleadoFamiliar.setApellido(origenEmpleadoFamiliar.getApellido());
        destinoEmpleadoFamiliar.setNumeroIdentificacion(origenEmpleadoFamiliar.getNumeroIdentificacion());
        destinoEmpleadoFamiliar.setNumeroTelefono(origenEmpleadoFamiliar.getNumeroTelefono());
        destinoEmpleadoFamiliar.setTipoFamiliar(origenEmpleadoFamiliar.getTipoFamiliar());
        destinoEmpleadoFamiliar.setDocumentoMaestro(origenEmpleadoFamiliar.getDocumentoMaestro());
        destinoEmpleadoFamiliar.setEmpleado(origenEmpleadoFamiliar.getEmpleado());
        destinoEmpleadoFamiliar.setViveConEmpleado(origenEmpleadoFamiliar.getViveConEmpleado());

    }
}
