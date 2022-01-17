package com.apcoders.service;

import com.apcoders.model.Unidade;
import java.util.List;

public interface UnidadeService {

    Unidade createUnidade(Unidade unidade);
    Unidade updateUnidade(Unidade unidade);
    Unidade getUnidade(long id);
    void deleteUnidade(long id);
    List<Unidade> getAllUnidades();

}
