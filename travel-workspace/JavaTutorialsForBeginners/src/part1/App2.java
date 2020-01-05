package part1;

class Per {
	String name;
	int age;

	void speak() {
		System.out.println("My name is:" + name);

	}

	int calculateYearsToRetirement() {
		int yearsLeft = 64 - age;
		return yearsLeft;
	}

	int getAge() {
		return age;
	}

	String getName() {
		return name;
	}

}

public class App2 {

	public static void main(String[] args) {

		Per per1 = new Per();
		per1.name = "Koo";
		per1.age = 24;

		//per1.speak();

		int years = per1.calculateYearsToRetirement();
		System.out.println("Years left to my retirements:" + years);

		int age = per1.getAge();
		String name = per1.getName();
		System.out.println("Name is:" + name);
		System.out.println("Age is:" + age);

	}

}
