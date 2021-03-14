package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.api.ApplicantDAO;
import com.project.model.Applicant;
import com.project.service.api.ApplicantService;

import java.util.List;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantDAO applicantDAO;

    @Override
    public void add(Applicant applicant) {
        this.applicantDAO.add(applicant);
    }

    @Override
    public void update(Applicant applicant) {
        this.applicantDAO.update(applicant);
    }

    @Override
    public List<Applicant> list() {
        return this.applicantDAO.list();
    }

    @Override
    public Applicant getById(int id) {
        return this.applicantDAO.getById(id);
    }

    @Override
    public void remove(int id) {
        this.applicantDAO.remove(id);
    }
}
