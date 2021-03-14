package com.project.service.api;

public interface RecordApproval {

    void submitForApproval(Integer id, String recordType);

    void approve(Integer id, String recordType);

    void reject(Integer id, String recordType);
}
