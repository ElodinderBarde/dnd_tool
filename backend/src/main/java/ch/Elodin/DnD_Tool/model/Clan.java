package ch.Elodin.DnD_Tool.model;

import java.util.List;

import ch.Elodin.DnD_Tool.model.enums.Familienclan;
import ch.Elodin.DnD_Tool.model.ruf.Ruf;
import ch.Elodin.DnD_Tool.model.ruf.RufKonflikte;
import ch.Elodin.DnD_Tool.model.world.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "npc_clan")
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="clan_ID")
    private int id;

    @Column(name ="clanname", unique = true)
    private String clan;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_ID")
    private Location location;
    
    @Column(name = "mitglieder")
    private Integer mitglieder;
    
    @Column(name = "Familienclan", columnDefinition = "ENUM('Y','N')")
    @Enumerated(EnumType.STRING)
    private Familienclan familienclan;
    
    @OneToMany(mappedBy = "partei_source")
    private List<RufKonflikte> rufkonfliktsource;

    @OneToMany(mappedBy = "partei_target")
    private List<RufKonflikte> rufkonflikttarget;


	@Column(name = "clan_notes")
	private String clanNotes;

    
    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY)
    private List<Ruf> rufe;




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public Location  getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getMitglieder() {
		return mitglieder;
	}

	public void setMitglieder(Integer mitglieder) {
		this.mitglieder = mitglieder;
	}

	public Familienclan getFamilienclan() {
		return familienclan;
	}

	public void setFamilienclan(Familienclan familienclan) {
		this.familienclan = familienclan;
	}

	public void setClanNotes(String clanNotes) {
		this.clanNotes = clanNotes;
	}
	public  String getClanNotes() {
		return clanNotes;
	}

	public Integer getRufkonfliktsource()
    {return this.rufkonfliktsource.size();}


}
