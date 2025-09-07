package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.CiudadMunicipio;
import control.procesos.controlProcesos.repository.ICiudadMunicipioRepository;
import control.procesos.controlProcesos.response.CiudadMunicipioResponseRest;
import control.procesos.controlProcesos.service.ICiudadMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadMunicipioServiceImpl implements ICiudadMunicipioService {

    @Autowired
    private ICiudadMunicipioRepository iCiudadMunicipioRepository;

    @Override
    public ResponseEntity<CiudadMunicipioResponseRest> obtenerCiudadMunicipio(Integer idDepartamento) {
        CiudadMunicipioResponseRest ciudadMunicipioResponseRest = new CiudadMunicipioResponseRest();
        try {
            List<CiudadMunicipio> lstCiudadMunicipio = iCiudadMunicipioRepository.lstCiudadMunicipioPorDepartamento(idDepartamento);
            if (lstCiudadMunicipio != null && !lstCiudadMunicipio.isEmpty()) {
                ciudadMunicipioResponseRest.getCiudadMunicipioResponse().setLstCiudadMunicipio(lstCiudadMunicipio);
                ciudadMunicipioResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
            } else {
                ciudadMunicipioResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<CiudadMunicipioResponseRest>(ciudadMunicipioResponseRest, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ciudadMunicipioResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    "" + e.getCause());
            return new ResponseEntity<CiudadMunicipioResponseRest>(ciudadMunicipioResponseRest, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CiudadMunicipioResponseRest>(ciudadMunicipioResponseRest, HttpStatus.OK);
    }
}
