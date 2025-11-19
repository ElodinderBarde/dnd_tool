package ch.Elodin.DnD_Tool.dto;

import lombok.Getter;
import lombok.Setter;

public class ClanDTO {

    @Getter
    @Setter
    private Integer id;
    @Setter
    @Getter
    private String clan;
    @Setter
    @Getter
    private Integer mitglieder;
    @Setter
    @Getter
    private String familienclan;

    @Setter
    private Integer locationId;
    @Setter
    private String cityName;
    @Setter
    private String villageName;
    @Getter
    @Setter
    private String clanNotes;

    public ClanDTO() {}

    public Integer getLocationId() { return locationId; }

    public String getCityName() { return cityName; }

    public String getVillageName() { return villageName; }

    public void setClanNotes(String clanNotes) {
    }
    public void getClanNotes(String clanNotes) { this.clanNotes = clanNotes;}
}
