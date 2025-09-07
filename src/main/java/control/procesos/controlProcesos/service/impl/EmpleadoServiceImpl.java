package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Empleado;
import control.procesos.controlProcesos.repository.IEmpleadoRepository;
import control.procesos.controlProcesos.response.EmpleadoResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Override
    public ResponseEntity<EmpleadoResponseRest> lstEmpleados() {
        EmpleadoResponseRest empleadoResponseRest = new EmpleadoResponseRest();
        try {
            List<Empleado> lstEmpleado = iEmpleadoRepository.findAll();
            empleadoResponseRest.getEmpleadoResponse().setLstEmpleado(lstEmpleado);
            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmpleadoResponseRest> crearEmpleado(Empleado empleado) {
        EmpleadoResponseRest empleadoResponseRest = new EmpleadoResponseRest();
        try {
            Optional<Empleado> optionalEmpleado = iEmpleadoRepository.buscarPorNumeroIdentificacion(empleado.getNumeroIdentificacion());

            if (optionalEmpleado.isPresent()) {
                empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_CREACION_DUPLICADO, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_FALLIDA);
                return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.BAD_REQUEST);
            }

            Empleado nuevoEmpleado = new Empleado();
            mapearDatosEmpleado(nuevoEmpleado, empleado);
            iEmpleadoRepository.save(nuevoEmpleado);

            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);
            return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA);
            return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmpleadoResponseRest> buscarEmpleadoPorCedula(String cedula) {
        EmpleadoResponseRest empleadoResponseRest = new EmpleadoResponseRest();

        try {
            Optional<Empleado> optEmpleado = iEmpleadoRepository.buscarPorNumeroIdentificacion(cedula);

            if (optEmpleado.isPresent()) {
                empleadoResponseRest.getEmpleadoResponse().setEmpleado(optEmpleado.get());
                empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_BUSQUEDA_OK);
                return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.OK);
            } else {
                empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoResponseRest>(empleadoResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmpleadoResponseRest> editarEmpleado(Empleado empleado, Integer idEmpleado) {
        EmpleadoResponseRest empleadoResponseRest = new EmpleadoResponseRest();
        try {
            Optional<Empleado> optionalEmpleado = iEmpleadoRepository.findById(idEmpleado);

            if (optionalEmpleado.isPresent()) {

                Empleado empleadoExistente = optionalEmpleado.get();
                mapearDatosEmpleado(empleadoExistente, empleado);
                iEmpleadoRepository.save(empleadoExistente);

                empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK,
                        MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_EDICION_OK);
                empleadoResponseRest.getEmpleadoResponse().setEmpleado(empleadoExistente);
                return new ResponseEntity<>(empleadoResponseRest, HttpStatus.OK);
            } else {
                empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA,
                        MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<>(empleadoResponseRest, HttpStatus.OK);
            }

        } catch (Exception e) {
            empleadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA,
                    MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<>(empleadoResponseRest, HttpStatus.OK);
        }
    }

    private void mapearDatosEmpleado(Empleado empleadoDestino, Empleado empleadoFuente) {

        empleadoDestino.setNombre(empleadoFuente.getNombre());
        empleadoDestino.setApellido(empleadoFuente.getApellido());
        empleadoDestino.setFechaNacimiento(empleadoFuente.getFechaNacimiento());
        empleadoDestino.setDocumentoMaestro(empleadoFuente.getDocumentoMaestro());
        empleadoDestino.setNumeroIdentificacion(empleadoFuente.getNumeroIdentificacion());
        empleadoDestino.setCiudadMunicipio(empleadoFuente.getCiudadMunicipio());
        empleadoDestino.setDireccionResidencia(empleadoFuente.getDireccionResidencia());
        empleadoDestino.setNumeroTelefono(empleadoFuente.getNumeroTelefono());
        empleadoDestino.setNivelAcademico(empleadoFuente.getNivelAcademico());
        empleadoDestino.setEstadoCivil(empleadoFuente.getEstadoCivil());
        empleadoDestino.setCargo(empleadoFuente.getCargo());
        empleadoDestino.setEstado(empleadoFuente.getEstado());
        empleadoDestino.setFechaIngreso(empleadoFuente.getFechaIngreso());
        empleadoDestino.setFechaRetiro(empleadoFuente.getFechaRetiro());

    }

}
