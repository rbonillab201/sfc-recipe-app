package net.cuscatlan.sfcrecipeapp.models;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UnitOfMessure extends BaseIds{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uom;
	private String description;

}
