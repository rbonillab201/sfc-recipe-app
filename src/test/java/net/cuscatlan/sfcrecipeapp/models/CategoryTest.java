package net.cuscatlan.sfcrecipeapp.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día 7 dic. 2020
 *
 */

class CategoryTest {

	/**
	 * @throws java.lang.Exception
	 */

	Category category;

	@BeforeEach
	void setUp() throws Exception {

		category = new Category();
		category.setId(4L);
		category.setDescription("Descripcion");
		Recipe recipe01 = new Recipe();
		recipe01.setId(5L);
		recipe01.setDirections("Direccion");
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(recipe01);
		category.setRecipes(recipes);
	}

	@Test
	void getId() {
		assertEquals(4l, category.getId());
	}
	
	@Test
	void getDescription() {
		assertEquals("Descripcion", category.getDescription());
	}
	
	@Test
	void getRecipes() {
		assertNotNull(category.getRecipes());
	}

}
