package dev.rahi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Sample JPA bean with lombok annotation.
 * TODO Generate UUID
 * 
 * @author Imtiaz Rahi
 * @since 2020-12-01
 */
@Entity
@Table(name = "tutorials")
@Getter @Setter @NoArgsConstructor @ToString
public class Tutorial {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private boolean published;

	@Column(nullable = false)
	@Setter(value = AccessLevel.PRIVATE)
	private LocalDateTime entryDate;

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	@PrePersist
	private void beforeSave() {
		this.entryDate = LocalDateTime.now();
	}
}
