package com.project.dao.impl;

import com.project.dao.api.ApplicantDAO;
import com.project.model.Applicant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Applicant applicant) {
        getCurrentSession().save(applicant);
        logger.info("Applicant saved successfully, Applicant Details=" + applicant);
    }

    @Override
    public void update(Applicant applicant) {
        getCurrentSession().update(applicant);
        logger.info("Applicant updated successfully, Applicant Details=" + applicant);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Applicant> list() {
        List<Applicant> applicantList = getCurrentSession().createQuery("from Applicant").list();
        for (Applicant applicant : applicantList) {
            logger.info("Applicant List::" + applicant);
        }
        return applicantList;
    }

    @Override
    public Applicant getById(int id) {
        Applicant applicant = (Applicant) getCurrentSession().load(Applicant.class, id);
        logger.info("Applicant loaded successfully, Applicant details=" + applicant);
        return applicant;
    }

    @Override
    public void remove(int id) {
        Applicant applicant = (Applicant) getCurrentSession().load(Applicant.class, id);
        if (null != applicant) {
            getCurrentSession().delete(applicant);
        }
        logger.info("Applicant deleted successfully, Applicant details=" + applicant);
    }
}
