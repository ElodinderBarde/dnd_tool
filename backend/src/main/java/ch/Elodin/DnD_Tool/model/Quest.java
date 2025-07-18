package ch.Elodin.DnD_Tool.model;

import ch.Elodin.DnD_Tool.model.enums.EnumQuest;
import ch.Elodin.DnD_Tool.model.world.Location;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "quest")
public class Quest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quest_ID")
	private int questID;

	@Column(name = "questname")
	private String MonsterName;

	@Column(name = "description")
	private String description;

	
	
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EnumQuest status;

	@Column(name = "gruppe")
	private String group;

	@Column(name = "price_gold")
	private Integer price_gold;

	
	
	//evtl umstellen auf Item price_item, damit items erstellt und gegeben werden können
	@Column(name = "price_item")
	private String price_item;

	
	@ManyToOne
	@JoinColumn(name="questlocation")
	private Location questlocation;
	
	@Column(name = "notes")
	private String notes;

	@Column(name = "is_active")
	private boolean is_active;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "previous_quest_id")
	private Quest previousQuest;

	@JsonManagedReference
	@OneToMany(mappedBy = "previousQuest")
	private List<Quest> nextQuests;



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnumQuest getStatus() {
		return status;
	}

	public void setStatus(EnumQuest status) {
		this.status = status;
	}

	public Integer getPrice_gold() {
		return price_gold;
	}

	public void setPrice_gold(Integer price_gold) {
		this.price_gold = price_gold;
	}

	public String getPrice_item() {
		return price_item;
	}

	public void setPrice_item(String price_item) {
		this.price_item = price_item;
	}

	public Location getQuestlocation() {
		return questlocation;
	}

	public void setQuestlocation(Location questlocation) {
		this.questlocation = questlocation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	
	
	
	
	



	
	
	
}