package net.cuscatlan.sfcrecipeapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import net.cuscatlan.sfcrecipeapp.models.Recipe;
import net.cuscatlan.sfcrecipeapp.repositories.RecipeRepository;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 27, 2020
 *
 */

@Service
public class RecipeServiceImpl implements RecipeService {
	
	RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		System.out.println("recipes -> " + recipes);
		return recipes;
	}

}
