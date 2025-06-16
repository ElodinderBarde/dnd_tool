package ch.Elodin.DnD_Tool.model.shop;

import jakarta.persistence.*;

@Entity
@Table(name = "shop_relations")
public class ShopRelations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_relations_ID")
    private int shop_relations;

    @Column(name = "shop_employee_ID", unique = true)
    private Integer shop_employee;
    
    
    @Column(name = "shop_customer_ID")
    private Integer shop_customer;

    @Column(name ="shop_ID")
    private Integer shop_ID;

	public int getShop_relations() {
		return shop_relations;
	}

	public void setShop_relations(int shop_relations) {
		this.shop_relations = shop_relations;
	}

	public Integer getShop_employee() {
		return shop_employee;
	}

	public void setShop_employee(Integer shop_employee) {
		this.shop_employee = shop_employee;
	}

	public Integer getShop_customer() {
		return shop_customer;
	}

	public void setShop_customer(Integer shop_customer) {
		this.shop_customer = shop_customer;
	}

	public Integer getShop_ID() {
		return shop_ID;
	}

	public void setShop_ID(Integer shop_ID) {
		this.shop_ID = shop_ID;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

    
    
    
    
    
}