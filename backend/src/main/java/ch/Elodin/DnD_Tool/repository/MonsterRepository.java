package ch.Elodin.DnD_Tool.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {
@SuppressWarnings("null")
@Override
List<Monster> findAll();

}