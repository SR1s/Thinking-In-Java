package me.sr1.chapter14.examples;

public class Position {
	
	private String title;
	private PersonWithNull person;
	public Position(String title, PersonWithNull employee) {
		this.title = title;
		this.person = employee;
		if (person == null) {
			person = PersonWithNull.NULL;
		}
	}
	
	public Position(String title) {
		this.title = title;
		this.person = PersonWithNull.NULL;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public PersonWithNull getPerson() {
		return person;
	}
	
	public void setPerson(PersonWithNull person) {
		this.person = person;
		if (this.person == null) {
			this.person = PersonWithNull.NULL;
		}
	}
	
	public String toString() {
		return "Position: " + title + " " + person;
	}

}
