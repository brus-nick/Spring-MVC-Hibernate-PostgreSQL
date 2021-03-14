package com.project.service.api;

import com.project.model.Vacancie;

import java.util.List;

public interface VacancieService {

    void add(Vacancie p);

    void update(Vacancie p);

    List<Vacancie> list();

    Vacancie getById(int id);

    void remove(int id);
}
