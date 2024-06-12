package com.enigma.purba_resto_jpa;

import com.enigma.purba_resto_jpa.enitity.Menu;
import com.enigma.purba_resto_jpa.enitity.Table;
import com.enigma.purba_resto_jpa.util.JpaUtil;
import jakarta.persistence.*;

import java.util.List;

public class App {
    public static void main( String[] args )  {
        // CRUD di Hibernate/JPA :
        /*
         * Persist --> menyimpan object jedalam tabel/insert
         * find --> melakukan query select by ID
         * merge --> untuk melakukan UPDATE
         * remove --> melakukan query remove
         * */
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("purba_resto_jpa");
        EntityManager em = emf.createEntityManager();*/

        EntityManager em = JpaUtil.getEntityManager();
        List<Table> selectTable = em. createQuery("select c from Table c", Table.class).getResultList();
        System.out.println(selectTable);
        em.close();
        JpaUtil.shutDownEntityManager();
        // simulasi DELETE
       /* TableRepository repository = new TableRepositoryImpl(em);
        Table byId = repository.findById(1);
        System.out.println(byId);
        List<Table> all = repository.findAll();
        System.out.println(all);*/
        //repository.delete(byId);
        //repository.findById(1);

        // Crud pakai ORM + implement REPO
        //1. Insert
        /*repository.save(table);
        em.close();*/
        //2. READ BY ID
        /*Table byId = repository.findById(1);
        System.out.println(byId);
        em.close();*/
        //3. READ ALL
        /*List<Table> all = repository.findAll();
        System.out.println(all);*/

        //5. UPDATE;
        //repository.update(new Table(null,"T20"));

        //4. DELETE
        /*Table byId = repository.findById(5);
        repository.delete(byId);
        em.close();*/



        //save(emf);
        //findById(emf);
        //findAll(emf);
        //findById(emf);
        //save(emf);
        //findAll(emf);
        //update(emf);
        //delete(emf,16);
        //updateTable(emf,1,"T01"); // opsilain untuk melakukan update tanpa merge, tapi melakukan find, lalu ubah data "setData" tapi didalam transaction (commit-begin)
        //emf.close();
    }

/*
    private static void updateTable(EntityManagerFactory emf,Integer idTable, String nameTable) {
        try(EntityManager em = emf.createEntityManager()) {

            EntityTransaction transaction = em.getTransaction();
//        Table table = new Table(null,"T03");
            Table table = em.find(Table.class, idTable);
            transaction.begin();
            table.setTableName(nameTable);
            transaction.commit();
        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    private static void delete(EntityManagerFactory emf,Integer idCustomer) {

        try(EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            //Customer customer = findById(emf,idCustomer); //NB 0.1 : ini tidak bisa, karena memiliki em yang tidak dalam satu manage jadi harus bikin em sendiri sebagai berikut em.find(Customer.class, idCustomer)
            Customer customer = em.find(Customer.class, idCustomer);
            //em.remove(customer);
            if (customer != null) {
                em.remove(customer);
            } else {
                // Handle the case where no customer is found (optional)
                System.out.println("Customer not found with the provided ID.");
            }
            transaction.commit();
        }catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update(EntityManagerFactory emf) {
        //UPDATE ==> ini pakai interface .merge()
        try(EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Customer customer = new Customer(18,"Hemas Triaji","081239894564",false);
            em.merge(customer);
            tx.commit();

        }catch(RuntimeException   e){
            throw new RuntimeException(e);
        }
    }

    private static void findAll(EntityManagerFactory emf) {
        // FindAll
        // Criteria -> Programmatic
        // Querry -> JPQL (Java Persistence Query Langage)
        try (EntityManager em = emf.createEntityManager()){
            //TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);//it's like an Native sql : SELECT * FROM m_customer
            TypedQuery<Object[]> query = em.createQuery("select c.id,c.customerPhone, c.customerName from Customer c", Object[].class);
//            query.setMaxResults(99);
            List<Object[]> resultList = query.getResultList();
//            System.out.println(resultList);
            for (Object[] row : resultList) {
                String customerName = (String) row[2];
                Integer id = (Integer) row[0];
                String customerPhone = (String) row[1];
                System.out.println("\nId            : " +id +"\nCustomer Phone : " + customerPhone + "\nCustomer Name  : " + customerName +"\n"+"=".repeat(30));
            }
        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    private static Customer findById(EntityManagerFactory emf, Integer id) {
        try (EntityManager emfEntityManager = emf.createEntityManager()){
            return emfEntityManager.find(Customer.class, id);// (1,2) 1. kelas(representesi tabel) yang akan kita ambil datanya, 2. ini angka id yang akan kita ambil datanya
//            System.out.println(customer); // ini return balikannya Object Customer ya gais..

        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    private static void save(EntityManagerFactory emf) {
        // Entity Manager ini mirip Connection di JDBC ==> untuk melakukan Query
                EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer(17,"Hemas","082349777885",false);
        entityManager.persist(customer);
            transaction.commit();

        entityManager.close();
    }*/
}
//test commit II