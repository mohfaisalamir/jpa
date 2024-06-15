package com.enigma.purba_resto_jpa.dto;

public class CustomerResponse {
    private String id;
    private String customerName;
    private String customerPhone;
    private String userCredentialId;

    public CustomerResponse(String id, String customerName, String customerPhone, String userCredentialId) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.userCredentialId = userCredentialId;
    }

    public CustomerResponse() {
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

    public String getUserCredentialId() {
        return userCredentialId;
    }

    public void setUserCredentialId(String userCredentialId) {
        this.userCredentialId = userCredentialId;
    }

    @Override
    public String toString() {
        return "\n\tUserCredentialResponse : " +
                "\n\tid              : " + id +
                "\n\tcustomerName    : " + customerName  +
                "\n\tcustomerPhone   : " + customerPhone +
                "\n\tuserCredentialId: " + userCredentialId +
                "\n"+"=".repeat(30);
    }
}
