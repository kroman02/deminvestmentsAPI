package dev.koryroman.demeterdocs.data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="dob")
    private Date dob;
    @Column(name="gender")
    private String gender;
    @Column(name="smoker")
    private Boolean smoker;
    @Column(name="condition")
    private String condition;
    @ManyToOne
    @JoinColumn(name="state", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;

    @ManyToOne
    @JoinColumn(name="policy_id", nullable=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MyPolicy policy;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MyPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(MyPolicy policy) {
        this.policy = policy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }
}
