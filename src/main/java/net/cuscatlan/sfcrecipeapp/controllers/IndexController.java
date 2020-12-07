package net.cuscatlan.sfcrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.cuscatlan.sfcrecipeapp.services.RecipeService;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 13, 2020
 *
 */
@Controller
@RequestMapping({"","/"})
public class IndexController {
	
	RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({"","/","/index"})
	String myIndex(Model model) {
		model.addAttribute("title", "Recetas App!");
		model.addAttribute("recipes", recipeService.getRecipes());
		System.out.println("*******************");
		System.out.println(recipeService.getRecipes());
		return "index";
	}

}
