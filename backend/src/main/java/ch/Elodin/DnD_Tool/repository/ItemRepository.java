package ch.Elodin.DnD_Tool.repository;
import ch.Elodin.DnD_Tool.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
List<Item> findAll();

@Query("SELECT DISTINCT i.buch FROM Item i WHERE i.buch IS NOT NULL")
List<String> findDistinctBuchValues();



}