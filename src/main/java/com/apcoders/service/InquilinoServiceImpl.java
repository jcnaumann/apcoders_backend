package com.apcoders.service;

import com.apcoders.model.Inquilino;
import com.apcoders.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Classe @Service Inquilino anotada para o controle do Spring MVC.
 * Esta classe proporciona os 'endpoints' da API referente à entidade 'INQUILINOS', além das regras de negócio,
 * utilizando-se do 'design pattern' MVC.
 */
@Service
public class InquilinoServiceImpl implements InquilinoService {

    /**
     * Objeto da classe InquilinoService.
     */
    @Autowired
    private InquilinoRepository inquilinoRepository;

    /**
     * Implementação do método que retorna um objeto da classe 'Inquilino' para salvamento.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Inquilino.
     */
    @Override
    public Inquilino createInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Inquilino' para atualização.
     * @param inquilino parâmetro/objeto de salvamento.
     * @return Retorna um objeto Inquilino.
     */
    @Override
    public Inquilino updateInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    /**
     * Implementação do método que retorna um objeto da classe 'Optional' para verificação se ele existe no banco de dados.
     * A referida classe é utilizada a fim de evitar NPE, ou seja, a mesma necessariamente conterá nada ou
     * uma valor não nulo.
     * @param id Código identificador do registro.
     * @return Retorna um objeto Optional vazio ou não nulo.
     */
    @Override
    public Inquilino getInquilino(long id) {
        Optional<Inquilino> optionalInquilino = inquilinoRepository.findById(id);
        return optionalInquilino.orElse(null);
    }

    /**
     * Implementação do método para remover registro de depesa através do seu 'id'.
     * @param id Código identificador do registro.
     */
    @Override
    public void deleteInquilino(long id) {
        inquilinoRepository.deleteById(id);
    }

    /**
     * Implementação do método que retorna todas as inquilinos existentes na tabela correspondente (INQUILINOS) do banco de dados.
     * @return Retorna uma coleção de todas as inquilinos existentes na base de dados.
     */
    @Override
    public List<Inquilino> getAllInquilinos() {
        return (List<Inquilino>) inquilinoRepository.findAll();
    }

}
