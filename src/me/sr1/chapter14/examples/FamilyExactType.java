package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

class Base {}

class Derived extends Base {}

public class FamilyExactType {
	
	static void test(Object x) {
		print("Testing x of Type " + x.getClass());
		print("x instanceof Base " + (x instanceof Base));
		print("x instanceof Derived " + (x instanceof Derived));
		print("Base.isInstance(x) " + Base.class.isInstance(x));
		print("Derived.isInstance(x) "+ Derived.class.isInstance(x));
		print("x.getClass() == Base.class " + (x.getClass() == Base.class));
		print("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		print("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
		print("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));
	}
	public static void main(String[] args) {
		test(new Base());
		print("-------------------------");
		test(new Derived());
	}
}
