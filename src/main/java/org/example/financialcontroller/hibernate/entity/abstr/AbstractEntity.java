package org.example.financialcontroller.hibernate.entity.abstr;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
