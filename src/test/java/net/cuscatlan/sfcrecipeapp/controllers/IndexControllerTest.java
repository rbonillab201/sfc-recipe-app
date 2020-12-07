package net.cuscatlan.sfcrecipeapp.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import net.cuscatlan.sfcrecipeapp.models.Recipe;
import net.cuscatlan.sfcrecipeapp.services.RecipeService;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día 3 dic. 2020
 *
 */

class IndexControllerTest {

	@Mock
	RecipeService recipeService;

	IndexController indexController;

	@Mock
	Model model;

	Set<Recipe> recipes = new HashSet<>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);

		Recipe receta1 = new Recipe();
		Recipe receta2 = new Recipe();

		receta1.setCookTime(30);
		receta1.setId(2L);
		receta1.setDescription("Desc 1");

		recipes.add(receta1);

		receta2.setCookTime(23);
		receta2.setId(4L);
		receta2.setDescription("Desc 2");

		recipes.add(receta2);

	}

	/**
	 * Test method for
	 * {@link net.cuscatlan.sfcrecipeapp.controllers.IndexController#myIndex(org.springframework.ui.Model)}.
	 */
	@Test
	void testMyIndex() {
		
		@SuppressWarnings("unchecked")
		ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);

		when(recipeService.getRecipes()).thenReturn(recipes);
		assertEquals(2, recipes.size());
		

		String viewname = indexController.myIndex(model);
		assertEquals("index", viewname);
		
		
		
		verify(recipeService, Mockito.times(2)).getRecipes();
		verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), captor.capture());
		
		Set<Recipe> itemsCapturados = new HashSet<>();		

		itemsCapturados = captor.getValue();
		
		assertEquals(2, itemsCapturados.size());
		
	}

}
