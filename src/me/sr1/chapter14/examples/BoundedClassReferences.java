package me.sr1.chapter14.examples;

/**
 * Class<? extends 类名>将Class的引用限定为：
 * 某种类型，他是 某个类名的类型 或者 继承了这个类的类型
 * 
 * @author sr1
 */
public class BoundedClassReferences {

	public static void main(String args[]) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
	}
}
