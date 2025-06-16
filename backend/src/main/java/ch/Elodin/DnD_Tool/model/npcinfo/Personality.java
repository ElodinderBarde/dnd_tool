package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_personality")
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_personality_ID")
    private int personality_ID;

    
    @Column(name = "description", unique = true)
    private String description;


	public int getPersonality_ID() {
		return personality_ID;
	}


	public void setPersonality_ID(int personality_ID) {
		this.personality_ID = personality_ID;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}





}
