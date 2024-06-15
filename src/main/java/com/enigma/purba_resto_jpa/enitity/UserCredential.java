package com.enigma.purba_resto_jpa.enitity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

@Entity
@Table(name = "m_user_credential")
public class UserCredential {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private String id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.PERSIST)
    private Customer customer;

    public UserCredential(String id, String email, String password, Customer customer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.customer = customer;
    }

public UserCredential(String id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
}

    public UserCredential() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "UserCredential    : " +
                "\n\tid      : " + id +
                "\n\temail   : " + email  +
                "\n\tpassword: " + password +
                "\n"+"=".repeat(30);
    }
}
