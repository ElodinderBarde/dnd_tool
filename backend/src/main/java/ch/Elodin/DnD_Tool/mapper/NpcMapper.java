package ch.Elodin.DnD_Tool.mapper;

import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.model.enums.EnumSymbol;
import ch.Elodin.DnD_Tool.model.shop.ShopRelations;

public class NpcMapper {

    public static NpcReadDTO toReadDTO(Npc npc) {
        NpcReadDTO dto = new NpcReadDTO();

        dto.setNpcId(npc.getNpc_ID());
        dto.setFirstname(npc.getFirstname() != null ? npc.getFirstname().getFirstname() : null);
        dto.setLastname(npc.getLastname() != null ? npc.getLastname().getLastname() : null);
        dto.setRace(npc.getRace() != null ? npc.getRace().getRacename() : null);
        dto.setGender(npc.getGender() != null ? npc.getGender().getGendername() : null);
        dto.setNpcClass(npc.getNpcClass() != null ? npc.getNpcClass().getClassname() : null);
        dto.setSubclass(npc.getSubclass() != null ? npc.getSubclass().getSubclassname() : null);
        dto.setClan(npc.getClan() != null ? npc.getClan().getClan() : null);
        dto.setClanPosition(npc.getClan_position());
        dto.setAge(npc.getNpc_age());
        dto.setHaircolor(npc.getHaircolor() != null ? npc.getHaircolor().getName() : null);
        dto.setHairstyle(npc.getHairstyle() != null ? npc.getHairstyle().getName() : null);
        dto.setBeardstyle(npc.getBeardstyle() != null ? npc.getBeardstyle().getName() : null);
        dto.setTalkingStyle(npc.getTalkingstyle() != null ? npc.getTalkingstyle().getDescription() : null);
        dto.setJackets(npc.getJackets() != null ? npc.getJackets().getName() : null);
        dto.setTrousers(npc.getTrousers() != null ? npc.getTrousers().getName() : null);
        dto.setKleidungsQuali(npc.getKleidungQuali() != null ? npc.getKleidungQuali().getDescription() : null);
        dto.setJewellery(npc.getJewellery() != null ? npc.getJewellery().getName() : null);
        dto.setArmor(npc.getArmor_ID() != null ? npc.getArmor_ID().getArmor() : null);
        dto.setBackground(npc.getBackground() != null ? npc.getBackground().getName() : null);
        dto.setPersonality(npc.getPersonality() != null ? npc.getPersonality().getDescription() : null);
        dto.setFlaw(npc.getFlaw() != null ? npc.getFlaw().getName() : null);
        dto.setLikes(npc.getLikes() != null ? npc.getLikes().getDescription() : null);
        dto.setDislikes(npc.getDislikes() != null ? npc.getDislikes().getDescription() : null);
        dto.setIdeals(npc.getIdeals() != null ? npc.getIdeals().getDescription() : null);
        dto.setOtherDescription(npc.getOtherDescription() != null ? npc.getOtherDescription().getText() : null);
        dto.setBetonung(npc.getBetonung() != null ? npc.getBetonung().getBetonung() : null);
        dto.setLevel(npc.getLevel() != null ? npc.getLevel().getLvl() : null);
        // dto.setShopRelation(...) Zeile ENTFERNT

        if (npc.getShop_relations_ID() != null) {
            ShopRelations relation = npc.getShop_relations_ID();
            StringBuilder sb = new StringBuilder();

            if (relation.getShopEmployeeRole() != null) {
                sb.append("Mitarbeiter: ").append(relation.getShopEmployeeRole().getPosition());
            } else if (relation.getShopCustomerRole() != null) {
                sb.append("Kunde: ").append(relation.getShopCustomerRole().getPosition());
            } else {
                sb.append("unbekannt");
            }

            if (relation.getShop() != null) {
                sb.append(" bei ").append(relation.getShop().getName());
                sb.append(" in ").append(relation.getShop().getLocation());
            }

            dto.setShopRelation(sb.toString());
        } else {
            dto.setShopRelation("Nicht Zugeordnet");
        }




        dto.setFamily(npc.getNpc_family_ID() != null ? npc.getNpc_family_ID().getFamilienname() : null);
        dto.setPictureUrl(npc.getPicture() != null ? npc.getPicture().getPicture() : null);
        dto.setNotes(npc.getNotes());
        dto.setSymbol(npc.getSymbol() != null ? EnumSymbol.valueOf(npc.getSymbol().name()) : null);

        return dto;
    }
}
