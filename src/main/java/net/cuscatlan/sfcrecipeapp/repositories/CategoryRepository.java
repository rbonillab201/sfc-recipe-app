package net.cuscatlan.sfcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import net.cuscatlan.sfcrecipeapp.models.Category;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 21, 2020
 *
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
