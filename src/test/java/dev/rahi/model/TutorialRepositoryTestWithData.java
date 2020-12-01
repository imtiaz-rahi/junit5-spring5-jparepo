package dev.rahi.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.rahi.model.repo.TutorialRepository;

/**
 * Bit of manual stale data setup.
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-01
 * @see Tutorial
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
class TutorialRepositoryTestWithData {

	@Autowired
	TutorialRepository repo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		repo.saveAll(newTutorials());
	}

	@Test
	@Order(3)
	void testFindAll() {
		List<Tutorial> list = repo.findAll();
		assertTrue(list.size() > 0);
		for (Tutorial it : list)
			System.out.println(it);
	}

	List<Tutorial> newTutorials() {
		ArrayList<Tutorial> list = new ArrayList<Tutorial>();
		list.add(new Tutorial("Tut1", "Desc1", false));
		list.add(new Tutorial("Tut2", "Desc2", false));
		list.add(new Tutorial("Tut3", "Desc3", false));
		list.add(new Tutorial("Tut4", "Desc4", false));
		return list;
	}
}
