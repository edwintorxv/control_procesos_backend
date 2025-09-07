package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.ProcesoConfiabilidad;
import control.procesos.controlProcesos.repository.IProcesoConfiabilidadRepository;
import control.procesos.controlProcesos.response.ProcesoConfiabilidadResponseRest;
import control.procesos.controlProcesos.service.IProcesoConfiabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoConfiabilidadServiceImpl implements IProcesoConfiabilidadService {

    @Autowired
    private IProcesoConfiabilidadRepository iProcesoConfiabilidadRepository;

    @Override
    public ResponseEntity<ProcesoConfiabilidadResponseRest> crearProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad) {
        ProcesoConfiabilidadResponseRest procesoConfiabilidadResponseRest = new ProcesoConfiabilidadResponseRest();

        try {
            Optional<ProcesoConfiabilidad> optionalProcesoConfiabilidad = iProcesoConfiabilidadRepository
                    .optValidarSolicitudEnCusro(procesoConfiabilidad.getIdentificacion(),
                            procesoConfiabilidad.getFechaSolicitud(), procesoConfiabilidad.getDocumentoMaestro().getId());

            if (optionalProcesoConfiabilidad.isPresent()) {
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_DUPLICADO);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.BAD_REQUEST);
            }

            ProcesoConfiabilidad crearProcesoConfiabilidad = new ProcesoConfiabilidad();
            dataProcesoConfiabilidad(crearProcesoConfiabilidad, procesoConfiabilidad);
            iProcesoConfiabilidadRepository.save(crearProcesoConfiabilidad);

            procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);
            return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA + " " + e.getCause());
            return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProcesoConfiabilidadResponseRest> lstProcesoConfiabilidadPorEstado(String estadoProceso) {
        ProcesoConfiabilidadResponseRest procesoConfiabilidadResponseRest = new ProcesoConfiabilidadResponseRest();

        try {
            List<ProcesoConfiabilidad> lstProcescoConfiabilidad = iProcesoConfiabilidadRepository.lstProcesoConfiabilidadPendiente(estadoProceso);
            if (!lstProcescoConfiabilidad.isEmpty()) {
                procesoConfiabilidadResponseRest.getProcesoConfiabilidadResponse().setLstProcesoConfiabilidad(lstProcescoConfiabilidad);
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);

            } else {
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
            return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ProcesoConfiabilidadResponseRest> editarProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidad, Integer idProceso) {
        ProcesoConfiabilidadResponseRest procesoConfiabilidadResponseRest = new ProcesoConfiabilidadResponseRest();

        try {
            Optional<ProcesoConfiabilidad> optionalProcesoConfiabilidad = iProcesoConfiabilidadRepository.findById(idProceso);

            if (optionalProcesoConfiabilidad.isPresent()) {
                ProcesoConfiabilidad editarProcesoConfiabilidad = optionalProcesoConfiabilidad.get();
                dataProcesoConfiabilidad(editarProcesoConfiabilidad, procesoConfiabilidad);
                iProcesoConfiabilidadRepository.save(editarProcesoConfiabilidad);

                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_EDICION_OK);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);
            } else {
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA + " " + e.getCause());
            return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProcesoConfiabilidadResponseRest> lsrProcesoConfiabilidadPorCliente(Integer fkCliente) {
        ProcesoConfiabilidadResponseRest procesoConfiabilidadResponseRest = new ProcesoConfiabilidadResponseRest();

        try {
            List<ProcesoConfiabilidad> lstProcescoConfiabilidad = iProcesoConfiabilidadRepository.lstProcesoConfiabilidadCliente(fkCliente);
            System.out.println("Listado procesos por cliente");

            if (!lstProcescoConfiabilidad.isEmpty()) {
                procesoConfiabilidadResponseRest.getProcesoConfiabilidadResponse().setLstProcesoConfiabilidad(lstProcescoConfiabilidad);
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);

            } else {
                procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            procesoConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
            return new ResponseEntity<ProcesoConfiabilidadResponseRest>(procesoConfiabilidadResponseRest, HttpStatus.OK);
        }
    }

    private void dataProcesoConfiabilidad(ProcesoConfiabilidad procesoConfiabilidadDestino, ProcesoConfiabilidad procesoConfiabilidadOrigen) {

        procesoConfiabilidadDestino.setCliente(procesoConfiabilidadOrigen.getCliente());
        procesoConfiabilidadDestino.setNombre(procesoConfiabilidadOrigen.getNombre());
        procesoConfiabilidadDestino.setApellido(procesoConfiabilidadOrigen.getApellido());
        procesoConfiabilidadDestino.setIdentificacion(procesoConfiabilidadOrigen.getIdentificacion());
        procesoConfiabilidadDestino.setTelefono(procesoConfiabilidadOrigen.getTelefono());
        procesoConfiabilidadDestino.setDocumentoMaestro(procesoConfiabilidadOrigen.getDocumentoMaestro());
        procesoConfiabilidadDestino.setConcepto(procesoConfiabilidadOrigen.getConcepto());
        procesoConfiabilidadDestino.setFechaSolicitud(procesoConfiabilidadOrigen.getFechaSolicitud());
        procesoConfiabilidadDestino.setFechaAtencion(procesoConfiabilidadOrigen.getFechaAtencion());
        procesoConfiabilidadDestino.setAmpliacion(procesoConfiabilidadOrigen.getAmpliacion());
        procesoConfiabilidadDestino.setEstadoProceso(procesoConfiabilidadOrigen.getEstadoProceso());
        procesoConfiabilidadDestino.setProfesionalConfiabilidad(procesoConfiabilidadOrigen.getProfesionalConfiabilidad());
        procesoConfiabilidadDestino.setFechaCreacion(procesoConfiabilidadOrigen.getFechaCreacion());
        procesoConfiabilidadDestino.setUrlArchivo(procesoConfiabilidadOrigen.getUrlArchivo());
        procesoConfiabilidadDestino.setNombreArchivo(procesoConfiabilidadOrigen.getNombreArchivo());

    }

}
