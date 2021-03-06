package com.nibi.springdata.jpqlandnativesql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {

	@Id												//MAPEA EL ID CON id
//	@GeneratedValue(strategy=GenerationType.AUTO)	//GENERA UN  AUTOINCREMENTADOR
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // SI NO SE MANTIENE UNA SEQUENCIA EN LA DB 
	private Long id;
	@Column(name="fname")
	private String firstName;							//MAPEAMOS LOS VALORES CON EL NOMBRE DE LA COLUMNA EN LA DB
	@Column(name="lname")
	private String lastName;
	private int score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + "]";
	}
	
	
	
}
