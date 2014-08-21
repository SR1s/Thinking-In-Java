package me.sr1.chapter14.examples;


import static me.sr1.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) 
	  throws Throwable {
		print("**** proxy: " + proxy.getClass());
		print("**** method: " + method);
		print("**** args: " + args);
		if (args != null) {
			for(Object arg : args) {
				print("****       " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}

public class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		ReadObject real = new ReadObject();
		consumer(real);
		
		Interface proxy = 
		  (Interface) Proxy.newProxyInstance(ReadObject.class.getClassLoader(), 
				  								  new Class[]{ Interface.class }, 
				  								  new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
