package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_lastname")
public class Lastname{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_lastname_ID")
    private int lastname_ID;

    @Column(name = "lastname", unique = true)
    private String lastname;
    
    
    @Column(name = "racename")
    private String racename;


	public int getLastname_ID() {
		return lastname_ID;
	}


	public void setLastname_ID(int lastname_ID) {
		this.lastname_ID = lastname_ID;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getRacename() {
		return racename;
	}


	public void setRacename(String racename) {
		this.racename = racename;
	}
    
    
    
    
    
    
}