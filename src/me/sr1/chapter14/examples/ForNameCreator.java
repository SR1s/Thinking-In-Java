package me.sr1.chapter14.examples;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Pet>> types = 
	  new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"me.sr1.chapter14.examples.Mutt",
		"me.sr1.chapter14.examples.Pug",
		"me.sr1.chapter14.examples.EgyptianMau",
		"me.sr1.chapter14.examples.Manx",
		"me.sr1.chapter14.examples.Cymric",
		"me.sr1.chapter14.examples.Rat",
		"me.sr1.chapter14.examples.Mouse",
		"me.sr1.chapter14.examples.Hamster"
	};
	
	private static void loader() {
		try {
			for(String name : typeNames) {
				types.add((Class<? extends Pet>)Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		}
	}
	static {
		loader();
	}
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
}
