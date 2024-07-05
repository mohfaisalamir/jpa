package com.enigma.purba_resto_jpa;

import com.enigma.purba_resto_jpa.enitity.Customer;
import com.enigma.purba_resto_jpa.enitity.UserCredential;
import com.enigma.purba_resto_jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class App5 {
    public static void main(String[] args) {
        EntityManager em  = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


/*      // cara 1
 UserCredential userCredential = new UserCredential(
                null,
                "moel@gmail.com",
                "moel123"
        );

        Customer customer = new Customer(
                23,
                "Muldoko",
                "081472889709",
                true,
                userCredential);
        em.persist(customer);*/

        // atau bisa dengan
        /* // cara 2

        UserCredential userCredential = new UserCredential(
                null,
                "murwani@gmail.com",
                "mur123"
        );

        Customer customer = new Customer(
                26,
                "Murwani",
                "0889998909",
                true,
                null);

        customer.setUserCredential(userCredential);
        em.persist(customer);*/

        // fin  by id
        Customer customer = em.find(Customer.class, 2);
        System.out.println(customer);
        //em.remove(customer);

        transaction.commit();
        em.close();

    }
}
