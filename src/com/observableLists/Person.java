package com.observableLists;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person  implements Comparable<Person>{
	
	private StringProperty firstName = new SimpleStringProperty();
	private StringProperty lastName = new SimpleStringProperty();
	
	public Person() {
		this.setFirstName("Unknown");
		this.setLastName("Unknown");
		
	}
	
	public Person(String firstName,String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public final String getLastName() {
		return lastName.get();
	}

	public final String getFirstName() {
		return firstName.get();
	}
	
	public final void setLastName(String newLastName) {
		
		lastName.set(newLastName);
	}

	public final void setFirstName(String newFirstName) {
		firstName.set(newFirstName);
		
	}
	public StringProperty lastNameProperty() {
		return lastName;
	}
	public StringProperty firstNameProperty() {
		return firstName;
	}
	

	@Override
	public int compareTo(Person o) {
		//Assume firstName and lastName are not always null
		int diff = this.getFirstName().compareTo(o.getFirstName());
		if (diff == 0) {
		     diff =this.getLastName().compareTo(o.getLastName());	
		}
		
		
		return diff;
	}
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
	

}
