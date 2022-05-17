package com.example.collection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.collection.domain.CategoryRepository;
import com.example.collection.domain.Collectible;
import com.example.collection.domain.CollectibleRepository;

@Controller
public class CollectibleController {
	@Autowired
	private CollectibleRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value = "/collectiblelist")
	public String itemList(Model model) {
		model.addAttribute("collectibles", repository.findAll());
		return "collectiblelist"; // return collectiblelist.html
	}
	// Palauttaa selaimeen tyhjän kirjalomakkeen
	@RequestMapping(value = "/addcollectible", method = RequestMethod.GET)
	public String addcollectible(Model model) {
		model.addAttribute("collectible", new Collectible());
		model.addAttribute("categories", crepository.findAll());
		return "addcollectible";
	}
	
	// Tallentaa lomakkeelta lähetetyt kirjatiedot tietokantaan.
	@RequestMapping(value = "/savecollectible", method = RequestMethod.POST)
	public String savecollectible(Collectible collectible) {
		repository.save(collectible);
		return "redirect:/collectiblelist";
	}
    // Delete item
	 @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    // todo: suojaa delete-toiminto metoditasolla @PreAuthorize-annotaatiolla vain ADMIN-roolin omaaville käyttäjille
    public String deleteCollectible(@PathVariable("id") Long collectibleId, Model model) {
    	repository.deleteById(collectibleId);
        return "redirect:../collectiblelist";
    }     

}