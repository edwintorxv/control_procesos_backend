package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.CiudadMunicipioResponseRest;
import control.procesos.controlProcesos.service.ICiudadMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controlProcesos")
public class CiudadMunicipioController {

    @Autowired
    private ICiudadMunicipioService iCiudadMunicipioService;

    @GetMapping("/ciudadMunicipio/{idDepartamento}")
    public ResponseEntity<CiudadMunicipioResponseRest> obteberCiudadMunicipioPorIdDepartamento(@PathVariable Integer idDepartamento){
        ResponseEntity<CiudadMunicipioResponseRest> ciudadMunicipioResponseRest = iCiudadMunicipioService.obtenerCiudadMunicipio(idDepartamento);
        return ciudadMunicipioResponseRest;
    }
}
