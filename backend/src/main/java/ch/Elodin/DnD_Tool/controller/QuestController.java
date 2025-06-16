package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.repository.QuestRepository;
import ch.Elodin.DnD_Tool.model.Quest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Quest")
public class QuestController extends GenericController<Quest, Integer> {
    public QuestController(QuestRepository repository) {
        super(repository);
    }
}

