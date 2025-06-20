package ch.Elodin.DnD_Tool.repository.ruf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.ruf.RufKonflikte;
import ch.Elodin.DnD_Tool.model.ruf.RufKonflikteKey;

@Repository
public interface RufKonflikteRepository extends JpaRepository<RufKonflikte, RufKonflikteKey> {
    
    // Du brauchst das hier eigentlich nicht, da findAll() bereits von JpaRepository geerbt wird.
    // Falls du es dennoch explizit deklarieren willst:
    @Override
    @SuppressWarnings("null")
    List<RufKonflikte> findAll();

}
