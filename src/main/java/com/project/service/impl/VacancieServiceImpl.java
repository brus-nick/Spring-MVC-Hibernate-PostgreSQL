package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.api.VacancieDAO;
import com.project.model.Vacancie;
import com.project.service.api.VacancieService;

import java.util.List;

@Service
@Transactional
public class VacancieServiceImpl implements VacancieService {

    @Autowired
    private VacancieDAO vacancieDAO;

    @Override
    public void add(Vacancie vacancie) {
        this.vacancieDAO.add(vacancie);
    }

    @Override
    public void update(Vacancie vacancie) {
        this.vacancieDAO.update(vacancie);
    }

    @Override
    public List<Vacancie> list() {
        return this.vacancieDAO.list();
    }

    @Override
    public Vacancie getById(int id) {
        return this.vacancieDAO.getById(id);
    }

    @Override
    public void remove(int id) {
        this.vacancieDAO.remove(id);
    }
}
