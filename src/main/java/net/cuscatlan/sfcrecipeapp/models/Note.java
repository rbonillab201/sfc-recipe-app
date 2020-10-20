package net.cuscatlan.sfcrecipeapp.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Note extends BaseIds {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Lob
	private String recipeNotes;
	@OneToOne
	private Recipe recipes;
	

}
