package com.project.dao.api;

import com.project.model.Vacancie;

import java.util.List;

public interface VacancieDAO {

    void add(Vacancie p);

    void update(Vacancie p);

    List<Vacancie> list();

    Vacancie getById(int id);

    void remove(int id);

    void submitForApproval(Integer id, String recordType);

    void approve(Integer id, String recordType);

    void reject(Integer id, String recordType);
}
