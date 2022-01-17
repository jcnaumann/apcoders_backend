package com.apcoders.controller;

import com.apcoders.model.Unidade;
import com.apcoders.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping("/und/create")
    public ResponseEntity<Unidade> createUnidade(@Valid @RequestBody Unidade unidade) {
        return new ResponseEntity<>(unidadeService.createUnidade(unidade), HttpStatus.CREATED);
    }

    @PutMapping("/und/update")
    public ResponseEntity<Unidade> updateUnidade(@Valid @RequestBody Unidade unidade) {
        return new ResponseEntity<>(unidadeService.updateUnidade(unidade), HttpStatus.CREATED);
    }

    @DeleteMapping("/und/delete/{id}")
    public ResponseEntity<String> deleteUnidade(@PathVariable(value = "id") long id) {
        unidadeService.deleteUnidade(id);
        return new ResponseEntity<>("Unidade " + id + " deletada.", HttpStatus.OK);
    }

    @GetMapping("/und/get/{id}")
    public ResponseEntity<Unidade> getUnidade(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(unidadeService.getUnidade(id), HttpStatus.OK);
    }

    @GetMapping("/und/all")
    public ResponseEntity<List<Unidade>> getAllUnidades() {
        return new ResponseEntity<>(unidadeService.getAllUnidades(), HttpStatus.OK);
    }

}
