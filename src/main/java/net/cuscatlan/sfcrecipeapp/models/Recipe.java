package net.cuscatlan.sfcrecipeapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */

@Setter
@Getter
@Entity
public class Recipe extends BaseIds {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	@Lob
	private String directions;
	@Enumerated(EnumType.STRING) 
	private Difficulty difficulty;
	@Lob
	private Byte[] image;
	@OneToOne(cascade = CascadeType.ALL)
	private Note notes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	@ManyToMany
	@JoinTable(name = "recipe_categories", 
			joinColumns = @JoinColumn(name = "recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	public Recipe addIngredient(Ingredient ingredient){
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		return this;
	}
	
	public void setNotes(Note notes) {
		if(notes != null) {
			this.notes = notes;
			notes.setRecipes(this);
		}
	}
	
}
