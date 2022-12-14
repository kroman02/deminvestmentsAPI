package dev.koryroman.demeterdocs.data;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="image")
    private String image;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(){}
    public Client(String name){
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        this.image = client.getImage();
    }

}
