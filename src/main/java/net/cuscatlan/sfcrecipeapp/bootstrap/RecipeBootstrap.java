package net.cuscatlan.sfcrecipeapp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.cuscatlan.sfcrecipeapp.models.Category;
import net.cuscatlan.sfcrecipeapp.models.Difficulty;
import net.cuscatlan.sfcrecipeapp.models.Ingredient;
import net.cuscatlan.sfcrecipeapp.models.Note;
import net.cuscatlan.sfcrecipeapp.models.Recipe;
import net.cuscatlan.sfcrecipeapp.models.UnitOfMeasure;
import net.cuscatlan.sfcrecipeapp.repositories.CategoryRepository;
import net.cuscatlan.sfcrecipeapp.repositories.RecipeRepository;
import net.cuscatlan.sfcrecipeapp.repositories.UnitOfMeasureRepository;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 26, 2020
 *
 */
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	


	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Loading Bootstrap Data");
		recipeRepository.saveAll(getRecipes());
        log.info("Loaded Bootstrap Data");
		
	}	
	
	
	List<Recipe> getRecipes(){
		log.debug("Inicia la carga");
		List<Recipe> recipes = new ArrayList<>(1);
		
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
		if(eachUomOptional.isEmpty()) {
			throw new RuntimeException("Each is not present into UOM");
		}
		
		Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		if(teaspoonUomOptional.isEmpty()) {
			throw new RuntimeException("Teaspoon is not present into UOM");
		}
		
		Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		if(tablespoonUomOptional.isEmpty()) {
			throw new RuntimeException("Tablespoon is not present into UOM");
		}
		
		Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
		if (cupUomOptional.isEmpty()) {
			throw new RuntimeException("Cup is not present into UOM");
		}
		
		Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
		if(pinchUomOptional.isEmpty()) {
			throw new RuntimeException("Pinch is not present into UOM");
		}
		
		Optional<UnitOfMeasure> wholeUomOptional = unitOfMeasureRepository.findByDescription("Whole");
		if(wholeUomOptional.isEmpty()) {
			throw new RuntimeException("Whole is not present into UOM");
		}
		
		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
		if(dashUomOptional.isEmpty()) {
			throw new RuntimeException("Dash is not present into UOM");
		}
		
		Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
		if(pintUomOptional.isEmpty()) {
			throw new RuntimeException("Pint is not present into UOM");
		}
		
		// Obtiene las unidades de medida cargadas
		UnitOfMeasure eachUom = eachUomOptional.get();
		UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
		UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
		UnitOfMeasure cupUom = cupUomOptional.get();
		UnitOfMeasure pinchUom = pinchUomOptional.get();
		UnitOfMeasure wholeUom = wholeUomOptional.get();
		UnitOfMeasure dashUom = dashUomOptional.get(); 
		UnitOfMeasure pintUom = pintUomOptional.get();
	
		Optional<Category> categoryAmericanOptional = categoryRepository.findByDescription("American");
		if(categoryAmericanOptional.isEmpty()) {
			throw new RuntimeException("Category American does not exist");
		}
		Optional<Category> categoryMexicanOptional = categoryRepository.findByDescription("Mexican");
		if(categoryMexicanOptional.isEmpty()) {
			throw new RuntimeException("Category Mexican does not exist");
		}
		Optional<Category> categoryItalianOptional = categoryRepository.findByDescription("Italian");
		if(categoryItalianOptional.isEmpty()) {
			throw new RuntimeException("Category Italian does not exist");
		}
		Optional<Category> categoryJapanOptional = categoryRepository.findByDescription("Japanese");
		if(categoryJapanOptional.isEmpty()) {
			throw new RuntimeException("Category Japanese does not exist");
		}		
		
		Category categoryAmerican = categoryAmericanOptional.get();
		Category categoryMexican = categoryMexicanOptional.get();
		Category categoryItalian = categoryItalianOptional.get();
		Category categoryJapan = categoryJapanOptional.get();
		
		
		// Instaqncia la receta de guacamole	
		Recipe recipeGuaca = new Recipe();
		
		recipeGuaca.setDescription("Perfect Guacamole");
		recipeGuaca.getCategories().add(categoryMexican);
		recipeGuaca.setCookTime(1);
		recipeGuaca.setPrepTime(30);
		recipeGuaca.setDifficulty(Difficulty.EASY);
		recipeGuaca.setServings(4);
		recipeGuaca.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
		recipeGuaca.setSource("Simply Recipes");
		recipeGuaca.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

		Note notes = new Note();
		notes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		// No es necesario por el hack a setNote  de la clase Recipe --  notes.setRecipes(recipeGuaca);
		recipeGuaca.setNotes(notes);
		
		recipeGuaca.addIngredient(new Ingredient("ripes avocados", new BigDecimal(6), eachUom));
		recipeGuaca.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), cupUom));
		recipeGuaca.addIngredient(new Ingredient("Salt", new BigDecimal(0.5), tablespoonUom));
		recipeGuaca.addIngredient(new Ingredient("Lime", new BigDecimal(4), eachUom));
		recipeGuaca.addIngredient(new Ingredient("Serrano chiles, stems and seeds removed, minced", new BigDecimal(4), eachUom));
		recipeGuaca.addIngredient(new Ingredient("Onion fine chopped", new BigDecimal(1), eachUom));
		recipeGuaca.addIngredient(new Ingredient("Black Pepper", new BigDecimal(1), dashUom));
		
		recipes.add(recipeGuaca);
		log.info("finaliza la carga");
		
		return recipes;
		
	}

	
	
	
	
	
	
	
	
	
	
	

}
