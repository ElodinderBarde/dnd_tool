package ch.Elodin.DnD_Tool.model.npcinfo;

import ch.Elodin.DnD_Tool.model.enums.EnumGender;
import jakarta.persistence.*;

@Entity
@Table(name = "npc_firstname")
public class Firstname {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_firstname_ID")
    private int firstname_ID;

    @Column(name = "firstname", unique = true)
    private String firstname;
    
    
    @Column(name = "npc_gender")
    @Enumerated(EnumType.STRING)
    private EnumGender gender;
    
    @Column(name = " race_ID")
    private int race_ID;
    
    
    
    
    
    

	public int getFirstname_ID() {
		return firstname_ID;
	}

	public void setFirstname_ID(int firstname_ID) {
		this.firstname_ID = firstname_ID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

	public int getRace_ID() {
		return race_ID;
	}

	public void setRace_ID(int race_ID) {
		this.race_ID = race_ID;
	}
    
    
    
}