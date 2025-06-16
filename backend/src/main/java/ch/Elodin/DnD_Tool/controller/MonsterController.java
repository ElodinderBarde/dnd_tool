package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.repository.MonsterRepository;
import ch.Elodin.DnD_Tool.model.Monster;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Monster")
public class MonsterController extends GenericController<Monster, Integer> {
    public MonsterController(MonsterRepository repository) {
        super(repository);
    }
}

