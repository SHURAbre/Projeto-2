package br.mack.estagios.controller;

import br.mack.estagios.service.CurriculoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    private final CurriculoService service;

    public CurriculoController(CurriculoService service) {
        this.service = service;
    }

    @GetMapping("/{idEstudante}")
    public ResponseEntity<byte[]> gerar(@PathVariable Long idEstudante) throws Exception {

        byte[] pdf = service.gerarCurriculo(idEstudante);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}