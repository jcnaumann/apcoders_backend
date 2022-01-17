package com.apcoders.service;

import com.apcoders.model.Despesa;
import com.apcoders.model.Unidade;

import java.util.List;

public interface DespesaService {

    Despesa createDespesa(Despesa despesa);
    Despesa updateDespesa(Despesa despesa);
    Despesa getDespesa(long id);
    void deleteDespesa(long id);
    List<Despesa> getAllDespesas();

}
