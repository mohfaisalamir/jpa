package com.enigma.purba_resto_jpa.enitity;

// kali ini entity kita daftarkan tanpa xml (misal : menu_mapping.xml),
// tapi menggunakan @Anotasi

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_product")
public class Menu {
    @Id
    @GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_sec",sequenceName = "m_product_id_seq", allocationSize = 1 )
    private Integer id;
    @Column(name = "name" ) // jika column dan property sama, seharusnya ini tidak perku
    private String name;
    private Long price;

    public Menu(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "\nMenu      : " +
                "\n\tid     : " + id +
                "\n\tMenu   : " + name  +
                "\n\tPrice  : " + price +"\n"+
                "-".repeat(30);
    }
}
