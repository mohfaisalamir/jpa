package com.enigma.purba_resto_jpa.util;

import com.enigma.purba_resto_jpa.dto.CustomerResponse;
import com.enigma.purba_resto_jpa.dto.UserCredentialResponse;
import com.enigma.purba_resto_jpa.enitity.Customer;
import com.enigma.purba_resto_jpa.enitity.UserCredential;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        System.out.println("HAllO");

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // FIND BY ID
        UserCredential credential = em.find(UserCredential.class, "11042112-56d2-4867-bcb5-e1957a5a9a2b");
        //map menjadi user credential response
        UserCredentialResponse ucr = new UserCredentialResponse(
                credential.getId(),
                credential.getEmail(),
                new CustomerResponse(
                        credential.getCustomer().getId(),
                        credential.getCustomer().getCustomerName(),
                        credential.getCustomer().getCustomerPhone(),
                        credential.getId()
                )
        );
        System.out.println(ucr); // ini customer didalam user credenttilal


        // i try FIND ALL
//        TypedQuery<Customer> query = em.createQuery("select c from Customer c",Customer.class);
//        List<Customer> resultList = query.getResultList();
//        System.out.println(resultList);

        //System.out.println(customer);
        transaction.commit();
        em.close();
        JpaUtil.shutDownEntityManager();
        //caraKedua(em);
        //caraPertama(em);
    }

    private static void caraKedua(EntityManager em) {
        UserCredential uc = new UserCredential(
                null,
                "nacos@gmail.com",
                "nacosil1234");

        Customer customer = new Customer(
                "22",
                "El d'Nacos",
                "086662312389",
                true,
                uc
        );
        //mari kita coba
        em.persist(customer);
    }

    // CARA PERTAMA ini melakukan persist 2 kali
    private static void caraPertama(EntityManager em) {
        // CARA PERTAMA ini melakukan persist sekali, ini lebih canggih,
        // namun perlu menambah anotasi tertentu (one-to-one/cascade) pada entity
        UserCredential uc = new UserCredential(
                null,
                "bangil@gmail.com",
                "bangil1234");

        Customer customer = new Customer(
                "21",
                "Bangil",
                "086667878389",
                true,
                null);
        //setelah save dan id seelsai di-generate, maka userCredential di set ke Customer
        customer.setUserCredential(uc);
        // save user credential (uc)
        em.persist(uc);
        //sav ecustomer
        em.persist(customer);
    }
}
