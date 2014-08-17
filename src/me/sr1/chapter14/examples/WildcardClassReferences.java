package me.sr1.chapter14.examples;

/**
 * Class<?> 优于普通的 Class，
 * 它表示尼并非碰巧或者由于疏忽而使用了一个非具体的类的引用
 * @author sr1
 *
 */
public class WildcardClassReferences {
	
	public static void main(String args[]) {
		Class<?> intClass = int.class;
		intClass = double.class;
	}
}
