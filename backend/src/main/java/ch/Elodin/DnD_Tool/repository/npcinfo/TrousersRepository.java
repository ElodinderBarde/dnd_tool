package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Trousers;

@Repository
public interface TrousersRepository extends JpaRepository<Trousers, Integer> {

	@SuppressWarnings("null")
	@Override
	List<Trousers> findAll();

	Optional<Trousers> findByname(String name);


}