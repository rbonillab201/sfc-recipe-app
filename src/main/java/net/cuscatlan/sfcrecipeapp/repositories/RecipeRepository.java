package net.cuscatlan.sfcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import net.cuscatlan.sfcrecipeapp.models.Recipe;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 21, 2020
 *
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
