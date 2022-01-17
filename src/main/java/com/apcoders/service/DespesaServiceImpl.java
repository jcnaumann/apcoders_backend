package com.apcoders.service;

import com.apcoders.model.Despesa;
import com.apcoders.model.Inquilino;
import com.apcoders.repository.DespesaRepository;
import com.apcoders.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaServiceImpl implements DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Override
    public Despesa createDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    @Override
    public Despesa updateDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    @Override
    public Despesa getDespesa(long id) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
        return optionalDespesa.orElse(null);
    }

    @Override
    public void deleteDespesa(long id) {
        despesaRepository.deleteById(id);
    }

    @Override
    public List<Despesa> getAllDespesas() {
        return (List<Despesa>) despesaRepository.findAll();
    }

}
