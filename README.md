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
I have an exercise for you to work on. https://github.com/csupisara/codeguide/blob/master/src/Mechanic.java

##Reference:
https://dotnetcodr.com/2013/10/17/the-dont-repeat-yourself-dry-design-principle-in-net-part-1/
http://www.artima.com/intv/dry2.html
http://programmer.97things.oreilly.com/wiki/index.php/Don't_Repeat_Yourself

#No Long Methods
As a rule of thumb, if you feel the need to comment on something inside a method, you should take this code and put it in a new method. 
If we use too much lines in a method, it will make it harder to figure out what this method does.

There are many ways to reduce the length of a method body.
1.Extract Method.
Problem: The code can be grouped together.
Solution: Move it to a separate new method (or function) and replace the old code with a call to the method.

2.Replace Temp with Query 
```
double calculateTotal() {
  double basePrice = quantity * itemPrice;
  if (basePrice > 1000) {
    return basePrice * 0.95;
  }
  else {
    return basePrice * 0.98;
  }
}
```
solution: Query the method instead of using a variable.
```
double calculateTotal() {
  if (basePrice() > 1000) {
    return basePrice() * 0.95;
  }
  else {
    return basePrice() * 0.98;
  }
}
double basePrice() {
  return quantity * itemPrice;
}
```

3.Introduce Parameter Object or Preserve Whole Object.
Problem: Repeating parameters.
```
sum(x : int, y : int)
product(x : int, y :int)
divide(x : int, y : int)
```
Solution: Replace these parameters with an object.
```
sum(num : Number)
product(num : Number)
divide(num : Number)
```

4.Moving the entire method to a separate object by replace method with method Object.
Problem: You have a long method in which the local variables are so mash up, so you cannot apply Extract Method.
```
class Order {
  //...
  public double price() {
    double primaryBasePrice;
    double secondaryBasePrice;
    double tertiaryBasePrice;
    // long computation.
    //...
  }
}
```
Solution: Transform the method into a separate class so that the local variables become fields of the class.
Then you can split the method into several methods within the same class.
```
class Order {
  //...
  public double price() {
    return new PriceCalculator(this).compute();
  }
}

class PriceCalculator {
  private double primaryBasePrice;
  private double secondaryBasePrice;
  private double tertiaryBasePrice;
  
  public PriceCalculator(Order order) {
    // copy relevant information from order object.
    //...
  }
  
  public double compute() {
    // long computation.
    //...
  }
}
```

5.Conditionals and loops Conditional operators and loops are a good clue that code can be moved to a separate method. 
Problem: You have a complex conditional (`if-then`/`else` or `switch`).
Solution: Decompose the complicated parts of the conditional into separate methods: the condition, `then` and `else`.

##Exercise
I have an exercise for you to work on. https://github.com/csupisara/codeguide/blob/master/src/Combination.java

##Reference
https://sourcemaking.com/refactoring/smells/long-method

