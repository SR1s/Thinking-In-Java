package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

/**
 * 当你想将额外的操作从实际的对象分离到不同的地方，
 * 又希望能很容易作出修改时，就可以使用代理模式。
 * 
 * @author sr1
 *
 */
interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class ReadObject implements Interface {
	
	public void doSomething() {
		print("do something");
	}
	
	public void somethingElse(String arg) {
		print("something else: " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	public void doSomething() {
		print("Simple do something");
		proxied.doSomething();
	}
	
	public void somethingElse(String arg) {
		print("SimpleProxy something else: " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleRroxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		consumer(new ReadObject());
		consumer(new SimpleProxy(new ReadObject()));
	}
}
