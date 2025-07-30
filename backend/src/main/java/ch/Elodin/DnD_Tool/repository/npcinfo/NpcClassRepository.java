package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import ch.Elodin.DnD_Tool.model.npcinfo.NpcClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NpcClassRepository extends JpaRepository<NpcClass, Integer> {
    @SuppressWarnings("null")
    @Override
    List<NpcClass> findAll();

    Optional<NpcClass> findByClassname(String classname);


}