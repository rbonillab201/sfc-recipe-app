package net.cuscatlan.sfcrecipeapp.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.cuscatlan.sfcrecipeapp.models.UnitOfMeasure;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día 10 dic. 2020
 *
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomr;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCup() {
		Optional<UnitOfMeasure> uom = uomr.findByDescription("Cup");
		assertEquals("Cup", uom.get().getDescription());
	}
	
	@Test
	@DirtiesContext
	void testTableSpoon() {
		Optional<UnitOfMeasure> uom = uomr.findByDescription("Tablespoon");
		assertEquals("Tablespoon", uom.get().getDescription());
	}
	
	@Test
	void testPint() {
		Optional<UnitOfMeasure> uom = uomr.findByDescription("Pint");
		assertEquals("Pint", uom.get().getDescription());
	}

}
