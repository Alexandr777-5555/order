package ru.register.shop.domain;

import javax.persistence.*;
import java.time.LocalDate;


/**
 *
 *
 * Сертификат регистрации магазина
 *
 *
 */


@Table(name = "reg_certificate")
@Entity
public class RegisterCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long certificateId;

    @Column(name = "number")
    private String number;

    @Column(name = "reg_date")
    private LocalDate issueDate;

    @Column (name = "active")
    private boolean active;   // действительный сертификат

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;


    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
