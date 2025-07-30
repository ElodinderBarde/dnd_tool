package ch.Elodin.DnD_Tool.model.npcinfo;

import ch.Elodin.DnD_Tool.model.Npc;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "npc_stats")
public class Stats {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "npc_stats_ID")
	    private int npcStatsId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "npc_ID", referencedColumnName = "npc_ID")
	@JsonIgnore
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


}
