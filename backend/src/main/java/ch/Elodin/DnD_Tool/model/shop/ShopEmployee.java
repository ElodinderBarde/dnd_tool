package ch.Elodin.DnD_Tool.model.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_employee")
public class ShopEmployee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_employee_ID")
    private int shop_employee_ID;

    
    
    @Column(name = "position")
    private String position;



	public int getShop_employee_ID() {
		return shop_employee_ID;
	}



	public void setShop_employee_ID(int shop_employee_ID) {
		this.shop_employee_ID = shop_employee_ID;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}
    


}