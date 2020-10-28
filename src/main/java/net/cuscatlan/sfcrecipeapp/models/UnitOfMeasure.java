package net.cuscatlan.sfcrecipeapp.models;


import javax.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */

@Getter
@Setter
@Entity
public class UnitOfMeasure extends BaseIds {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String description;

}
