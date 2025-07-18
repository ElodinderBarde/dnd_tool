package ch.Elodin.DnD_Tool.model.npcinfo;

import ch.Elodin.DnD_Tool.model.enums.EnumGender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "npc_firstname")
public class Firstname {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_firstname_ID")
    private int firstname_ID;

    @Column(name = "firstname", unique = true)
    private String firstname;


	@ManyToOne
	@JoinColumn(name = "gender_ID")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "race_ID")
	private Race race;


	public void setGender(Gender gender) {
		this.gender = gender;
	}


}