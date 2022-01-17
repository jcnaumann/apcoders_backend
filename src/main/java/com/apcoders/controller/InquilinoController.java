package com.apcoders.controller;

import com.apcoders.model.Inquilino;
import com.apcoders.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    @PostMapping("/inq")
    public ResponseEntity<Inquilino> createInquilino(@Valid @RequestBody Inquilino inquilino) {
        return new ResponseEntity<>(inquilinoService.createInquilino(inquilino), HttpStatus.CREATED);
    }

    @PutMapping("/inq")
    public ResponseEntity<Inquilino> updateInquilino(@Valid @RequestBody Inquilino inquilino) {
        return new ResponseEntity<>(inquilinoService.updateInquilino(inquilino), HttpStatus.CREATED);
    }

    @DeleteMapping("/inq/{id}")
    public ResponseEntity<String> deleteInquilino(@PathVariable(value = "id") long id) {
        inquilinoService.deleteInquilino(id);
        return new ResponseEntity<>("Inquilino " + id + " deletada.", HttpStatus.OK);
    }

    @GetMapping("/inq/{id}")
    public ResponseEntity<Inquilino> getInquilino(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(inquilinoService.getInquilino(id), HttpStatus.OK);
    }

    @GetMapping("/inq")
    public ResponseEntity<List<Inquilino>> getAllInquilinos() {
        return new ResponseEntity<>(inquilinoService.getAllInquilinos(), HttpStatus.OK);
    }

}
