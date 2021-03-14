package com.project.dao.impl;

import com.project.dao.api.VacancieDAO;
import com.project.dao.util.RecordStatus;
import com.project.model.Vacancie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancieDAOImpl implements VacancieDAO {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Vacancie vacancie) {
        getCurrentSession().persist(vacancie);
        logger.info("Vacancie saved successfully, Vacancie Details=" + vacancie);
    }

    @Override
    public void update(Vacancie vacancie) {
        getCurrentSession().update(vacancie);
        logger.info("Vacancie updated successfully, Vacancie Details=" + vacancie);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vacancie> list() {
        List<Vacancie> vacancieList = getCurrentSession().createQuery("from Vacancie").list();
        for (Vacancie vacancie : vacancieList) {
            logger.info("Vacancie List::" + vacancie);
        }
        return vacancieList;
    }

    @Override
    public Vacancie getById(int id) {
        Vacancie vacancie = (Vacancie) getCurrentSession().load(Vacancie.class, id);
        logger.info("Vacancie loaded successfully, Vacancie details=" + vacancie);
        return vacancie;
    }

    @Override
    public void remove(int id) {
        Vacancie vacancie = (Vacancie) getCurrentSession().load(Vacancie.class, id);
        if (null != vacancie) {
            getCurrentSession().delete(vacancie);
        }
        logger.info("Vacancie deleted successfully, Vacancie details=" + vacancie);
    }

    @Override
    public void submitForApproval(Integer id, String recordType) {
        Vacancie vacancie = (Vacancie) getCurrentSession().load(Vacancie.class, id);
        if (null != vacancie) {
            vacancie.setStatus(RecordStatus.waiting);
            getCurrentSession().update(vacancie);
        }
        logger.info("Vacancie status updated successfully, Vacancie Details=" + vacancie);
    }

    @Override
    public void approve(Integer id, String recordType) {
        Vacancie vacancie = getById(id);
        if (null != vacancie) {
            vacancie.setStatus(RecordStatus.confirmed);
            getCurrentSession().update(vacancie);
        }
        logger.info("Vacancie status updated successfully, Vacancie Details=" + vacancie);
    }

    @Override
    public void reject(Integer id, String recordType) {
        Vacancie vacancie = getById(id);
        if (null != vacancie) {
            vacancie.setStatus(RecordStatus.rejected);
            getCurrentSession().update(vacancie);
        }
        logger.info("Vacancie status updated successfully, Vacancie Details=" + vacancie);
    }
}
