package ch.Elodin.DnD_Tool.model.npcinfo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "npc_gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_gender_ID")
    private int gender_ID;

    
    @Column(name = "npc_gender")
    private String gendername;



}
