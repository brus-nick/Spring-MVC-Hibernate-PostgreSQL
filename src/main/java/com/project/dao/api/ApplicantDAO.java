package com.project.dao.api;

import com.project.model.Applicant;

import java.util.List;

public interface ApplicantDAO {

    void add(Applicant p);

    void update(Applicant p);

    List<Applicant> list();

    Applicant getById(int id);

    void remove(int id);
}
