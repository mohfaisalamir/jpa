package com.enigma.purba_resto_jpa;

import com.enigma.purba_resto_jpa.enitity.*;
import com.enigma.purba_resto_jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;
import java.util.List;
public class App4 {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        // 1. find Customer by Id
        Customer customer = em.find(Customer.class, 22);
        //System.out.println(customer);
        // 2. find Table by Id
        Table table = em.find(Table.class, 1);
        //System.out.println(table);
        // 3. find Menu by Id
        Menu menu = em.find(Menu.class, 2);
        Menu menu2 = em.find(Menu.class, 42);
        Menu menu3 = em.find(Menu.class, 45);
        // 4. Create List of Order Detail
        List<OrderDetail> orderDetails = List.of(
                new OrderDetail(null, null, menu, 3),
                new OrderDetail(null, null, menu3, 4),
                new OrderDetail(null, null, menu2, 9)
                );
        //System.out.println(orderDetails);
        Order order = new Order(null,new Date(),customer, table, orderDetails);
        em .persist(order);

        // kita bongkar
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            orderDetail.setOrder(order);
        }
        System.out.println(order);

        transaction.commit();
        em.close();
        JpaUtil.shutDownEntityManager();
    }
}

