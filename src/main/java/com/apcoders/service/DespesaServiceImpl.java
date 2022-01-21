package com.apcoders.service;

import com.apcoders.model.Despesa;
import com.apcoders.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe @Service Despesa anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'DESPESAS', além das regras de negócio,
 * utilizando-se do 'design pattern' MVC.
 */
@Service
public class DespesaServiceImpl implements DespesaService {

    /**
     * Objeto da classe DespesaService.
     */
    @Autowired
    private DespesaRepository despesaRepository;

    /**
     * Implementação do método que retorna um objeto da classe 'Despesa' para salvamento.
     * @param despesa parâmetro/objeto de salvamento.
     * @return Retorna um objeto Despesa.
     */
    @Override
    public Despesa createDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Despesa' para atualização.
     * @param despesa parâmetro/objeto de salvamento.
     * @return Retorna um objeto Despesa.
     */
    @Override
    public Despesa updateDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    @Override
    public Despesa getDespesa(long id) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
        return optionalDespesa.orElse(null);
    }

    /**
     * Implementação do método para remover registro de depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    @Override
    public void deleteDespesa(long id) {
        despesaRepository.deleteById(id);
    }

    /**
     * Implementação do método que retorna todas as despesas existentes na tabela correspondente (DESPESAS) do banco de dados.
     * @return Retorna uma coleção de todas as despesas existentes na base de dados.
     */
    @Override
    public List<Despesa> getAllDespesas() {
        return (List<Despesa>) despesaRepository.findAll();
    }

}
