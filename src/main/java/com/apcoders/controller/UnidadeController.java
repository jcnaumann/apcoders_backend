package com.apcoders.controller;

import com.apcoders.model.Unidade;
import com.apcoders.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Classe UnidadeController anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'Unidade',
 * utilizando-se do 'design pattern' MVC.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UnidadeController {

    /**
     * Objeto da classe ContaService.
     */
    @Autowired
    private UnidadeService unidadeService;

    /**
     * Endpoint '/und' utilizado para o cadastro de unidades na base de dados H2.
     * A anotação '@Valid' é utilizada para corresponder a validação fixada na 'POJO class'.
     * @param unidade Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Unidade e
     * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PostMapping("/und")
    public ResponseEntity<Unidade> createUnidade(@Valid @RequestBody Unidade unidade) {
        return new ResponseEntity<>(unidadeService.createUnidade(unidade), HttpStatus.CREATED);
    }

    /**
     * Endpoint '/und' utilizado para a atualização do registro de unidades na base de dados H2.
     * A anotação '@Valid' é utilizada para a corresponder a validação fixada na 'POJO class'.
     * O objeto da classe Unidade é enviado através do endereço URL.
     * @param unidade Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Unidade e
     *      * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PutMapping("/und")
    public ResponseEntity<Unidade> updateUnidade(@Valid @RequestBody Unidade unidade) {
        return new ResponseEntity<>(unidadeService.updateUnidade(unidade), HttpStatus.CREATED);
    }

    /**
     * Endepoint '/und/{id}' utilizado para a remoção de registros de dedesas na base de dados H2.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna uma string e um 'status code' OK (200).
     */
    @DeleteMapping("/und/{id}")
    public ResponseEntity<String> deleteUnidade(@PathVariable(value = "id") long id) {
        unidadeService.deleteUnidade(id);
        return new ResponseEntity<>("Unidade " + id + " deletada.", HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar registro de contas por seus respectivos 'id'.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna um 'status code' com um objeto ResponseEntity<Unidade> OK (200).
     */
    @GetMapping("/und/{id}")
    public ResponseEntity<Unidade> getUnidade(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(unidadeService.getUnidade(id), HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar todos os registros de unidades cadastradas na base de dados.
     * @return Retorna uma coleção de contas serializadas.
     */
    @GetMapping("/und")
    public ResponseEntity<List<Unidade>> getAllUnidades() {
        return new ResponseEntity<>(unidadeService.getAllUnidades(), HttpStatus.OK);
    }

}
