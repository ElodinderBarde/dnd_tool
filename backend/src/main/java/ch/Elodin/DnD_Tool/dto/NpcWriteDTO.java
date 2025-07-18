package ch.Elodin.DnD_Tool.dto;

import ch.Elodin.DnD_Tool.model.enums.EnumSymbol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NpcWriteDTO {

    private int npc_ID;
    private int firstnameId;
    private int lastnameId;
    private int shopRelationsId;
    private String clan_position;
    private Integer npc_age;
    private int familyId;
    private int raceId;
    private int genderId;
    private int clanId;
    private int betonungId;
    private int classId;
    private int subclassId;
    private int likesId;
    private int dislikesId;
    private int personalityId;
    private int flawId;
    private int idealsId;
    private int jacketsId;
    private int kleidungQualiId;
    private int jewelleryId;
    private int otherDescriptionId;
    private int backgroundId;
    private int pictureId;
    private int hairstyleId;
    private int talkingstyleId;
    private int trousersId;
    private int levelId;
    private int armorId;
    private int haircolorId;
    private int beardstyleId;
    private String notes;



    private Integer level;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    private int shopRelation;
    private int family;
    private EnumSymbol symbol;
}