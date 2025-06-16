package ch.Elodin.DnD_Tool.model;

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

@Entity
@Table(name = "npc")
public class Npc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int npc_ID;

    
    @ManyToOne
    @JoinColumn(name="npc_firstname_ID")
    private Firstname firstname;
    
    @ManyToOne
    @JoinColumn(name="npc_lastname_ID")
    private Lastname lastname;
    
    @ManyToOne
    @JoinColumn(name="shop_relations_ID")
    private ShopRelations shop_relations_ID;

    
    
    @Column(name="clan_position")
    private String clan_position;

    
    
    @Column(name="npc_age")
    private Integer npc_age;

    
    @ManyToOne
    @JoinColumn(name="npc_family_ID")
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
    @JoinColumn(name="npc_ideals_ID")
    private Ideals ideals;
    
     @ManyToOne
     @JoinColumn(name="npc_jackets_ID")
     private Jackets jackets;
    
     
     @ManyToOne
     @JoinColumn(name="npc_kleidungsqualität_ID")
     private KleidungQuali KleidungQuali;
     
    
     @ManyToOne
     @JoinColumn(name="npc_jewellery_ID")
     private Jewellery jewellery;
     
     @ManyToOne
     @JoinColumn(name="npc_other_description_ID")
     private OtherDescription otherDescription;
     
     @ManyToOne
     @JoinColumn(name="npc_background_ID")
     private Background background;
     
     @ManyToOne
     @JoinColumn(name="npc_picture_ID")
     private Picture picture;
     
     
    @ManyToOne
    @JoinColumn(name = "npc_hairstyle_ID")
    private Hairstyle hairstyle;
    
    
    @ManyToOne
    @JoinColumn(name ="npc_talkingstyle_ID")
    private TalkingStyle talkingstyle;
    
    
    @ManyToOne
    @JoinColumn(name="npc_trousers_ID")
    private Trousers trousers;
    
    @ManyToOne
    @JoinColumn(name = "npc_level_ID")
    private Level level;

    @Lob
    private String notes;


    @ManyToOne
    @JoinColumn(name = "npc_armorclass_ID")
    private Armor armor_ID;

	
    
    @ManyToOne
    @JoinColumn(name="npc_haircolor_ID")
    private Haircolor haircolor;
    
    @ManyToOne
    @JoinColumn(name="npc_beardstyle_ID")
    private Beardstyle beardstyle;
    
    
    
    
    
    
    
    public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Haircolor getHaircolor() {
		return haircolor;
	}

	public void setHaircolor(Haircolor haircolor) {
		this.haircolor = haircolor;
	}

	public Beardstyle getBeardstyle() {
		return beardstyle;
	}

	public void setBeardstyle(Beardstyle beardstyle) {
		this.beardstyle = beardstyle;
	}

	public Trousers getTrousers() {
		return trousers;
	}

	public void setTrousers(Trousers trousers) {
		this.trousers = trousers;
	}

	public int getNpc_ID() {
		return npc_ID;
	}

	public void setNpc_ID(int npc_ID) {
		this.npc_ID = npc_ID;
	}

	public Firstname getFirstname() {
		return firstname;
	}

	public void setFirstname(Firstname firstname) {
		this.firstname = firstname;
	}

	public Lastname getLastname() {
		return lastname;
	}

	public void setLastname(Lastname lastname) {
		this.lastname = lastname;
	}

	public ShopRelations getShop_relations_ID() {
		return shop_relations_ID;
	}

	public void setShop_relations_ID(ShopRelations shop_relations_ID) {
		this.shop_relations_ID = shop_relations_ID;
	}

	public String getClan_position() {
		return clan_position;
	}

	public void setClan_position(String clan_position) {
		this.clan_position = clan_position;
	}

	public Integer getNpc_age() {
		return npc_age;
	}

	public void setNpc_age(Integer npc_age) {
		this.npc_age = npc_age;
	}

	public Family getNpc_family_ID() {
		return npc_family_ID;
	}

	public void setNpc_family_ID(Family npc_family_ID) {
		this.npc_family_ID = npc_family_ID;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Betonung getBetonung() {
		return betonung;
	}

	public void setBetonung(Betonung betonung) {
		this.betonung = betonung;
	}

	public NpcClass getNpcClass() {
		return npcClass;
	}

	public void setNpcClass(NpcClass npcClass) {
		this.npcClass = npcClass;
	}

	public Subclass getSubclass() {
		return subclass;
	}

	public void setSubclass(Subclass subclass) {
		this.subclass = subclass;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public Dislikes getDislikes() {
		return dislikes;
	}

	public void setDislikes(Dislikes dislikes) {
		this.dislikes = dislikes;
	}

	public Personality getPersonality() {
		return personality;
	}

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public Flaw getFlaw() {
		return flaw;
	}

	public void setFlaw(Flaw flaw) {
		this.flaw = flaw;
	}

	public Ideals getIdeals() {
		return ideals;
	}

	public void setIdeals(Ideals ideals) {
		this.ideals = ideals;
	}

	public Jackets getJackets() {
		return jackets;
	}

	public void setJackets(Jackets jackets) {
		this.jackets = jackets;
	}

	public KleidungQuali getKleidungQuali() {
		return KleidungQuali;
	}

	public void setKleidungQuali(KleidungQuali kleidungQuali) {
		KleidungQuali = kleidungQuali;
	}

	public Jewellery getJewellery() {
		return jewellery;
	}

	public void setJewellery(Jewellery jewellery) {
		this.jewellery = jewellery;
	}

	public Hairstyle getHairstyle() {
		return hairstyle;
	}

	public void setHairstyle(Hairstyle hairstyle) {
		this.hairstyle = hairstyle;
	}

	public TalkingStyle getTalkingstyle() {
		return talkingstyle;
	}

	public void setTalkingstyle(TalkingStyle talkingstyle) {
		this.talkingstyle = talkingstyle;
	}


	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	public OtherDescription getOtherDescription() {
		return otherDescription;
	}

	public void setOtherDescription(OtherDescription otherDescription) {
		this.otherDescription = otherDescription;
	}

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Armor getArmor_ID() {
		return armor_ID;
	}

	public void setArmor_ID(Armor armor_ID) {
		this.armor_ID = armor_ID;
	}


    
    
}


	
