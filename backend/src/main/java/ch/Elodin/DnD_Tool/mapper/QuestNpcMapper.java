// QuestNpcMapper.java
package ch.Elodin.DnD_Tool.mapper;

import ch.Elodin.DnD_Tool.dto.QuestNpcDto;
import ch.Elodin.DnD_Tool.model.QuestNpc;
import ch.Elodin.DnD_Tool.dto.NpcReadDTO;

public class QuestNpcMapper {
    public static QuestNpcDto toDto(QuestNpc questNpc) {
        QuestNpcDto dto = new QuestNpcDto();
        dto.setQuestNpcId(questNpc.getQuestNpcId());
        dto.setNpcId(questNpc.getNpc().getNpc_ID());

        String firstname = questNpc.getNpc().getFirstname() != null
                ? questNpc.getNpc().getFirstname().getFirstname()
                : "";
        String lastname = questNpc.getNpc().getLastname() != null
                ? questNpc.getNpc().getLastname().getLastname()
                : "";
        dto.setNpcName(STR."\{firstname} \{lastname}".trim());



        dto.setQuestId(questNpc.getQuest().getQuestID());
        dto.setQuestName(questNpc.getQuest().getMonsterName());
        dto.setFunction(questNpc.getFunction());
        return dto;
    }
}
