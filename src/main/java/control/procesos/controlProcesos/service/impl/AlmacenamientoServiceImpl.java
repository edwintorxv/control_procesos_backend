package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.enums.Directorios;
import control.procesos.controlProcesos.enums.RespuestaArchivo;
import control.procesos.controlProcesos.response.ArchivoResponseRest;
import control.procesos.controlProcesos.service.IAlmacenamientoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArchivoResponseRest> cargarArchivo(String ubicacion, MultipartFile archivo) {

        ArchivoResponseRest archivoResponseRest = new ArchivoResponseRest();

        try {

            if (archivo.getSize() > LIMITE_ARCHIVO_PDF) {
                archivoResponseRest.setMetadata(
                        MensajesConstantes.RESPUESTA_FALLIDA,
                        MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        RespuestaArchivo.LIMITE_SUPERADO.getDescripcion()
                );
                return new ResponseEntity<>(archivoResponseRest, HttpStatus.BAD_REQUEST);
            }

            if (!Objects.requireNonNull(archivo.getOriginalFilename()).endsWith(RespuestaArchivo.FORMATO_PDF.getDescripcion())) {
                archivoResponseRest.setMetadata(
                        MensajesConstantes.RESPUESTA_FALLIDA,
                        MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        RespuestaArchivo.FORMATO_INCORRECTO.getDescripcion()
                );
                return new ResponseEntity<>(archivoResponseRest, HttpStatus.BAD_REQUEST);
            }

            Path ruta = Paths.get(ubicacion + "/" + archivo.getOriginalFilename());

            byte[] bytes = archivo.getBytes();

            Files.write(ruta, bytes);

            archivoResponseRest.setMetadata(
                    MensajesConstantes.RESPUESTA_OK,
                    MensajesConstantes.RESPUESTA_CODIGO_OK,
                    RespuestaArchivo.CARGA_EXITOSA.getDescripcion()
            );

            return new ResponseEntity<>(archivoResponseRest, HttpStatus.OK);

        } catch (Exception e) {
            archivoResponseRest.setMetadata(
                    MensajesConstantes.RESPUESTA_FALLIDA,
                    MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    e.getMessage()
            );

            return new ResponseEntity<>(archivoResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<byte[]> verArchivo(String ruta, String nombreArchivo) {
        try {
            Path rutaArchivo = Paths.get(ruta, nombreArchivo);

            if (!Files.exists(rutaArchivo)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            byte[] data = Files.readAllBytes(rutaArchivo);
            HttpHeaders headers = new HttpHeaders();
            String contentType = Files.probeContentType(rutaArchivo);

            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            return new ResponseEntity<>(data, headers, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
