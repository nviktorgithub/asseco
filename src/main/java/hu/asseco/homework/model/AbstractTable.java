package hu.asseco.homework.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public AbstractTable() {
    }

    public AbstractTable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
