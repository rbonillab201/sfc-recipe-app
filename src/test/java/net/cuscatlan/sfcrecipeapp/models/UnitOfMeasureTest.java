package net.cuscatlan.sfcrecipeapp.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.cuscatlan.sfcrecipeapp.repositories.UnitOfMeasureRepository;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día 7 dic. 2020
 *
 */


@DataJpaTest
@ExtendWith(SpringExtension.class)
class UnitOfMeasureTest {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	Optional<UnitOfMeasure> unitOfMessureOptional;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		UnitOfMeasure uom = new UnitOfMeasure();	
	}

	@Test
	void getDescriptionCup() {
		unitOfMessureOptional = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", unitOfMessureOptional.get().getDescription());
	}
	
	@Test
	void getDescriptionTableSpoon() {
		unitOfMessureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		assertEquals("Tablespoon", unitOfMessureOptional.get().getDescription());
	}
	
	@Test
	void getId() {
		unitOfMessureOptional = unitOfMeasureRepository.findById(7L);
		assertEquals(7L, unitOfMessureOptional.get().getId());
	}

}
