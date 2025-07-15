package ch.Elodin.DnD_Tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.Elodin.DnD_Tool.model.Clan;

import java.util.Optional;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Integer> {
	Optional<Clan> findByClan(String clan);
}
