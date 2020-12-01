package dev.rahi.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rahi.model.Tutorial;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-01
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);
}
