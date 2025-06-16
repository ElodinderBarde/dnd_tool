package ch.Elodin.DnD_Tool.repository.npcinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

	List<Gender> findAll();

	Optional<Gender> findByGendername(String gendername);


}