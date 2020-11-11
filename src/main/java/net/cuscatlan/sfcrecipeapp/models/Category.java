package net.cuscatlan.sfcrecipeapp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 21, 2020
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category extends BaseIds{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	@ToString.Exclude
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes; 
}
