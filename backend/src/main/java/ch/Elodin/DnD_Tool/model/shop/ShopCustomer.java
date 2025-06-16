package ch.Elodin.DnD_Tool.model.shop;

import ch.Elodin.DnD_Tool.model.enums.EnumPosition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_customer")
public class ShopCustomer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_customer_ID")
    private int shop_customer_ID;

    
    
    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private EnumPosition position;
    
    
public int getShop_customer_ID() {
        return shop_customer_ID;
    }

    public void setShop_customer_ID(int shop_customer_ID) {
        this.shop_customer_ID = shop_customer_ID;
    }

    public EnumPosition getPosition() {
        return position;
    }

    public void setPosition(EnumPosition position) {
        this.position = position;
    }

}