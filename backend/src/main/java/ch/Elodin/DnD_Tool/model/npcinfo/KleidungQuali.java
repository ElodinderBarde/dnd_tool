package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_kleidungsqualität")
public class KleidungQuali {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_kleidungsqualität_ID")
    private int kleidungsQuali;

    @Column(name = "description", unique = true)
    private String description;

    
    
    
    
    
	public int getKleidungsQuali() {
		return kleidungsQuali;
	}

	public void setKleidungsQuali(int kleidungsQuali) {
		this.kleidungsQuali = kleidungsQuali;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
}