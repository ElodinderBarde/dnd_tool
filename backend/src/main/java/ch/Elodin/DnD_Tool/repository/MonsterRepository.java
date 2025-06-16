package ch.Elodin.DnD_Tool.repository;
import ch.Elodin.DnD_Tool.model.Monster;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {
List<Monster> findAll();

}