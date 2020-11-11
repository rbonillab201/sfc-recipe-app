package net.cuscatlan.sfcrecipeapp.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */

@Data
@Entity
public class Ingredient extends BaseIds {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private BigDecimal amoung;
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	@ManyToOne
	private Recipe recipe;

	
	public Ingredient(String description, BigDecimal amoung, UnitOfMeasure uom /*, Recipe recipe*/) {
		this.description = description;
		this.amoung = amoung;
		this.uom = uom;
	//	this.recipe = recipe;
	}	
	
}
