package dev.koryroman.demeterdocs.data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="sp")
    private Long sp;

    @Column(name="moody")
    private String moody;

    @Column(name="fitch")
    private String fitch;

    @ManyToOne
    @JoinColumn(name="carrier_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Carrier carrier;

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

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Long getSp() {
        return sp;
    }

    public void setSp(Long sp) {
        this.sp = sp;
    }

    public String getMoody() {
        return moody;
    }

    public void setMoody(String moody) {
        this.moody = moody;
    }
}




