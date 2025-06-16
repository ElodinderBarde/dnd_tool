package ch.Elodin.DnD_Tool.model.npcinfo;

import ch.Elodin.DnD_Tool.model.enums.Verbreitung;
import jakarta.persistence.*;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_ID")
    private int id;

    @Column(name = "racename", unique = true)
    private String racename;

    @Column(name = "maxage")
    private int maxAge;

    @Column(name = "oldage")
    private int oldAge;

    @Column(name = "adultage")
    private int adultAge;

    @Column(name = "teenage")
    private int teenage;

    @Column(name = "promt", length = 1000)
    private String prompt;

    @Column(name = "verbreitung")
    @Enumerated(EnumType.STRING)
    private Verbreitung verbreitung;

    @Column(name = "verbreitung_in_promille")
    private int verbreitungInPromille;

    // Standard-Konstruktor
    public Race() {
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRacename() {
        return racename;
    }

    public void setRacename(String racename) {
        this.racename = racename;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getOldAge() {
        return oldAge;
    }

    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }

    public int getAdultAge() {
        return adultAge;
    }

    public void setAdultAge(int adultAge) {
        this.adultAge = adultAge;
    }

    public int getTeenage() {
        return teenage;
    }

    public void setTeenage(int teenage) {
        this.teenage = teenage;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Verbreitung getVerbreitung() {
        return verbreitung;
    }

    public void setVerbreitung(Verbreitung verbreitung) {
        this.verbreitung = verbreitung;
    }

    public int getVerbreitungInPromille() {
        return verbreitungInPromille;
    }

    public void setVerbreitungInPromille(int verbreitungInPromille) {
        this.verbreitungInPromille = verbreitungInPromille;
    }
}
