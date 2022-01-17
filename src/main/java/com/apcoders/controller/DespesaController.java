package com.apcoders.controller;

import com.apcoders.model.Despesa;
import com.apcoders.model.Unidade;
import com.apcoders.repository.DespesaRepository;
import com.apcoders.service.DespesaService;
import com.apcoders.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping("/desp/create")
    public ResponseEntity<Despesa> createDespesa(@Valid @RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaService.createDespesa(despesa), HttpStatus.CREATED);
    }

    @PutMapping("/desp/update")
    public ResponseEntity<Despesa> updateDespesa(@Valid @RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaService.updateDespesa(despesa), HttpStatus.CREATED);
    }

    @DeleteMapping("/desp/delete/{id}")
    public ResponseEntity<String> deleteDespesa(@PathVariable(value = "id") long id) {
        despesaService.deleteDespesa(id);
        return new ResponseEntity<>("Despesa " + id + " deletada.", HttpStatus.OK);
    }

    @GetMapping("/desp/get/{id}")
    public ResponseEntity<Despesa> getDespesa(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(despesaService.getDespesa(id), HttpStatus.OK);
    }

    @GetMapping("/desp/all")
    public ResponseEntity<List<Despesa>> getAllUnidades() {
        return new ResponseEntity<>(despesaService.getAllDespesas(), HttpStatus.OK);
    }

}
