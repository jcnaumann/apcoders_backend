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

/**
 * Classe DespesaController anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'Despesa',
 * utilizando-se do 'design pattern' MVC.
 */
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class DespesaController {

    /**
     * Objeto da classe ContaService.
     */
    @Autowired
    private DespesaService despesaService;

    /**
     * Endpoint '/desp' utilizado para o cadastro de despesas na base de dados H2.
     * A anotação '@Valid' é utilizada para corresponder a validação fixada na 'POJO class'.
     * @param despesa Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Despesa e
     * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PostMapping("/desp")
    public ResponseEntity<Despesa> createDespesa(@Valid @RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaService.createDespesa(despesa), HttpStatus.CREATED);
    }

    /**
     * Endpoint '/desp' utilizado para a atualização do registro de despesas na base de dados H2.
     * A anotação '@Valid' é utilizada para a corresponder a validação fixada na 'POJO class'.
     * O objeto da classe Despesa é enviado através do endereço URL.
     * @param despesa Objeto serializado via Json.
     * @return O método retorna um 'ResponseEntity' contendo um objeto Despesa e
     *      * um 'status code CREATE', caso a resposta tenha sido OK.
     */
    @PutMapping("/desp")
    public ResponseEntity<Despesa> updateDespesa(@Valid @RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaService.updateDespesa(despesa), HttpStatus.CREATED);
    }

    /**
     * Endepoint '/desp/{id}' utilizado para a remoção de registros de dedesas na base de dados H2.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna uma string e um 'status code' OK (200).
     */
    @DeleteMapping("/desp/{id}")
    public ResponseEntity<String> deleteDespesa(@PathVariable(value = "id") long id) {
        despesaService.deleteDespesa(id);
        return new ResponseEntity<>("Despesa " + id + " deletada.", HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar registro de contas por seus respectivos 'id'.
     * @param id O número do 'id' é enviado através do endereço URL.
     * @return Retorna um 'status code' com um objeto ResponseEntity<Despesa> OK (200).
     */
    @GetMapping("/desp/{id}")
    public ResponseEntity<Despesa> getDespesa(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(despesaService.getDespesa(id), HttpStatus.OK);
    }

    /**
     * Endpoint utilizado para buscar todos os registros de despesas cadastradas na base de dados.
     * @return Retorna uma coleção de contas serializadas.
     */
    @GetMapping("/desp")
    public ResponseEntity<List<Despesa>> getAllUnidades() {
        return new ResponseEntity<>(despesaService.getAllDespesas(), HttpStatus.OK);
    }

}
