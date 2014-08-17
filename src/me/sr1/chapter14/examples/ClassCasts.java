package me.sr1.chapter14.examples;

/**
 * 
 * 新的转型语法，即调用类引用.cast方法
 * 作用同显式转换类型： (类名) 变量 一样
 * 
 * @author sr1
 *
 */
class Building {}
class House extends Building {}

public class ClassCasts {
	
	public static void main(String args[]) {
		Building b = new House();
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		h = (House) b;
	}

}
