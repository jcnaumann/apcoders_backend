package com.apcoders.controller;

import com.apcoders.model.Inquilino;
import com.apcoders.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe InquilinoController anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'Iquilino',
 * utilizando-se do 'design pattern' MVC.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InquilinoController {

    /**
     * Objeto da classe ContaService.
     */
    @Autowired
    private InquilinoService inquilinoService;

    /**
     * Endpoint '/desp' utilizado para o cadastro de nquilinos na base de dados H2.
     * A anotação '@Valid' é utilizada para corresponder a validação fixada na 'POJO class'.
     * @param inquilino Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Inquilinosa e
     * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PostMapping("/inq")
    public ResponseEntity<Inquilino> createInquilino(@Valid @RequestBody Inquilino inquilino) {
        return new ResponseEntity<>(inquilinoService.createInquilino(inquilino), HttpStatus.CREATED);
    }

    /**
     * Endpoint '/desp' utilizado para a atualização do registro de nquilinos na base de dados H2.
     * A anotação '@Valid' é utilizada para a corresponder a validação fixada na 'POJO class'.
     * O objeto da classe Inquilino é enviado através do endereço URL.
     * @param inquilino Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Inquilino e
     *      * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PutMapping("/inq")
    public ResponseEntity<Inquilino> updateInquilino(@Valid @RequestBody Inquilino inquilino) {
        return new ResponseEntity<>(inquilinoService.updateInquilino(inquilino), HttpStatus.CREATED);
    }

    /**
     * Endepoint '/desp/{id}' utilizado para a remoção de registros de dedesas na base de dados H2.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna uma string e um 'status code' OK (200).
     */
    @DeleteMapping("/inq/{id}")
    public ResponseEntity<String> deleteInquilino(@PathVariable(value = "id") long id) {
        inquilinoService.deleteInquilino(id);
        return new ResponseEntity<>("Inquilino " + id + " deletada.", HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar registro de contas por seus respectivos 'id'.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna um 'status code' com um objeto ResponseEntity<Inquilino> OK (200).
     */
    @GetMapping("/inq/{id}")
    public ResponseEntity<Inquilino> getInquilino(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(inquilinoService.getInquilino(id), HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar todos os registros de nquilinos cadastradas na base de dados.
     * @return Retorna uma coleção de contas serializadas.
     */
    @GetMapping("/inq")
    public ResponseEntity<List<Inquilino>> getAllInquilinos() {
        return new ResponseEntity<>(inquilinoService.getAllInquilinos(), HttpStatus.OK);
    }

}
