package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "npc_lastname")
public class Lastname{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_lastname_ID")
    private int lastname_ID;

    @Column(name = "lastname", unique = true)
    private String lastname;


	@ManyToOne
	@JoinColumn(name = "racename")
	private Race race;







}