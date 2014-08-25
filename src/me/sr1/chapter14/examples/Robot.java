package me.sr1.chapter14.examples;

import java.util.List;

import me.sr1.util.Null;
import static me.sr1.util.Print.*;

public interface Robot {
	String name();
	String model();
	List<Operation> operations();
	
	class Test {
		public static void test(Robot r) {
			if (r instanceof Null) {
				print("[Null Robot]");
			}
			print("Robot name: " + r.name());
			print("Robot model: " + r.model());
			for(Operation operation : r.operations()) {
				print(operation.description());
				operation.command();
			}
		}
	}
}
