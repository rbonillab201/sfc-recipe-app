package net.cuscatlan.sfcrecipeapp.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Note extends BaseIds{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Lob
	private String recipeNotes;
	@ToString.Exclude
	@OneToOne
	private Recipe recipes;
	

}
