package dev.koryroman.demeterdocs.data;

import javax.persistence.*;

@Entity
@Table(name="carrier")
public class Carrier {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name="name")
    String name;

    public Carrier() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
