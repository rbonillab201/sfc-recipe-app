package net.cuscatlan.sfcrecipeapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.cuscatlan.sfcrecipeapp.models.Recipe;
import net.cuscatlan.sfcrecipeapp.repositories.RecipeRepository;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 27, 2020
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
	
	RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.info("En el servicio Recipe");
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		System.out.println("recipes -> " + recipes);
		return recipes;
	}

}
