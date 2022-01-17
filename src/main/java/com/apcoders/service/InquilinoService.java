package com.apcoders.service;

import com.apcoders.model.Inquilino;

import java.util.List;

public interface InquilinoService {

    Inquilino createInquilino(Inquilino inquilino);
    Inquilino updateInquilino(Inquilino inquilino);
    Inquilino getInquilino(long id);
    void deleteInquilino(long id);
    List<Inquilino> getAllInquilinos();

}
