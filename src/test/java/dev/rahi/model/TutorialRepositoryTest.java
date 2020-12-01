package dev.rahi.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.rahi.model.repo.TutorialRepository;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-01
 * @see Tutorial
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
@Rollback(false)
class TutorialRepositoryTest {

	@Autowired
	TutorialRepository repository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(1)
	public void should_find_no_tutorials_if_repository_is_empty() {
		Iterable<Tutorial> tutorials = repository.findAll();

		assertThat(tutorials).isEmpty();
	}

	@Test
	@Disabled
	void testFindByPublished() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindByTitleContaining() {
		fail("Not yet implemented");
	}

	@Test
	@Order(3)
	void testFindAll() {
		List<Tutorial> list = repository.findAll();
		assertTrue(list.size() > 0);
		for (Tutorial it : list)
			System.out.println(it);
	}

	@Test
	@Order(2)
	void testSave() {
		Tutorial ob = repository.save(new Tutorial("JPA Tut1", "Tutorial for JPA", false));
		assertThat(ob.getId()).isNotNull();
		System.out.println(repository.findById(ob.getId()));
	}

	@Test
	@Disabled
	void testFindByName() {
	}

}
