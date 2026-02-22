package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.EmpleadoLaboral;
import control.procesos.controlProcesos.repository.IEmpleadoLaboralRepository;
import control.procesos.controlProcesos.response.EmpleadoLaboralResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EmpleadoLaboralServiceImpl implements IEmpleadoLaboralService {

    @Autowired
    private IEmpleadoLaboralRepository iEmpleadoLaboralRepository;


    @Override
    public ResponseEntity<EmpleadoLaboralResponseRest> crearEmpleadoLaboral(EmpleadoLaboral empleadoLaboral) {
        EmpleadoLaboralResponseRest empleadoLaboralResponseRest = new EmpleadoLaboralResponseRest();
        try {
            Optional<EmpleadoLaboral> optionalEmpleadoLaboral = iEmpleadoLaboralRepository.optEmpleadoLaboral(empleadoLaboral.getNombreEmpresa(),
                    empleadoLaboral.getEmpleado().getId());

            if (optionalEmpleadoLaboral.isPresent()) {
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_CREACION_DUPLICADO);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.BAD_REQUEST);
            }

            EmpleadoLaboral crearEmpleadoLaboral = new EmpleadoLaboral();
            dataEmpleadoLaboral(crearEmpleadoLaboral, empleadoLaboral);
            iEmpleadoLaboralRepository.save(crearEmpleadoLaboral);

            empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_CREACION_OK);
            return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.OK);

        } catch (Exception e) {

            empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_CREACION_FALLIDA);
            return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<EmpleadoLaboralResponseRest> lstEmpleadoLaboralPoEmpleado(Integer idEmpleado) {
        EmpleadoLaboralResponseRest empleadoLaboralResponseRest = new EmpleadoLaboralResponseRest();

        try {
            List<EmpleadoLaboral> lstEmpleadoLaboral = iEmpleadoLaboralRepository.empleadoLaboralPorEmpleado(idEmpleado);
            System.out.print("Paso sin validar el breakpoint");
            if (!lstEmpleadoLaboral.isEmpty()) {
                empleadoLaboralResponseRest.getEmpleadoLaboralResponse().setLstEmpleadoLaboral(lstEmpleadoLaboral);
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.OK);
            } else {
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.OK);
            }
        } catch (Exception e) {
            empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmpleadoLaboralResponseRest> editarEmpleadolaboral(EmpleadoLaboral empleadoLaboral,
                                                                             Integer idEmpleadoLaboral) {
        EmpleadoLaboralResponseRest empleadoLaboralResponseRest = new EmpleadoLaboralResponseRest();

        try {
            Optional<EmpleadoLaboral> optionalEmpleadoLaboral = iEmpleadoLaboralRepository.findById(idEmpleadoLaboral);

            if (optionalEmpleadoLaboral.isPresent()) {
                EmpleadoLaboral editarEmpleadoLaboral = optionalEmpleadoLaboral.get();
                dataEmpleadoLaboral(editarEmpleadoLaboral, empleadoLaboral);
                iEmpleadoLaboralRepository.save(editarEmpleadoLaboral);

                List<EmpleadoLaboral> lstEmpleadoLaboral = new ArrayList<>();
                lstEmpleadoLaboral.add(editarEmpleadoLaboral);
                empleadoLaboralResponseRest.getEmpleadoLaboralResponse().setLstEmpleadoLaboral(lstEmpleadoLaboral);

                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_EDICION_OK);

                empleadoLaboralResponseRest.getEmpleadoLaboralResponse().setLstEmpleadoLaboral(lstEmpleadoLaboral);

                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.OK);


            } else {
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<EmpleadoLaboralResponseRest> eliminarEmpleadoLaboral(Integer idEmpladoLaboral) {
        EmpleadoLaboralResponseRest empleadoLaboralResponseRest = new EmpleadoLaboralResponseRest();

        try {
            Optional<EmpleadoLaboral> optEmpleadoLaboral = iEmpleadoLaboralRepository.findById(idEmpladoLaboral);

            if (optEmpleadoLaboral.isPresent()) {
                iEmpleadoLaboralRepository.deleteById(idEmpladoLaboral);
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_ELIMINACION_OK);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.OK);
            } else {
                empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
                return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            empleadoLaboralResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_ELIMINACION_FALLIDA);
            return new ResponseEntity<EmpleadoLaboralResponseRest>(empleadoLaboralResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private void dataEmpleadoLaboral(EmpleadoLaboral destinoEmpleadoLaboral, EmpleadoLaboral origenEmpleadoLaboral) {

        destinoEmpleadoLaboral.setEmpleado(origenEmpleadoLaboral.getEmpleado());
        destinoEmpleadoLaboral.setNombreEmpresa(origenEmpleadoLaboral.getNombreEmpresa());
        destinoEmpleadoLaboral.setDireccionEmpresa(origenEmpleadoLaboral.getDireccionEmpresa());
        destinoEmpleadoLaboral.setTelefono(origenEmpleadoLaboral.getTelefono());
        destinoEmpleadoLaboral.setNombreJefeDirecto(origenEmpleadoLaboral.getNombreJefeDirecto());
        destinoEmpleadoLaboral.setCargoDesempenio(origenEmpleadoLaboral.getCargoDesempenio());
        destinoEmpleadoLaboral.setFechaIngreso(origenEmpleadoLaboral.getFechaIngreso());
        destinoEmpleadoLaboral.setFechaRetiro(origenEmpleadoLaboral.getFechaRetiro());

    }

}
