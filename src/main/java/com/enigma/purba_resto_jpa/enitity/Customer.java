package com.enigma.purba_resto_jpa.enitity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_customer")
public class Customer {
    @Id
   private String id;
    @Column(name = "customer_name" )
   private String customerName;
    @Column(name = "customer_phone" )
   private String customerPhone;
    @Column(name = "member_status" )
   private Boolean isMember;
//   @OneToOne(cascade = CascadeType.PERSIST// dengan anotasi bervalue ini (OneToOne(cascade = CascadeType.PERSIST) )
                                            // sekali persist credential langsung kebuat. dan gak harus persist, gisa digabung merge persist dll.
                                            // dan jika mendambahkan lebih dari satu cascade maka tambah kurung kurawal {}
@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE /*tentu ini bisa banyak casecade, bisa remove, persist, merge dll*/})
   @JoinColumn(name = "user_credential_id" )
   private UserCredential userCredential;

    public Customer(String id, String customerName, String customerPhone, Boolean isMember, UserCredential userCredential) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.isMember = isMember;
        this.userCredential = userCredential;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }


    @Override
             public String toString() {
        return "\nCustomer    : " +
                "\n\tid             : " + id +
                "\n\tcustomerName   : " + customerName  +
                "\n\tcustomerPhone  : " + customerPhone +
                "\n\tisMember       : " + isMember +
                "\n\tUser Cred      : " + (userCredential != null ? userCredential.toString() : "null") +
                "\n"+"=".repeat(30);
    }
}
