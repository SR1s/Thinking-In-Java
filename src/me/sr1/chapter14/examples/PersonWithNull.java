package me.sr1.chapter14.examples;

import me.sr1.util.Null;

public class PersonWithNull {
	public final String first;
	public final String last;
	public final String address;
	
	public PersonWithNull(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}

	public String toString() {
		return "Person: " + first + " " + last + " " + address;
	}
	
	public static class NullPerson
	  extends PersonWithNull
	    implements Null {
		private NullPerson() {
		super("None", "None", "None");
		}
	}
	
	public static final PersonWithNull NULL = new NullPerson();

}
