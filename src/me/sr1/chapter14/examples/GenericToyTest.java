package me.sr1.chapter14.examples;

/**
 * Class<? super 类名> 表示：
 * 某个类，它是 类名指向的类的父类
 * 由于一个类能具有多个父类，即
 * A继承B，B继承C，则B、C都是A的父类
 * 由于这种不确定性，所以调用.newInstance方法得到了对象的引用类型只能为Object
 * @author sr1
 *
 */
public class GenericToyTest {
	
	public static void main(String args[]) 
	  throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		// 这部分无法通过编译
		// Class<Toy> up2 = ftClass.getSuperclass();
		// 只能获得Object的对象引用
		Object obj = up.newInstance();
	}
}
