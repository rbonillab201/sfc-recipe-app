package net.cuscatlan.sfcrecipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.cuscatlan.sfcrecipeapp.models.UnitOfMeasure;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 21, 2020
 *
 */

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);

}
