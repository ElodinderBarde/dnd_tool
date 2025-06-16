package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Jewellery;

@Repository
public interface JewelleryRepository extends JpaRepository<Jewellery, Integer> {

	List<Jewellery> findAll();

	Optional<Jewellery> findByname(String name);


}