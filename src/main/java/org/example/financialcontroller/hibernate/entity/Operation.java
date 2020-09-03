package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import java.time.Clock;
import java.time.Instant;

@Entity
@Table(name = "operation")
public class Operation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "date_of_operation", nullable = false)
    private Instant timestamp;

    public Operation() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
