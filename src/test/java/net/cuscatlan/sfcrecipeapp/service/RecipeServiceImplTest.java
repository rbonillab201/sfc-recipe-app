package net.cuscatlan.sfcrecipeapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import net.cuscatlan.sfcrecipeapp.models.Recipe;
import net.cuscatlan.sfcrecipeapp.repositories.RecipeRepository;
import net.cuscatlan.sfcrecipeapp.services.RecipeServiceImpl;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día 3 dic. 2020
 *
 */

class RecipeServiceImplTest {

	@Mock
	RecipeRepository recipeRepository;

	RecipeServiceImpl recipeService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);

		Set<Recipe> recipes = new HashSet<>();
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();

		recipe1.setDirections("Direction 1");
		recipe1.setId(2L);
		recipe1.setUrl("www");

		recipe2.setDescription("Direction 2");
		recipe2.setId(4L);
		recipe2.setSource("Fuente 2");

		recipes.add(recipe1);
		recipes.add(recipe2);

		when(recipeRepository.findAll()).thenReturn(recipes);
		System.out.println("Recetas " + recipes.size());

	}

	@Test
	void getRecipes() {
		Set<Recipe> recetas = recipeService.getRecipes();
		System.out.println("Recetas en el Test: " + recetas.size());
		assertEquals(2, recetas.size());
		verify(recipeRepository, Mockito.times(1)).findAll();
	}

}
