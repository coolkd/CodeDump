package part1;

class Person {

	// Instance variables (data or "state")
	String name;
	int age;

	// classes can contain
	// 1.Data
	// 2.Subroutines (methods)
	void speak() {
		for (int i = 0; i < 3; i++) {

		}
		System.out.println("My name is: " + name + " and I am " + age + " years old ");

	}

	void run() {
		System.out.println("Kuldeep is running");

	}

}

public class App {

	public static void main(String[] args) {

		Person person1 = new Person();
		person1.name = "kuldeep";
		person1.age = 30;
		person1.speak();
		person1.run();

		Person person2 = new Person();
		person2.name = "Jack";
		person2.age = 21;
		person2.speak();
		person2.run();

		System.out.println(person1.name);
		System.out.println(person1.age);
		System.out.println(person2.name);
		System.out.println(person2.age);

	}

}
