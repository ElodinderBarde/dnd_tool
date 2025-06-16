package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

	List<Picture> findAll();

	Optional<Picture> findByPicture(String picture);


}