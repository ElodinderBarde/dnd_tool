package ch.Elodin.DnD_Tool.repository.ruf;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.ruf.Ruf;

@Repository
public interface RufRepository extends JpaRepository<Ruf, Integer> {
@SuppressWarnings("null")
	@Override
  List<Ruf> findAll();

}