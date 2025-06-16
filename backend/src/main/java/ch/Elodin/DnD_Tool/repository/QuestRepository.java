package ch.Elodin.DnD_Tool.repository;
import ch.Elodin.DnD_Tool.model.Quest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {
List<Quest> findAll();

}