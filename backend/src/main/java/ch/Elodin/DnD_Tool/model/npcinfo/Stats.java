package ch.Elodin.DnD_Tool.model.npcinfo;

import ch.Elodin.DnD_Tool.model.Npc;
import jakarta.persistence.*;

@Entity
@Table(name = "npc_stats")
public class Stats {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "npc_stats_ID")
	    private int npcStatsId;

	    @OneToOne
	    @JoinColumn(name = "npc_ID")
	    private Npc npc;

	    @Column(name = "strength")
	    private int strength;

	    @Column(name = "dexterity")
	    private int dexterity;

	    @Column(name = "constitution")
	    private int constitution;

	    @Column(name = "intelligence")
	    private int intelligence;

	    @Column(name = "wisdom")
	    private int wisdom;

	    @Column(name = "charisma")
	    private int charisma;


	    
	    
	    
	    public int getNpcStatsId() {
	        return npcStatsId;
	    }

	    public void setNpcStatsId(int npcStatsId) {
	        this.npcStatsId = npcStatsId;
	    }

	    public Npc getNpc() {
	        return npc;
	    }

	    public void setNpc(Npc npc) {
	        this.npc = npc;
	    }

	    public int getStrength() {
	        return strength;
	    }

	    public void setStrength(int strength) {
	        this.strength = strength;
	    }

	    public int getDexterity() {
	        return dexterity;
	    }

	    public void setDexterity(int dexterity) {
	        this.dexterity = dexterity;
	    }

	    public int getConstitution() {
	        return constitution;
	    }

	    public void setConstitution(int constitution) {
	        this.constitution = constitution;
	    }

	    public int getIntelligence() {
	        return intelligence;
	    }

	    public void setIntelligence(int intelligence) {
	        this.intelligence = intelligence;
	    }

	    public int getWisdom() {
	        return wisdom;
	    }

	    public void setWisdom(int wisdom) {
	        this.wisdom = wisdom;
	    }

	    public int getCharisma() {
	        return charisma;
	    }

	    public void setCharisma(int charisma) {
	        this.charisma = charisma;
	    }
    

}
