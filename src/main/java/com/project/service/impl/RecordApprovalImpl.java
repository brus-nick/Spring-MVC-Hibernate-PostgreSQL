package com.project.service.impl;

import com.project.dao.api.VacancieDAO;
import com.project.service.api.RecordApproval;
import com.project.service.util.RecordType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecordApprovalImpl implements RecordApproval {

    @Autowired
    VacancieDAO vacancieDAO;

    @Override
    public void submitForApproval(Integer id, String recordType) {
        if (RecordType.vacancy.equals(recordType)) {
            vacancieDAO.submitForApproval(id, recordType);
        }
    }

    @Override
    public void approve(Integer id, String recordType) {
        if (RecordType.vacancy.equals(recordType)) {
            vacancieDAO.approve(id, recordType);
        }
    }

    @Override
    public void reject(Integer id, String recordType) {
        if (RecordType.vacancy.equals(recordType)) {
            vacancieDAO.reject(id, recordType);
        }
    }
}
