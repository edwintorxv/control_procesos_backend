package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.ArchivoResponseRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IAlmacenamientoService {

    String crearCarpeta(String nombreCarpeta);

    ResponseEntity<ArchivoResponseRest> cargarArchivo(String ubicacion, MultipartFile archivo);

    ResponseEntity<byte[]> verArchivo(String ruta, String nombreArchivo);

}
