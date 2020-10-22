package net.cuscatlan.sfcrecipeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */


@Data
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
	private String directions;
	@Enumerated(EnumType.STRING) 
	private Difficulty difficulty;
	@Lob
	private Byte[] image;
	@OneToOne(cascade = CascadeType.ALL)
	private Note notes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients;
	@ManyToMany
	@JoinTable(name = "recipe_categories", 
			joinColumns = @JoinColumn(name = "recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;
	
}
