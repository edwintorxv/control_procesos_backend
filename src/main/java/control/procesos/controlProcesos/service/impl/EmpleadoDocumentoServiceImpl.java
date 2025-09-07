package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.EmpleadoDocumento;
import control.procesos.controlProcesos.repository.IEmpleadoDocumentoRepository;
import control.procesos.controlProcesos.response.EmpleadoDocumentoResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoDocumentoServiceImpl implements IEmpleadoDocumentoService {

    @Autowired
    private IEmpleadoDocumentoRepository iEmpleadoDocumentoRepository;

    @Override
    public ResponseEntity<EmpleadoDocumentoResponseRest> lstEmpleadoDocumento() {
        EmpleadoDocumentoResponseRest empleadoDocumentoResponseRest = new EmpleadoDocumentoResponseRest();
        try {
            List<EmpleadoDocumento> lstEmpleadoDocumento = iEmpleadoDocumentoRepository.findAll();

            if (!lstEmpleadoDocumento.isEmpty()) {
                empleadoDocumentoResponseRest.getEmpleadoDocumentoResponse().setLstEmpleadoDocumento(lstEmpleadoDocumento);

                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.OK);
            } else {
                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmpleadoDocumentoResponseRest> crearEmpleadoDocumento(EmpleadoDocumento empleadoDocumento) {
        EmpleadoDocumentoResponseRest empleadoDocumentoResponseRest = new EmpleadoDocumentoResponseRest();
        try {
            Optional<EmpleadoDocumento> optionalEmpleadoDocumento = iEmpleadoDocumentoRepository.validarExistenciaEmpleadoDocumento(empleadoDocumento
                    .getEmpleado().getId(), empleadoDocumento.getDocumentoMaestro().getId());

            if (optionalEmpleadoDocumento.isPresent()) {
                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_DUPLICADO);
                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.BAD_REQUEST);
            }

            EmpleadoDocumento crearEmpleadoDocumento = new EmpleadoDocumento();
            mapearDataDocumentoEmpleado(crearEmpleadoDocumento, empleadoDocumento);
            iEmpleadoDocumentoRepository.save(crearEmpleadoDocumento);

            empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_CREACION_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);
            return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.OK);
        } catch (Exception e) {
            empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_CREACION_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmpleadoDocumentoResponseRest> eliminarEmpleadoDocumento(Integer idDocumentoEmpleado) {
        EmpleadoDocumentoResponseRest empleadoDocumentoResponseRest = new EmpleadoDocumentoResponseRest();

        try {
            Optional<EmpleadoDocumento> optionalEmpleadoDocumento = iEmpleadoDocumentoRepository.findById(idDocumentoEmpleado);
            if (optionalEmpleadoDocumento.isPresent()) {
                iEmpleadoDocumentoRepository.deleteById(idDocumentoEmpleado);

                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_ELIMINACION_OK);

                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.OK);
            } else {
                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);

                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);

            return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmpleadoDocumentoResponseRest> lstEmpleadoDocumentoPorEmpleado(Integer idEmpleado) {
        EmpleadoDocumentoResponseRest empleadoDocumentoResponseRest = new EmpleadoDocumentoResponseRest();

        try {
            List<EmpleadoDocumento> lstEmpleadoDocumento = iEmpleadoDocumentoRepository.lstDocumentoPorEmpleado(idEmpleado);
            if (lstEmpleadoDocumento != null && !lstEmpleadoDocumento.isEmpty()) {
                empleadoDocumentoResponseRest.getEmpleadoDocumentoResponse().setLstEmpleadoDocumento(lstEmpleadoDocumento);
                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.OK);
            } else {
                empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.OK);
            }
        } catch (Exception e) {
            empleadoDocumentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoDocumentoResponseRest>(empleadoDocumentoResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void mapearDataDocumentoEmpleado(EmpleadoDocumento empleadoDocumentoDestino, EmpleadoDocumento empleadoDocumentoOrigen) {
        empleadoDocumentoDestino.setEmpleado(empleadoDocumentoOrigen.getEmpleado());
        empleadoDocumentoDestino.setDocumentoMaestro(empleadoDocumentoOrigen.getDocumentoMaestro());
        empleadoDocumentoDestino.setFechaInicial(empleadoDocumentoOrigen.getFechaInicial());
        empleadoDocumentoDestino.setFechaVencimiento(empleadoDocumentoOrigen.getFechaVencimiento());
        empleadoDocumentoDestino.setUrlArchivo(empleadoDocumentoOrigen.getUrlArchivo());
        empleadoDocumentoDestino.setNombreArchivo(empleadoDocumentoOrigen.getNombreArchivo());
    }

}
