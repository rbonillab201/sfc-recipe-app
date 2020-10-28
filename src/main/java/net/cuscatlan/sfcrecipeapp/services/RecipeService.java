package net.cuscatlan.sfcrecipeapp.services;

import java.util.Set;

import net.cuscatlan.sfcrecipeapp.models.Recipe;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 27, 2020
 *
 */

public interface RecipeService {
	
	Set<Recipe> getRecipes();

}
