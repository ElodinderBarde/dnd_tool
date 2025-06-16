package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Firstname;

@Repository
public interface FirstnameRepository extends JpaRepository<Firstname, Integer> {

	List<Firstname> findAll();

	Optional<Firstname> findByFirstname(String Firstname);


}