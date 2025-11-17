package ch.Elodin.DnD_Tool.mapper;

import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.dto.NpcWriteDTO;

import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.model.enums.EnumSymbol;
import ch.Elodin.DnD_Tool.model.shop.ShopRelations;
import ch.Elodin.DnD_Tool.model.npcinfo.Stats;
import ch.Elodin.DnD_Tool.repository.ClanRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.*;
import ch.Elodin.DnD_Tool.repository.shop.ShopRelationsRepository;
import org.mapstruct.Mapper;


public class NpcMapper {

    public static NpcReadDTO toReadDTO(Npc npc, Stats stats) {
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
        dto.setSymbol(npc.getSymbol() != null ? npc.getSymbol() :null);

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

        if (stats != null) {
            dto.setStrength(stats.getStrength());
            dto.setDexterity(stats.getDexterity());
            dto.setConstitution(stats.getConstitution());
            dto.setIntelligence(stats.getIntelligence());
            dto.setWisdom(stats.getWisdom());
            dto.setCharisma(stats.getCharisma());
        }

        dto.setFamily(npc.getNpc_family_ID() != null ? npc.getNpc_family_ID().getFamilienname() : null);
        dto.setPictureUrl(npc.getPicture() != null ? npc.getPicture().getPicture() : null);
        dto.setNotes(npc.getNotes());
        dto.setSymbol(npc.getSymbol() != null ? EnumSymbol.valueOf(npc.getSymbol().name()) : null);

        return dto;
    }

    public static NpcReadDTO toReadDTOShort(Npc npc) {
        NpcReadDTO dto = new NpcReadDTO();

        dto.setNpcId(npc.getNpc_ID());
        dto.setFirstname(npc.getFirstname() != null ? npc.getFirstname().getFirstname() : null);
        dto.setLastname(npc.getLastname() != null ? npc.getLastname().getLastname() : null);
        dto.setRace(npc.getRace() != null ? npc.getRace().getRacename() : null);
        dto.setGender(npc.getGender() != null ? npc.getGender().getGendername() : null);
        dto.setAge(npc.getNpc_age());

        if (npc.getShop_relations_ID() != null) {
            ShopRelations relation = npc.getShop_relations_ID();

            if (relation.getShopEmployeeRole() != null) {
                dto.setShopRelation(relation.getShopEmployeeRole().getPosition());
            } else if (relation.getShopCustomerRole() != null) {
                dto.setShopRelation(relation.getShopCustomerRole().getPosition());
            } else {
                dto.setShopRelation("unbekannt");
            }
        } else {
            dto.setShopRelation("Nicht Zugeordnet");
        }

        return dto;
    }


    public static void updateEntityFromDto(
            Npc npc,
            NpcWriteDTO dto,
            FirstnameRepository firstnameRepository,
            LastnameRepository lastnameRepository,
            GenderRepository genderRepository,
            RaceRepository raceRepository,
            LevelRepository levelRepository,
            PersonalityRepository personalityRepository,
            OtherDescriptionRepository otherDescriptionRepository,
            LikesRepository likesRepository,
            DislikesRepository dislikesRepository,
            IdealsRepository idealsRepository,
            KleidungQualiRepository kleidungQualiRepository,
            JacketsRepository jacketsRepository,
            TrousersRepository trousersRepository,
            HairstyleRepository hairstyleRepository,
            HaircolorRepository haircolorRepository,
            BeardstyleRepository beardstyleRepository,
            ArmorRepository armorRepository,
            NpcClassRepository npcClassRepository,
            SubclassRepository subclassRepository,
            BetonungRepository betonungRepository,
            FlawRepository flawRepository,
            JewelleryRepository jewelleryRepository,
            BackgroundRepository backgroundRepository,
            TalkingStyleRepository talkingStyleRepository,
            PictureRepository pictureRepository,
            ClanRepository clanRepository,
            ShopRelationsRepository shopRelationsRepository



    ) {
        npc.setFirstname(firstnameRepository.findById(dto.getFirstnameId()).orElseThrow());
        npc.setLastname(lastnameRepository.findById(dto.getLastnameId()).orElseThrow());
        npc.setNpc_age(dto.getNpc_age());
        npc.setGender(genderRepository.findById(dto.getGenderId()).orElseThrow());
        npc.setRace(raceRepository.findById(dto.getRaceId()).orElseThrow());
        npc.setLevel(levelRepository.findById(dto.getLevelId()).orElseThrow());
        npc.setPersonality(personalityRepository.findById(dto.getPersonalityId()).orElseThrow());
        npc.setOtherDescription(otherDescriptionRepository.findById(dto.getOtherDescriptionId()).orElseThrow());
        npc.setLikes(likesRepository.findById(dto.getLikesId()).orElseThrow());
        npc.setDislikes(dislikesRepository.findById(dto.getDislikesId()).orElseThrow());
        npc.setIdeals(idealsRepository.findById(dto.getIdealsId()).orElseThrow());
        npc.setKleidungQuali(kleidungQualiRepository.findById(dto.getKleidungQualiId()).orElseThrow());
        npc.setJackets(jacketsRepository.findById(dto.getJacketsId()).orElseThrow());
        npc.setTrousers(trousersRepository.findById(dto.getTrousersId()).orElseThrow());
        npc.setHairstyle(hairstyleRepository.findById(dto.getHairstyleId()).orElseThrow());
        npc.setHaircolor(haircolorRepository.findById(dto.getHaircolorId()).orElseThrow());
        npc.setBeardstyle(beardstyleRepository.findById(dto.getBeardstyleId()).orElseThrow());
        npc.setArmor_ID(armorRepository.findById(dto.getArmorId()).orElseThrow());
        npc.setNpcClass(npcClassRepository.findById(dto.getClassId()).orElse(null));
        npc.setSubclass(subclassRepository.findById(dto.getSubclassId()).orElse(null));
        npc.setBetonung(betonungRepository.findById(dto.getBetonungId()).orElse(null));
        npc.setFlaw(flawRepository.findById(dto.getFlawId()).orElse(null));
        npc.setJewellery(jewelleryRepository.findById(dto.getJewelleryId()).orElse(null));
        npc.setBackground(backgroundRepository.findById(dto.getBackgroundId()).orElse(null));
        npc.setTalkingstyle(talkingStyleRepository.findById(dto.getTalkingstyleId()).orElse(null));
        npc.setPicture(pictureRepository.findById(dto.getPictureId()).orElse(null));
        npc.setClan(clanRepository.findById(dto.getClanId()).orElse(null));
        npc.setShop_relations_ID(shopRelationsRepository.findById(dto.getShopRelationsId()).orElse(null));
        npc.setClan_position(dto.getClan_position());
        npc.setNpc_age(dto.getNpc_age());
        npc.setSymbol(dto.getSymbol());
        npc.setNotes(dto.getNotes());
    }

}
