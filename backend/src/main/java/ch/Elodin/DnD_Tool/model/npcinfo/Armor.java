package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_armorclass")
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="npc_armorclass_ID")
    private int id;

    @Column(name ="acvalue")
    private int acvalue;
    
    @Column(name = "npc_id")
    private Integer npc_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcvalue() {
		return acvalue;
	}

	public void setAcvalue(int acvalue) {
		this.acvalue = acvalue;
	}

	public Integer getNpc_id() {
		return npc_id;
	}

	public void setNpc_id(Integer npc_id) {
		this.npc_id = npc_id;
	}

	public int getArmor() {
		// TODO Auto-generated method stub
		return acvalue;
	}
    



    
}
