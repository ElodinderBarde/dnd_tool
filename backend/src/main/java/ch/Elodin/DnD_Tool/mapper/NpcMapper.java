package ch.Elodin.DnD_Tool.mapper;

import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.model.Npc;

public class NpcMapper {

    public static NpcReadDTO toReadDTO(Npc npc) {
        NpcReadDTO dto = new NpcReadDTO();
        dto.setNpcId(npc.getNpc_ID());
        dto.setFirstname(npc.getFirstname() != null ? npc.getFirstname().getFirstname() : null);
        dto.setLastname(npc.getLastname() != null ? npc.getLastname().getLastname_ID() : null);
        dto.setRace(npc.getRace() != null ? npc.getRace().getRacename() : null);
        dto.setGender(npc.getGender() != null ? npc.getGender().getGender_ID() : null);
        dto.setNpcClass(npc.getNpcClass() != null ? npc.getNpcClass().getClassname() : null);
        dto.setSubclass(npc.getSubclass() != null ? npc.getSubclass().getSubclass_ID() : null);
        dto.setClan(npc.getClan() != null ? npc.getClan().getClan() : null);
        dto.setClanPosition(npc.getClan_position());
        dto.setAge(npc.getNpc_age());
        dto.setHaircolor(npc.getHaircolor() != null ? npc.getHaircolor().getName() : null);
        dto.setHairstyle(npc.getHairstyle() != null ? npc.getHairstyle().getName() : null);
        dto.setBeardstyle(npc.getBeardstyle() != null ? npc.getBeardstyle().getName() : null);
        dto.setTalkingStyle(npc.getTalkingstyle() != null ? npc.getTalkingstyle().getTalkingstyle() : null);
        dto.setJackets(npc.getJackets() != null ? npc.getJackets().getName() : null);
        dto.setTrousers(npc.getTrousers() != null ? npc.getTrousers().getName() : null);
        dto.setKleidungsQuali(npc.getKleidungQuali() != null ? npc.getKleidungQuali().getKleidungsQuali() : null);
        dto.setJewellery(npc.getJewellery() != null ? npc.getJewellery().getName() : null);
        dto.setArmor(npc.getArmor_ID() != null ? npc.getArmor_ID().getArmor() : null);
        dto.setBackground(npc.getBackground() != null ? npc.getBackground().getName() : null);
        dto.setPersonality(npc.getPersonality() != null ? npc.getPersonality().getPersonality_ID() : null);
        dto.setFlaw(npc.getFlaw() != null ? npc.getFlaw().getName() : null);
        dto.setLikes(npc.getLikes() != null ? npc.getLikes().getLikes_ID() : null);
        dto.setDislikes(npc.getDislikes() != null ? npc.getDislikes().getDislikes_ID() : null);
        dto.setIdeals(npc.getIdeals() != null ? npc.getIdeals().getIdeals() : null);
        dto.setOtherDescription(npc.getOtherDescription() != null ? npc.getOtherDescription().getText() : null);
        dto.setBetonung(npc.getBetonung() != null ? npc.getBetonung().getBetonung() : null);
        dto.setLevel(npc.getLevel() != null ? npc.getLevel().getLvl() : null);
        dto.setShop(npc.getShop_relations_ID() != null ? npc.getShop_relations_ID().getShop_ID() : null);
        dto.setNotes(npc.getNotes());

        return dto;
    }
}
