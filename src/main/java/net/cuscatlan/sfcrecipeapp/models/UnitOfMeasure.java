package net.cuscatlan.sfcrecipeapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */

@Data
@Entity
public class UnitOfMeasure extends BaseIds {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String uom;
	private String description;

}
