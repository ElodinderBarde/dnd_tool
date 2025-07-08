package ch.Elodin.DnD_Tool.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.repository.npcinfo.ArmorRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.BackgroundRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.BeardstyleRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.BetonungRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.DislikesRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.FamilyRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.FirstnameRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.FlawRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.GenderRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.HaircolorRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.HairstyleRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.IdealsRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.JacketsRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.JewelleryRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.KlasseRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.KleidungQualiRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.LastnameRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.LevelRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.LikesRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.OtherDescriptionRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.PersonalityRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.PictureRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.RaceRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.SubclassRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.TalkingStyleRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.TrousersRepository;



@Service
public class NpcGeneratorService {
    
    // Hier injecten wir alle Repositories, z. B.:
    private final FirstnameRepository firstnameRepo;
    private final LastnameRepository lastnameRepo;
    private final RaceRepository raceRepo;
    private final ArmorRepository armorRepo;
    private final BackgroundRepository backgroundRepo;
    private final BeardstyleRepository beardstyleRepo;
    private final BetonungRepository betonungRepo;
    private final DislikesRepository dislikesRepo;
    private final FamilyRepository familyRepo;
    private final FlawRepository flawRepo;
    private final GenderRepository genderRepo;
    private final HaircolorRepository haircolorRepo;
    private final HairstyleRepository hairstyleRepo;
    private final IdealsRepository idealsRepo;
    private final JacketsRepository jacketsRepo;
    private final JewelleryRepository jewelleryRepo;
    private final KlasseRepository klasseRepo;
    private final KleidungQualiRepository kleidungQualiRepo;
    private final LevelRepository levelRepo;
    private final LikesRepository likesRepo;
    private final OtherDescriptionRepository otherDescriptionRepo;
    private final PersonalityRepository peronalityRepo;
    private final PictureRepository pictureRepo;
    private final SubclassRepository subclassRepo;
    private final TalkingStyleRepository talkingstyleRepo;
    private final TrousersRepository trousersRepo;



    public NpcGeneratorService(FirstnameRepository firstnameRepo, LastnameRepository lastnameRepo,
			RaceRepository raceRepo, ArmorRepository armorRepo, BackgroundRepository backgroundRepo,
			BeardstyleRepository beardstyleRepo, BetonungRepository betonungRepo, DislikesRepository dislikesRepo,
			FamilyRepository familyRepo, FlawRepository flawRepo, GenderRepository genderRepo,
			HaircolorRepository haircolorRepo, HairstyleRepository hairstyleRepo, IdealsRepository idealsRepo,
			JacketsRepository jacketsRepo, JewelleryRepository jewelleryRepo, KlasseRepository klasseRepo,
			KleidungQualiRepository kleidungQualiRepo, LevelRepository levelRepo, LikesRepository likesRepo,
			OtherDescriptionRepository otherDescriptionRepo, PersonalityRepository peronalityRepo,
			PictureRepository pictureRepo, SubclassRepository subclassRepo, TalkingStyleRepository talkingstyleRepo,
			TrousersRepository trousersRepo) {
		
		this.firstnameRepo = firstnameRepo;
		this.lastnameRepo = lastnameRepo;
		this.raceRepo = raceRepo;
		this.armorRepo = armorRepo;
		this.backgroundRepo = backgroundRepo;
		this.beardstyleRepo = beardstyleRepo;
		this.betonungRepo = betonungRepo;
		this.dislikesRepo = dislikesRepo;
		this.familyRepo = familyRepo;
		this.flawRepo = flawRepo;
		this.genderRepo = genderRepo;
		this.haircolorRepo = haircolorRepo;
		this.hairstyleRepo = hairstyleRepo;
		this.idealsRepo = idealsRepo;
		this.jacketsRepo = jacketsRepo;
		this.jewelleryRepo = jewelleryRepo;
		this.klasseRepo = klasseRepo;
		this.kleidungQualiRepo = kleidungQualiRepo;
		this.levelRepo = levelRepo;
		this.likesRepo = likesRepo;
		this.otherDescriptionRepo = otherDescriptionRepo;
		this.peronalityRepo = peronalityRepo;
		this.pictureRepo = pictureRepo;
		this.subclassRepo = subclassRepo;
		this.talkingstyleRepo = talkingstyleRepo;
		this.trousersRepo = trousersRepo;
	}

	public Npc generateRandomNpc() {
        Npc npc = new Npc();


        npc.setFirstname(getRandom(firstnameRepo.findAll()));
        npc.setLastname(getRandom(lastnameRepo.findAll()));
        npc.setRace(getRandom(raceRepo.findAll()));
        npc.setArmor_ID(getRandom(armorRepo.findAll()));
        npc.setBackground(getRandom(backgroundRepo.findAll()));
        npc.setBeardstyle(getRandom(beardstyleRepo.findAll()));
        npc.setBetonung(getRandom(betonungRepo.findAll()));
        npc.setDislikes(getRandom(dislikesRepo.findAll()));
//      npc.setNpc_family_ID(getRandom(familyRepo.findAll()));
        npc.setFlaw(getRandom(flawRepo.findAll()));
        npc.setGender(getRandom(genderRepo.findAll()));
        npc.setHaircolor(getRandom(haircolorRepo.findAll()));
        npc.setHairstyle(getRandom(hairstyleRepo.findAll()));
        npc.setIdeals(getRandom(idealsRepo.findAll()));
        npc.setJackets(getRandom(jacketsRepo.findAll()));
        npc.setJewellery(getRandom(jewelleryRepo.findAll()));
        npc.setNpcClass(getRandom(klasseRepo.findAll()));
        npc.setKleidungQuali(getRandom(kleidungQualiRepo.findAll()));
        npc.setLevel(getRandom(levelRepo.findAll()));
        npc.setLikes(getRandom(likesRepo.findAll()));
        npc.setOtherDescription(getRandom(otherDescriptionRepo.findAll()));
        npc.setPersonality(getRandom(peronalityRepo.findAll()));
//        npc.setPicture(getRandom(pictureRepo.findAll()));
//      npc.setSubclass(getRandom(subclassRepo.findAll()));
        npc.setTalkingstyle(getRandom(talkingstyleRepo.findAll()));
        npc.setTrousers(getRandom(trousersRepo.findAll()));
        
        
        
        return npc;
    }

    private <T> T getRandom(List<T> list) {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
