package net.cuscatlan.sfcrecipeapp.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 20, 2020
 *
 */
@Setter
@Getter
@MappedSuperclass
public class BaseIds implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
