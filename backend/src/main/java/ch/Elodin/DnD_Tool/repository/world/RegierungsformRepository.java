package ch.Elodin.DnD_Tool.repository.world;

import ch.Elodin.DnD_Tool.model.world.Regierungsform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegierungsformRepository extends JpaRepository<Regierungsform, Integer> {
}
