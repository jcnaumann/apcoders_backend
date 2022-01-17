package com.apcoders.service;

import com.apcoders.model.Unidade;
import com.apcoders.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Override
    public Unidade createUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    @Override
    public Unidade updateUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    @Override
    public Unidade getUnidade(long id) {
        Optional<Unidade> optionalUnidade = unidadeRepository.findById(id);
        return optionalUnidade.orElse(null);
    }

    @Override
    public void deleteUnidade(long id) {
        unidadeRepository.deleteById(id);
    }

    @Override
    public List<Unidade> getAllUnidades() {
        return (List<Unidade>) unidadeRepository.findAll();
    }
}
