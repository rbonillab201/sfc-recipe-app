package net.cuscatlan.sfcrecipeapp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 21, 2020
 *
 */
 @Data
@Entity
public class Category extends BaseIds{

	 private String description;
	 @ManyToMany(mappedBy = "categories")
	 private Set<Recipe> recipes; 
}
