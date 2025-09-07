package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.CarpetaResponse;
import control.procesos.controlProcesos.service.IAlmacenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/controlProcesos")
public class AlmacenamientoController {

    @Autowired
    private IAlmacenamientoService iAlmacenamientoService;

    @GetMapping("/crearCarpeta")
    public ResponseEntity<CarpetaResponse> crearCarpeta(@RequestParam String carpeta) {
        String response = iAlmacenamientoService.crearCarpeta(carpeta);
        CarpetaResponse carpetaResponse;
        carpetaResponse = CarpetaResponse.builder().url(response).build();
        return ResponseEntity.ok(carpetaResponse);
    }

    @PostMapping("/cargarArchivo")
    public String cargarArchivo(@RequestParam String ruta, @RequestParam("archivo") MultipartFile archivo) {
        String response = iAlmacenamientoService.cargarArchivo(ruta, archivo);
        return response;
    }

    @GetMapping("/descargarArchivo")
    public ResponseEntity<byte[]> descargarArchivo(@RequestParam String ruta, @RequestParam String nombreArchivo) {
        try {
            Path rutaArchivo = Paths.get(ruta, nombreArchivo);

            if (!Files.exists(rutaArchivo)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            byte[] data = Files.readAllBytes(rutaArchivo);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nombreArchivo);
            headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(rutaArchivo));

            // return new ResponseEntity<>(data, headers, HttpStatus.OK);
            return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
