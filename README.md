#Don’t Repeat Yourself (DRY)
DRY says that “Every piece of system knowledge should have one authoritative, unambiguous representation. Every piece of knowledge in the development of something should have a single representation”. 

Its aren’t refer to just writing the same piece of logic twice in two different places, but it also refer to repetition in your processes – testing, debugging, database schemas, test plans, the build system, even documentation, etc. 

- For the code, duplication makes it more difficult for developers working with the system to fully understand the entire system.
- When you want to change in one location, you also need to be made in other places that duplicate the logic they are working on.
- In case you want to change the name you’ll need to find every hard-coded instance of the name.
- We can put these values into a separate location.

Example:
```
public class Action {
	public static void walk() {
		String name = "Tim";
		String format = "%s is %s";
		System.out.printf(format, name, "walking...\n");
	}

	public static void run() {
		String name = "Tim";
		String format = "%s is %s";
		System.out.printf(format, name, "running...\n");
	}

	public static void drive() {
		 String name = "Tim";
	        String format = "%s is %s";
	        System.out.printf(format, name, "driving...\n");
	}
	
	public static void main(String[] args) {
		walk();
		run();
		drive();
	}
}
```
The above example is a duplicate code. You can rearrange it.

```
public class Constant {
	public static String myName = "Tim";
	public static String standardFormat = "%s is %s";
}

class Action {
	public static String name = Constant.myName;
	public static String format = Constant.standardFormat;

	public static void walk() {
		print(name, "walking...");
	}

	public static void run() {
		print(name, "running...");
	}

	public static void drive() {
		print(name, "driving");
	}

	public static void print( String name , String action ) {
		System.out.printf(format, name, action);
	}

	public static void Main(String[] args) {
		walk();
		run();
		drive();
	}
}
``` 
As you see from this, if we change the constants in Constant.java then the change will be propagated through the application. 

##Exercise
I have an exercise for you to work on. It was in src/ directory name Mechanic.

##Reference:
https://dotnetcodr.com/2013/10/17/the-dont-repeat-yourself-dry-design-principle-in-net-part-1/
http://www.artima.com/intv/dry2.html
http://programmer.97things.oreilly.com/wiki/index.php/Don't_Repeat_Yourself

#No Long Methods
As a rule of thumb, if you feel the need to comment on something inside a method, you should take this code and put it in a new method. 
Even a single line can and should be split off into a separate method, if it requires explanations. And if the method has a descriptive name, nobody will need to look at the code to see what it does.

- To reduce the length of a method body, use Extract Method.
