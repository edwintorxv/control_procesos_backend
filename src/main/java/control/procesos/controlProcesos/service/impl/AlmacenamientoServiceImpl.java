package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.enums.Directorios;
import control.procesos.controlProcesos.enums.RespuestaArchivo;
import control.procesos.controlProcesos.service.IAlmacenamientoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class AlmacenamientoServiceImpl implements IAlmacenamientoService {

    private final static long LIMITE_ARCHIVO_PDF = 5242880;

    @Override
    public String crearCarpeta(String nombreCarpeta) {
        File carpeta = new File(Directorios.UNIDAD_ALMACENAMIENTO.getParametroDirectorio(), nombreCarpeta);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        return carpeta.getAbsolutePath();
    }

    @Override
    public String cargarArchivo(String ubicacion, MultipartFile archivo) {
        try {

            if (archivo.getSize() > LIMITE_ARCHIVO_PDF) {
                return RespuestaArchivo.LIMITE_SUPERADO.getDescripcion();
            }

            if (!Objects.requireNonNull(archivo.getOriginalFilename()).endsWith(RespuestaArchivo.FORMATO_PDF.getDescripcion())) {
                return String.format(RespuestaArchivo.FORMATO_INCORRECTO.getDescripcion(), archivo.getOriginalFilename());
            }

            Path ruta = Paths.get(ubicacion + "/" + archivo.getOriginalFilename());

            byte[] bytes = archivo.getBytes();

            Files.write(ruta, bytes);

        } catch (Exception e) {
            return e.getMessage();
        }
        return ubicacion;
    }
}
