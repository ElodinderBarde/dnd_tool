package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import ch.Elodin.DnD_Tool.model.npcinfo.Gender;
import ch.Elodin.DnD_Tool.model.npcinfo.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Firstname;

@Repository
public interface FirstnameRepository extends JpaRepository<Firstname, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Firstname> findAll();

	Optional<Firstname> findByFirstname(String Firstname);
	Optional<Firstname> findByFirstnameAndRaceAndGender(String firstname, Race race, Gender gender);


}