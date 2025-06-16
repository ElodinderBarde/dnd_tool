package ch.Elodin.DnD_Tool.repository.world;

import ch.Elodin.DnD_Tool.model.world.Village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
}
