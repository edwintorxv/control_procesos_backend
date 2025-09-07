package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Departamento;
import control.procesos.controlProcesos.repository.IDepartamentoRepository;
import control.procesos.controlProcesos.response.DepartamentoResponseRest;
import control.procesos.controlProcesos.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository iDepartamentoRepository;


    @Override
    public ResponseEntity<DepartamentoResponseRest> obtenerDepartamentos() {
        DepartamentoResponseRest departamentoResponseRest = new DepartamentoResponseRest();
        try {
            List<Departamento> lstDepartamento = iDepartamentoRepository.findAll();
            departamentoResponseRest.getDepartamentoResponse().setLstDepartamento(lstDepartamento);
            departamentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            departamentoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    "" + e.getCause());
            return new ResponseEntity<DepartamentoResponseRest>(departamentoResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<DepartamentoResponseRest>(departamentoResponseRest, HttpStatus.OK);
    }
}
