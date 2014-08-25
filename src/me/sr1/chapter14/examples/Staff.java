package me.sr1.chapter14.examples;

import java.util.ArrayList;

import static me.sr1.util.Print.*;

public class Staff extends ArrayList<Position> {
	private static final long serialVersionUID = -6291017403031281063L;

	public void add(String title, PersonWithNull person) {
		add(new Position(title, person));
	}
	
	public void add(String... titles) {
		for(String title : titles) {
			add(new Position(title));
		}
	}
	
	public Staff(String... titles) {
		add(titles);
	}
	
	public boolean positionAvailable(String title) {
		for(Position position : this) {
			if (position.getTitle().equals(title) &&
				 position.getPerson() == PersonWithNull.NULL) {
				return true;
			}
		}
		return false;
	}
	
	public void fillPosition(String title, PersonWithNull hire) {
		for(Position position : this) {
			if (position.getTitle().equals(title) &&
				 position.getPerson() == PersonWithNull.NULL) {
				position.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException("Position " + title + " not available");
	}
	
	public static void main(String[] args) {
		Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager", 
									"Project Lead", "Software Engineer", "Sofeware Engineer",
									"Software Engineer", "Software Engineer", "Test Engineer", 
									"Technical Writer");
		staff.fillPosition("President", new PersonWithNull("Me", "Last", "The top, Lonely At"));
		staff.fillPosition("Project Lead", new PersonWithNull("Janet", "Planner", "The Burbs"));
		if(staff.positionAvailable("Software Engineer")) {
			staff.fillPosition("Software Engineer", new PersonWithNull("Bob", "Coder", "Bright Light City"));
		}
		print(staff);
	}
}
