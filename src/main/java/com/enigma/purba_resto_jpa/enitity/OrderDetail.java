package com.enigma.purba_resto_jpa.enitity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "order_detail_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_detail_seq",sequenceName = "t_order_detail_id_seq", allocationSize = 1 )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Menu menu;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderDetail(Integer id, Order order, Menu menu, Integer quantity) {
        this.id = id;
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "\nOrder Detail: " +
                "\n\tid         : " + id +
                "\n\tCustomer   : " + order  +
                "\n\tMenu       : " + menu +
                "\n\tQuantity   : " + quantity +"\n"+
                "-".repeat(30);
    }
}
