
package ch.Elodin.DnD_Tool.dto;

import ch.Elodin.DnD_Tool.model.enums.EnumItemTypes;
import ch.Elodin.DnD_Tool.model.enums.Familienclan;

public class ItemDTO {

 private int id;
 private String name;
 private int price;
 private EnumItemTypes typ;
 private String seltenheit;
 private String buch;
 private Integer seite1;
 private Integer seite2;
 private Integer seite3;
 private Familienclan einstimmung;
 private String beschreibung;




 public ItemDTO(int id, String name, int price, EnumItemTypes typ, String seltenheit,
                String buch, Integer seite1, Integer seite2, Integer seite3,
                Familienclan einstimmung, String beschreibung) {
     this.id = id;
     this.name = name;
     this.price = price;
     this.typ = typ;
     this.seltenheit = seltenheit;
     this.buch = buch;
     this.seite1 = seite1;
     this.seite2 = seite2;
     this.seite3 = seite3;
     this.einstimmung = einstimmung;
     this.beschreibung = beschreibung;
 }

 public ItemDTO() {
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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


    public void setItemName(String name) { this.name = name;}
}
