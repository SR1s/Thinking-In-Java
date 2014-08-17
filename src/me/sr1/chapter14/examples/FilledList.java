package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用类引用.newInstance()方法可以获得改类的一个对象
 * 但需要该类具有默认构造方法
 * 
 * @author sr1
 *
 */
class CountedInteger {
	private static long counter;
	private final long id = counter++;
	public String toString() {
		return Long.toHexString(id);
	}
}

public class FilledList<T> {
	
	private Class<T> type;
	public FilledList(Class<T> type) {
		this.type = type;
	}
	
	public List<T> create(int nElements) {
		List<T> result = new ArrayList<T>();
		try {
			for(int i=0; i<nElements; i++) {
				result.add(type.newInstance());
			} 
		} catch (Exception e) {
				throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void main(String args[]) {
		FilledList<CountedInteger> fl = 
		  new FilledList<CountedInteger>(CountedInteger.class);
		print(fl.create(5));
	}

}
