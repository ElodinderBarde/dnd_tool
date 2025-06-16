package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_class")
public class NpcClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_class_ID")
    private int class_ID;

    
    @Column(name = "name", unique = true)
    private String classname;


	public int getClass_ID() {
		return class_ID;
	}


	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}







}
