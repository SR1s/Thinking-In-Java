package me.sr1.chapter14.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Individual {
	String name;
	
	public Individual() {};
	
	public Individual(String name) {
		this.name = name;
	}
	
	public String toString() {
		if (name==null) {
			return getClass().getSimpleName();
		}
		return name;
	}
}

class Pet extends Individual {
	public Pet(String name) {
		super(name);
	}
	public Pet() {
		super();
	}
}

class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}
	public Dog() {
		super();
	}
}

class Mutt extends Dog {
	public Mutt(String name) {
		super(name);
	}
	public Mutt() {
		super();
	}
}

class Pug extends Dog {
	public Pug(String name) {
		super(name);
	}
	public Pug() {
		super();
	}
}

class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}
	public Cat() {
		super();
	}
}

class EgyptianMau extends Cat {
	public EgyptianMau(String name) {
		super(name);
	}
	public EgyptianMau() {
		super();
	}
}

class Manx extends Cat {
	public Manx(String name) {
		super(name);
	}
	public Manx() {
		super();
	}
}

class Cymric extends Manx {
	public Cymric(String name) {
		super(name);
	}
	public Cymric() {
		super();
	}
}

class Rodent extends Pet {
	public Rodent(String name) {
		super(name);
	}
	public Rodent() {
		super();
	}
}

class Rat extends Rodent {
	public Rat(String name) {
		super(name);
	}
	public Rat() {
		super();
	}
}

class Mouse extends Rodent {
	public Mouse(String name) {
		super(name);
	}
	public Mouse() {
		super();
	}
}

class Hamster extends Rodent {
	public Hamster(String name) {
		super(name);
	}
	public Hamster() {
		super();
	}
}

class Person extends Individual {
	public Person(String name) {
		super(name);
	}
}

public abstract class PetCreator {
	private Random rand = new Random(47);
	public abstract List<Class<? extends Pet>> types();
	public Pet randomPet() {
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch(InstantiationException e) {
			throw new RuntimeException(e);
		} catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for(int i=0; i<size; i++) {
			result[i] = randomPet();
		}
		return result;
	}
	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
