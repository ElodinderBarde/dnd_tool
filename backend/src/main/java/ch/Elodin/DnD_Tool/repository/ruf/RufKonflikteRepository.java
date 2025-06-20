package ch.Elodin.DnD_Tool.repository.ruf;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.ruf.RufKonflikte;

@Repository
public interface RufKonflikteRepository extends JpaRepository<RufKonflikte, Integer> {
@SuppressWarnings("null")
	@Override
  List<RufKonflikte> findAll();

}