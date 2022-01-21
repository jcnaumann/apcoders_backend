package com.apcoders.service;

import com.apcoders.model.Unidade;
import com.apcoders.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Classe @Service Unidade anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'UNIDADES', além das regras de negócio,
 * utilizando-se do 'design pattern' MVC.
 */
@Service
public class UnidadeServiceImpl implements UnidadeService {


    /**
     * Objeto da classe UnidadeService.
     */
    @Autowired
    private UnidadeRepository unidadeRepository;

    /**
     * Implementação do método que retorna um objeto da classe 'Unidade' para salvamento.
     * @param unidade parâmetro/objeto de salvamento.
     * @return Retorna um objeto Unidade.
     */
    @Override
    public Unidade createUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Unidade' para atualização.
     * @param unidade parâmetro/objeto de salvamento.
     * @return Retorna um objeto Unidade.
     */
    @Override
    public Unidade updateUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    @Override
    public Unidade getUnidade(long id) {
        Optional<Unidade> optionalUnidade = unidadeRepository.findById(id);
        return optionalUnidade.orElse(null);
    }

    /**
     * Implementação do método para remover registro de depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    @Override
    public void deleteUnidade(long id) {
        unidadeRepository.deleteById(id);
    }

    /**
     * Implementação do método que retorna todas as unidades existentes na tabela correspondente (UNIDADES) do banco de dados.
     * @return Retorna uma coleção de todas as unidades existentes na base de dados.
     */
    @Override
    public List<Unidade> getAllUnidades() {
        return (List<Unidade>) unidadeRepository.findAll();
    }
}
