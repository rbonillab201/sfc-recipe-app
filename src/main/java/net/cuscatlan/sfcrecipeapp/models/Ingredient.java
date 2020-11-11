package net.cuscatlan.sfcrecipeapp.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"recipe"})
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
	@ToString.Exclude
	@ManyToOne
	private Recipe recipe;

	
	public Ingredient(String description, BigDecimal amoung, UnitOfMeasure uom ) {
		this.description = description;
		this.amoung = amoung;
		this.uom = uom;
	}	
	
}
