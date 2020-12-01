package dev.rahi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({ @NamedQuery(name = "Person.find", query = "SELECT p from Person p where p.firstName like :name "
		+ "or p.lastName like :name") })
@Getter @Setter
public class Person {

	@Id
	private int id;

	private String title;

	private String firstName;

	private String lastName;

}