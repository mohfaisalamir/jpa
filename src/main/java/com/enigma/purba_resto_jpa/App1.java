package com.enigma.purba_resto_jpa;
// 03. CRITERIA

import com.enigma.purba_resto_jpa.util.JpaUtil;
import com.enigma.purba_resto_jpa.enitity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;

import java.util.List;

public class App1 {
    // saat ini kita akan belajar soal CRITERIA, apa itu?
    // jika kita melakukan query biasanya kita menggunkan JPQL dan sebenarnya juga ada HQL, tapi kali ini kita menggunakan
    // standarisasinya JPA saja dengan provider atau implementasi nya dengan Hibernate
    // JPA ini bisa melakukan query tanpa menulis query, di melakukan query scara program, kita menggunakan tools yang disdediakan JPA (kali ini JPA nya kita pakai Hibernet),..
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        /*
        * 3 OBJECT CRITERIA YANG DI GUNAKAN
        *   1. Criteria Builder ==> Sang Pembangun
        *      digunakan untuk membangun ekspresi ( <,>,<=,>=, like, equals, <>, ==, != , dll ),
        *      juga untuk membangun Criteria (select,update, delete)
        *
        *   2. Criteria Query  ==>
        *      digunakan unruk membuat query ( SELECT, UPDATE, DELETE) , atau Clause ( WHERE, FROM, DISTINCT, HAVING, ORDER BY, dll)
        *
        *   3. Root     ==>
        *      merepresentasikan Entity (sperti m.id, m.name, m.price dll)
        *
        * SELECT * FROM Menu m
        *
        * */

        //CriteriaBuilder cb = em.getCriteriaBuilder();
        // SELECT
        //CriteriaQuery<Menu> cq = cb.createQuery(Menu.class); // pada dasarnya kita hanya berkutat pada CriteriaBuilder (CB) dan   CriteriaQuery (CQ), lihat kembali efinisi cb dan cq
        // SELECT m FROM Menu m
        //Root<Menu> root = cq.from(Menu.class); //Root<Menu> root = cq.from(Menu.class);

        // SELECT m FROM Menu m (membangun query slelect)
        //cq.select(root); //atau
        // SELECT by ALL
       // List<Menu> resultList = em.createQuery(cq).getResultList();
        //System.out.println(resultList);
        // SELECT m FROM Menu m WHERE id =1 ;  ==> (lalu membangun from (milih)FROM Menu m ;
        //cq.where( cb.equal(root.get("id"), 1)); // jika baris ini dihapus, maka querry tetap dieksekusi, namun tanpa where, (SELECT semua)
        //List<Menu> resultList = em.createQuery(cq).getResultList();
        //System.out.println(resultList);
        //cq.where(cb.lessThan(root.get("price"), 10000));
        //List<Menu> menuList = em.createQuery(cq).getResultList();
        //System.out.println(menuList);
        /*cq.where(cb.like(root.get("name"), "%jero%"));// jero gak ada adanya Jero, maka harus di upercase
        List<Menu> list = em.createQuery(cq).getResultList();
        System.out.println(list);*/
//        sekarang dengan kasus lain, bagai mana jika input huru Kapitalnya tak beraturan misal Lodo, lodo, atau lodO.
        //Predicate name = cb.like(cb.lower(root.get("name")), "%" + stringQuery.toLowerCase() + "%");
        //cq.where(name);
//        atau

        //String stringQuery = "akhiR";
        // SELECT by ID and by NAME
        //cq.where(cb.like(cb.lower(root.get("name")),"%"+stringQuery.toLowerCase()+"%" ));
        //System.out.println(em.createQuery(cq).getResultList());
        // SELECT m.name FROM menu m WHERE id = 1;
        //cq.where(cb.equal(root.get("id"), 41));
        //List<Menu> menus = em.createQuery(cq).getResultList();
        //System.out.println(menus);

        //UPDATE
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Menu> cu = cb.createCriteriaUpdate(Menu.class);
        //CriteriaDelete<Menu> cd = cb.createCriteriaDelete(Menu.class);
        Root<Menu> root = cu.from(Menu.class);


        transaction.begin();
        cu.set(root.get("name"), 4000);
        cu.where(cb.equal(root.get("id"),45));
        em.createQuery(cu).executeUpdate();
        transaction.commit();
        System.out.println("UPDATE Succes");


        em.close();
        JpaUtil.shutDownEntityManager();
    }
}
