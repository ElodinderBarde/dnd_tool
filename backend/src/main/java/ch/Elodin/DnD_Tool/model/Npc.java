package ch.Elodin.DnD_Tool.model;

import ch.Elodin.DnD_Tool.model.enums.EnumSymbol;
import ch.Elodin.DnD_Tool.model.npcinfo.Armor;
import ch.Elodin.DnD_Tool.model.npcinfo.Background;
import ch.Elodin.DnD_Tool.model.npcinfo.Beardstyle;
import ch.Elodin.DnD_Tool.model.npcinfo.Betonung;
import ch.Elodin.DnD_Tool.model.npcinfo.Dislikes;
import ch.Elodin.DnD_Tool.model.npcinfo.Family;
import ch.Elodin.DnD_Tool.model.npcinfo.Firstname;
import ch.Elodin.DnD_Tool.model.npcinfo.Flaw;
import ch.Elodin.DnD_Tool.model.npcinfo.Gender;
import ch.Elodin.DnD_Tool.model.npcinfo.Haircolor;
import ch.Elodin.DnD_Tool.model.npcinfo.Hairstyle;
import ch.Elodin.DnD_Tool.model.npcinfo.Ideals;
import ch.Elodin.DnD_Tool.model.npcinfo.Jackets;
import ch.Elodin.DnD_Tool.model.npcinfo.Jewellery;
import ch.Elodin.DnD_Tool.model.npcinfo.KleidungQuali;
import ch.Elodin.DnD_Tool.model.npcinfo.Lastname;
import ch.Elodin.DnD_Tool.model.npcinfo.Level;
import ch.Elodin.DnD_Tool.model.npcinfo.Likes;
import ch.Elodin.DnD_Tool.model.npcinfo.NpcClass;
import ch.Elodin.DnD_Tool.model.npcinfo.OtherDescription;
import ch.Elodin.DnD_Tool.model.npcinfo.Personality;
import ch.Elodin.DnD_Tool.model.npcinfo.Picture;
import ch.Elodin.DnD_Tool.model.npcinfo.Race;
import ch.Elodin.DnD_Tool.model.npcinfo.Subclass;
import ch.Elodin.DnD_Tool.model.npcinfo.TalkingStyle;
import ch.Elodin.DnD_Tool.model.npcinfo.Trousers;
import ch.Elodin.DnD_Tool.model.shop.ShopRelations;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@Entity
@Table(name = "npc")
public class Npc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int npc_ID;


	@ManyToOne
	@JoinColumn(name = "npc_firstname_ID")
	private Firstname firstname;

	@ManyToOne
	@JoinColumn(name = "npc_lastname_ID")
	private Lastname lastname;

	@ManyToOne
	@JoinColumn(name = "shop_relations_ID")
	private ShopRelations shop_relations_ID;


	@Column(name = "clan_position")
	private String clan_position;


	@Column(name = "npc_age")
	private Integer npc_age;


	@ManyToOne
	@JoinColumn(name = "npc_family_ID")
	private Family npc_family_ID;

	// Verknüpfung zu Race
	@ManyToOne
	@JoinColumn(name = "race_ID")
	private Race race;

	// Verknüpfung zu Gender
	@ManyToOne
	@JoinColumn(name = "npc_gender_ID")
	private Gender gender;

	// Verknüpfung zu Clan
	@ManyToOne
	@JoinColumn(name = "clan_ID")
	private Clan clan;

	// Verknüpfung zu Betonung
	@ManyToOne
	@JoinColumn(name = "npc_betonung_ID")
	private Betonung betonung;

	// Verknüpfung zu Klasse
	@ManyToOne
	@JoinColumn(name = "npc_class_ID")
	private NpcClass npcClass;

	// Verknüpfung zu Subklasse
	@ManyToOne
	@JoinColumn(name = "npc_subclass_ID")
	private Subclass subclass;

	// Verknüpfung zu Likes
	@ManyToOne
	@JoinColumn(name = "npc_likes_ID")
	private Likes likes;

	// Verknüpfung zu Dislikes
	@ManyToOne
	@JoinColumn(name = "npc_dislikes_ID")
	private Dislikes dislikes;

	// Verknüpfung zu Personality
	@ManyToOne
	@JoinColumn(name = "npc_personality_ID")
	private Personality personality;

	// Verknüpfung zu Flaw
	@ManyToOne
	@JoinColumn(name = "npc_flaw_ID")
	private Flaw flaw;

	@ManyToOne
	@JoinColumn(name = "npc_ideals_ID")
	private Ideals ideals;

	@ManyToOne
	@JoinColumn(name = "npc_jackets_ID")
	private Jackets jackets;


	@ManyToOne
	@JoinColumn(name = "npc_kleidungsqualität_ID")
	private KleidungQuali KleidungQuali;


	@ManyToOne
	@JoinColumn(name = "npc_jewellery_ID")
	private Jewellery jewellery;

	@ManyToOne
	@JoinColumn(name = "npc_other_description_ID")
	private OtherDescription otherDescription;

	@ManyToOne
	@JoinColumn(name = "npc_background_ID")
	private Background background;

	@Setter
	@ManyToOne
	@JoinColumn(name = "npc_picture_ID")
	private Picture picture;


	@ManyToOne
	@JoinColumn(name = "npc_hairstyle_ID")
	private Hairstyle hairstyle;


	@ManyToOne
	@JoinColumn(name = "npc_talkingstyle_ID")
	private TalkingStyle talkingstyle;


	@ManyToOne
	@JoinColumn(name = "npc_trousers_ID")
	private Trousers trousers;

	@ManyToOne
	@JoinColumn(name = "npc_level_ID")
	private Level level;

	@Lob
	private String notes;


	@ManyToOne
	@JoinColumn(name = "npc_armorclass_ID")
	private Armor armor_ID;

	@Enumerated(EnumType.STRING)
	@Column(name = "symbol")
	private EnumSymbol symbol;

	@ManyToOne
	@JoinColumn(name = "npc_haircolor_ID")
	private Haircolor haircolor;

	@ManyToOne
	@JoinColumn(name = "npc_beardstyle_ID")
	private Beardstyle beardstyle;


}
	
