package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "npc_gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_gender_ID")
    private int gender_ID;

    
    @Column(name = "npc_gender")
    private String gendername;

    public int getGender_ID() {
        return gender_ID;
    }

    public void setGender_ID(int gender_ID) {
        this.gender_ID = gender_ID;
    }

    public String getGendername() {
        return gendername;
    }

    public void setGendername(String gendername) {
        this.gendername = gendername;
    }
}
