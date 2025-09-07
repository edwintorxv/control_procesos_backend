package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.TipoFamiliar;
import control.procesos.controlProcesos.repository.ITipoFamiliarRepository;
import control.procesos.controlProcesos.response.TipoFamiliarResponseRest;
import control.procesos.controlProcesos.service.ITipoFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoFamiliarServiceImpl implements ITipoFamiliarService {

    @Autowired
    private ITipoFamiliarRepository iTipoFamiliarRepository;

    @Override
    public ResponseEntity<TipoFamiliarResponseRest> obtenetTipoFaimilar() {
        TipoFamiliarResponseRest tipoFamiliarResponseRest = new TipoFamiliarResponseRest();

        try {
            List<TipoFamiliar> lstTipoFamilar = iTipoFamiliarRepository.findAll();
            tipoFamiliarResponseRest.getTipoFamiliarResponse().setLstTipoFamiliar(lstTipoFamilar);

            tipoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
            return new ResponseEntity<TipoFamiliarResponseRest>(tipoFamiliarResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            tipoFamiliarResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);

            return new ResponseEntity<TipoFamiliarResponseRest>(tipoFamiliarResponseRest, HttpStatus.OK);
        }
    }
}
