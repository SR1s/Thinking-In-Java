package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
}
