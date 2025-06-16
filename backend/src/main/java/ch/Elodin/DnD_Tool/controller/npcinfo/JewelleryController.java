package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.JewelleryRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Jewellery;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Jewellery")
public class JewelleryController extends GenericController<Jewellery, Integer> {
    public JewelleryController(JewelleryRepository repository) {
        super(repository);
    }
}

