package com.project.service.api;

import com.project.model.Applicant;

import java.util.List;

public interface ApplicantService {

    void add(Applicant p);

    void update(Applicant p);

    List<Applicant> list();

    Applicant getById(int id);

    void remove(int id);
}
