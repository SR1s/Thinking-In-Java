package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

interface HasBatteries {}
interface WaterProof {}
interface Shoots {}

class Toy {
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy 
  implements HasBatteries, WaterProof, Shoots {
	public FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName());
		print("Is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name: " + cc.getCanonicalName());
		print("-------------------------------------------------");
	}
	
	public static void main(String args[]) {
		Class c = null;
		try {
			c = Class.forName("me.sr1.chapter14.examples.FancyToy");
		} catch(ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch(IllegalAccessException e) {
			print("Cannot access");
			System.exit(1);
		} catch (InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
	
}
