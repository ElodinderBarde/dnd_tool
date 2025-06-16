package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.repository.ClanRepository;
import ch.Elodin.DnD_Tool.model.Clan;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Clan")
public class ClanController extends GenericController<Clan, Integer> {
    public ClanController(ClanRepository repository) {
        super(repository);
    }
}

