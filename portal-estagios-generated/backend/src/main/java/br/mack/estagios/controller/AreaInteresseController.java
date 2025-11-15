package br.mack.estagios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
/*
  CONTROLLER DE EXEMPLO - usa armazenamento em memória para facilitar testes.
  Substitua pela versão com JPA/Repository quando for integrar ao projeto real.
*/
@RestController
@RequestMapping("/areas")
public class AreaInteresseController {
    private final Map<Long, Map<String,String>> store = new LinkedHashMap<>();
    private long seq = 1;

    @GetMapping
    public ResponseEntity<List<Map<String,String>>> listar() {
        return ResponseEntity.ok(new ArrayList<>(store.values()));
    }

    @PostMapping
    public ResponseEntity<Map<String,String>> criar(@RequestBody Map<String,String> body) {
        if (body.get("titulo")==null || body.get("titulo").isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        long id = seq++;
        Map<String,String> item = new HashMap<>();
        item.put("id", String.valueOf(id));
        item.put("titulo", body.get("titulo"));
        item.put("descricao", body.getOrDefault("descricao",""));
        store.put(id, item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        store.remove(id);
        return ResponseEntity.ok().build();
    }
}
