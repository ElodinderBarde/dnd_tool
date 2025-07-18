package ch.Elodin.DnD_Tool.model.npcinfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "npc_kleidungsqualität")
public class KleidungQuali {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_kleidungsqualität_ID")
    private int kleidungsQuali;

    @Column(name = "description", unique = true)
    private String description;

    
    
    
    

}