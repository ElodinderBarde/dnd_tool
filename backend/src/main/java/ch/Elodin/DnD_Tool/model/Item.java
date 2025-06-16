package ch.Elodin.DnD_Tool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.Elodin.DnD_Tool.model.enums.EnumItemTypes;
import ch.Elodin.DnD_Tool.model.enums.Familienclan;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemID")
	private int ItemID;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "price")
	private int price;

	@Column(name = "Typ")
	@Enumerated(EnumType.STRING)
	private EnumItemTypes typ;

	@Column(name = "seltenheit")
	private String seltenheit;

	@Column(name = "buch")
	private String buch;

	@Column(name = "seite1")
	private Integer seite1;

	@Column(name = "seite2")
	private Integer seite2;
	
	@Column(name = "seite3")
	private Integer seite3;

	@Column(name = "einstimmung")
	@Enumerated(EnumType.STRING)
	private Familienclan einstimmung;

	@Column(name = "beschreibung")
	private String beschreibung;

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public EnumItemTypes getTyp() {
		return typ;
	}

	public void setTyp(EnumItemTypes typ) {
		this.typ = typ;
	}

	public String getSeltenheit() {
		return seltenheit;
	}

	public void setSeltenheit(String seltenheit) {
		this.seltenheit = seltenheit;
	}

	public String getBuch() {
		return buch;
	}

	public void setBuch(String buch) {
		this.buch = buch;
	}

	public Integer getSeite1() {
		return seite1;
	}

	public void setSeite1(Integer seite1) {
		this.seite1 = seite1;
	}

	public Integer getSeite2() {
		return seite2;
	}

	public void setSeite2(Integer seite2) {
		this.seite2 = seite2;
	}

	public Integer getSeite3() {
		return seite3;
	}

	public void setSeite3(Integer seite3) {
		this.seite3 = seite3;
	}

	public Familienclan getEinstimmung() {
		return einstimmung;
	}

	public void setEinstimmung(Familienclan einstimmung) {
		this.einstimmung = einstimmung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

}