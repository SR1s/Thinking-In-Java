package me.sr1.chapter14.examples;

import java.util.Random;

import static me.sr1.util.Print.*;

/**
 * 
 * 使用Class.forName引用类会触发对类的初始化，
 * 而使用 类名.class 方式应用类不会触发对类的初始化。
 * 类的初始化被延迟到对静态方法 或者 非“常数”静态域的首次引用时才执行
 * 
 * @author sr1
 *
 */

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = 
	  ClassInitialization.rand.nextInt(1000);
	static {
		print("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		print("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		print("Initializing Initable3");
	}
}

public class ClassInitialization {
	
	public static Random rand = new Random(47);
	
	public static void main(String args[]) 
	  throws Exception {
		print("使用 Initable.class 方式引用类");
		Class initable = Initable.class;
		print("After creating Initable ref");
		print("访问静态常数域-->");
		print(Initable.staticFinal);
		print("访问静态非常数域-->");
		print(Initable.staticFinal2);
		
		print("直接访问Initable2的静态非常数域-->");
		print(Initable2.staticNonFinal);
		
		print("使用 Class.forName 方式引用Initable3");
		Class initable3 = Class.forName("me.sr1.chapter14.examples.Initable3");
		print("After creating Initable3 ref");
		print(Initable3.staticNonFinal);
	}
}
