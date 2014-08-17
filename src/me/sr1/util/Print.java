package me.sr1.util;

public class Print {
	public static void print(Object... objs) {
		printnb(objs);
		System.out.println();
	}
	
	public static void printnb(Object... objs) {
		for(Object obj : objs) {
			System.out.print(obj);
		}
	}
}
