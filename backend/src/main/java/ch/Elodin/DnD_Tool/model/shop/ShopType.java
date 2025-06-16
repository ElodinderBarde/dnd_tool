package ch.Elodin.DnD_Tool.model.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "shop_type")
public class ShopType{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_type_ID")
    private int shop_type_ID;

    
    
    @Column(name = "name")
    private String name;



	public int getShop_type_ID() {
		return shop_type_ID;
	}



	public void setShop_type_ID(int shop_type_ID) {
		this.shop_type_ID = shop_type_ID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
    

  

}