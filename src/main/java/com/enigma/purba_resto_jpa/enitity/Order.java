package com.enigma.purba_resto_jpa.enitity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(generator = "order_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_seq",sequenceName = "t_order_id_seq", allocationSize = 1 )
    private Integer id;

    @Column(name = "trans_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private com.enigma.purba_resto_jpa.enitity.Table table;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderDetail> orderDetails;

    public Order(Integer id, Date orderDate, Customer customer, com.enigma.purba_resto_jpa.enitity.Table table, List<OrderDetail> orderDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.table = table;
        this.orderDetails = orderDetails;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public com.enigma.purba_resto_jpa.enitity.Table getTable() {
        return table;
    }

    public void setTable(com.enigma.purba_resto_jpa.enitity.Table table) {
        this.table = table;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String toString() {
        return "\nOrder : " +
                "\n\tid         : " + id +
                "\n\tDate       : " + orderDate  +
                "\n\tCustomer   : " + customer +
                "\n\tTable      : " + table +
                //"\n\tOrder Detai: " + orderDetails +
                "-".repeat(30);
    }

}
