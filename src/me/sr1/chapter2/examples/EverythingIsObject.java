package me.sr1.chapter2.examples;

/***
 * Everything is Object.
 * @author sr1
 *
 */
public class EverythingIsObject {
	
	// using reference to hold a String object
	// now s haven't being initialized, so it's value is null
	String s; 
	
	// initial ss with a String value
	String ss = "Hello Kitty";
	
	// using another way to initial a String reference
	String sss = new String("Hello moto");
	
	// other basis type in Java
	char c = 'x';
	Character ch = new Character(c);
	// Character ch = new Character('x');
	// char c = ch;
	
	public static void main(String[] args) {
		// using {} to split the scope of value
		{
			int x = 12;
			// only x availabe
			{
				int q = 96;
				// both x and q availabe
			}
			// only x availabe
			// q is *out of scope*
			
			// illegal
			//! int q = 12;
			
			{
				String str = new String("a string");
			} // end of scope
			// now you can't using the reference str of String
			// but the object of the String maybe still alive on memory
			
			// after define a class, now you can using "new" to create a object of the class
			ATypeName at = new ATypeName();
		}
	}

}
// define a new type
class ATypeName {
	/* class body goes here */
}
