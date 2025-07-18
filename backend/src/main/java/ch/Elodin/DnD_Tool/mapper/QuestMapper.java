package ch.Elodin.DnD_Tool.mapper;

import ch.Elodin.DnD_Tool.dto.QuestCreateDTO;
import ch.Elodin.DnD_Tool.dto.QuestDto;
import ch.Elodin.DnD_Tool.model.Quest;
import ch.Elodin.DnD_Tool.model.enums.EnumQuest;
import ch.Elodin.DnD_Tool.model.world.Location;

public class QuestMapper {

    public static QuestDto toDto(Quest quest) {
        QuestDto dto = new QuestDto();
        dto.setQuestID(quest.getQuestID());
        dto.setMonsterName(quest.getMonsterName());
        dto.setDescription(quest.getDescription());
        dto.setStatus(quest.getStatus());
        dto.setGroup(quest.getGroup());
        dto.setPrice_gold(quest.getPrice_gold());
        dto.setPrice_item(quest.getPrice_item());
        dto.setPreviousQuestId(quest.getPreviousQuest() != null ? quest.getPreviousQuest().getQuestID() : null);

        Location loc = quest.getQuestlocation();
        if (loc != null) {
            String locName = null;
            if (loc.getCityID() != null) {
                locName = "Stadt #" + loc.getCityID();
            } else if (loc.getVillageID() != null) {
                locName = "Dorf #" + loc.getVillageID();
            }
            dto.setLocationName(locName);
        } else {
            dto.setLocationName(null);
        }

        dto.setActive(quest.isIs_active());
        dto.setNotes(quest.getNotes());
        return dto;
    }

    public static Quest toEntity(QuestCreateDTO dto) {
        Quest quest = new Quest();
        quest.setMonsterName(dto.getQuestname());
        quest.setDescription(dto.getDescription());
        quest.setGroup(dto.getGroup());
        quest.setPrice_gold(dto.getPrice_gold());
        quest.setPrice_item(dto.getPrice_item());
        quest.setIs_active(dto.is_active); // Direktzugriff auf public field
        quest.setStatus(EnumQuest.valueOf(dto.getStatus().toLowerCase()));
        quest.setNotes(dto.getNotes());
        return quest;
    }
}
