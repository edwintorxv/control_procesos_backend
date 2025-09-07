package control.procesos.controlProcesos.service;

import org.springframework.web.multipart.MultipartFile;

public interface IAlmacenamientoService {

    String crearCarpeta(String nombreCarpeta);

    String cargarArchivo(String ubicacion, MultipartFile archivo);



}
