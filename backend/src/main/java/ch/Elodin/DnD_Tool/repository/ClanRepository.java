package ch.Elodin.DnD_Tool.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.Clan;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Integer> {

	List<Clan> findAll();

	Optional<Clan> findByClan(String clan);


}