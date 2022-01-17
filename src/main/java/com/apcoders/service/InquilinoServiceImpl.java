package com.apcoders.service;

import com.apcoders.model.Inquilino;
import com.apcoders.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InquilinoServiceImpl implements InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Override
    public Inquilino createInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    @Override
    public Inquilino updateInquilino(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }

    @Override
    public Inquilino getInquilino(long id) {
        Optional<Inquilino> optionalInquilino = inquilinoRepository.findById(id);
        return optionalInquilino.orElse(null);
    }

    @Override
    public void deleteInquilino(long id) {
        inquilinoRepository.deleteById(id);
    }

    @Override
    public List<Inquilino> getAllInquilinos() {
        return (List<Inquilino>) inquilinoRepository.findAll();
    }

}
