package me.sr1.chapter14.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.sr1.util.Print.*;

public class SnowRemovalRobot implements Robot {

	private String name;
	
	public SnowRemovalRobot(String name) {
		this.name = name;
	}
	
	public String name() {
		return name;
	}
	
	public String model() {
		return "SnowBot Series 11";
	}
	
	public List<Operation> operations() {
		return Arrays.asList(
		  new Operation() {
			@Override
			public String description() {
				return name + " can shovel snow";
			}
			@Override
			public void command() {
				print(name + " shoveling snow");
			}
		  },
		  new Operation() {
			@Override
			public String description() {
				return name + " can chip ice";
			}
			@Override
			public void command() {
				print(name + " chipping ice");
			}
		  },
		  new Operation() {
		    @Override
		    public String description() {
		    	return name + " can clear the roof";
		    }
		    @Override
		    public void command() {
		    	print(name + " clearing roog");
		    }
		  }
		);
	}
	
	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}
}
