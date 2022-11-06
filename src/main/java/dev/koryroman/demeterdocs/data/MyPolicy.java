package dev.koryroman.demeterdocs.data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="policy")
public class MyPolicy {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="policy_code")
    private String policyCode;
    @Column(name="issue_date")
    private Date issueDate;
    @Column(name="origination_type")
    private String originationType;
    @ManyToOne
    @JoinColumn(name="issue_state_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getOriginationType() {
        return originationType;
    }

    public void setOriginationType(String originationType) {
        this.originationType = originationType;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
