package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "applicants_and_vacancies", schema="public")
public class ApplicantAndVacancie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacancie", nullable = false, foreignKey = @ForeignKey(name = "fk_vacancie"))
    private Vacancie vacancie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant", nullable = false, foreignKey = @ForeignKey(name = "fk_applicant"))
    private Applicant applicant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vacancie getVacancie() {
        return vacancie;
    }

    public void setVacancie(Vacancie vacancie) {
        this.vacancie = vacancie;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
