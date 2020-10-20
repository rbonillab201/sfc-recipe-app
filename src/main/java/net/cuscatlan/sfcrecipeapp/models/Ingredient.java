package net.cuscatlan.sfcrecipeapp.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
public class Ingredient extends BaseIds {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private BigDecimal amoung;
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMessure uom;
	@ManyToOne
	private Recipe recipe;

}
