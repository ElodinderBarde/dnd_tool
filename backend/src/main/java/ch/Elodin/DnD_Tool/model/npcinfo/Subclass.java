package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_subclass")

public class Subclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_subclass_ID")
    private int subclass_ID;

    
    @Column(name = "name", unique = true)
    private String subclassname;

    @Column(name="npc_class_ID")
    private int class_ID;

	public int getSubclass_ID() {
		return subclass_ID;
	}

	public void setSubclass_ID(int subclass_ID) {
		this.subclass_ID = subclass_ID;
	}

	public String getSubclassname() {
		return subclassname;
	}

	public void setSubclassname(String subclassname) {
		this.subclassname = subclassname;
	}

	public int getClass_ID() {
		return class_ID;
	}

	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}


    




}
