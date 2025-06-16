package ch.Elodin.DnD_Tool.model.world;



import ch.Elodin.DnD_Tool.model.Quest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="location_ID")
    private int id;



    @ManyToOne
    @JoinColumn(name ="village_ID", unique = true)
    private Village villageID;
    

    @ManyToOne
    @JoinColumn(name ="city_ID", unique = true)
    private City cityID;

    @ManyToOne
    @JoinColumn(name= "regierungsformID")
    private Regierungsform regierungsformID;
    
    
    @Column(name ="ortschaft_ruf")
    private int ortschaftRuf;
    
    
    @ManyToOne
    @JoinColumn(name="questlocation")
    private Quest questlocation;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Village getVillageID() {
		return villageID;
	}


	public void setVillageID(Village villageName) {
		this.villageID= villageName;
	}


	public City getCityID() {
		return cityID;
	}


	public void setCityID(City city_name) {
		this.cityID = city_name;
	}


	public Regierungsform getRegierungsformID() {
		return regierungsformID;
	}


	public void setRegierungsformID(Regierungsform regierungsformID) {
		this.regierungsformID = regierungsformID;
	}


	public int getOrtschaftRuf() {
		return ortschaftRuf;
	}


	public void setOrtschaftRuf(int ortschaftRuf) {
		this.ortschaftRuf = ortschaftRuf;
	}


	


}