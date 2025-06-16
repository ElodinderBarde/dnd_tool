package ch.Elodin.DnD_Tool.model.world;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import ch.Elodin.DnD_Tool.model.enums.EnumRegierungsform;

@Entity
@Table(name = "regierungsform")
public class Regierungsform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="regierungsformID")
    private int regierungsformID;

    @Column(name ="regierungsform", unique = true)
    @Enumerated(EnumType.STRING)
    private EnumRegierungsform regierungsform;

	public int getRegierungsformID() {
		return regierungsformID;
	}

	public void setRegierungsformID(int regierungsformID) {
		this.regierungsformID = regierungsformID;
	}

	public EnumRegierungsform getRegierungsform() {
		return regierungsform;
	}

	public void setRegierungsform(EnumRegierungsform regierungsform) {
		this.regierungsform = regierungsform;
	}
    
    
}