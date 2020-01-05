package part1;

class Frog {

	private String name;
	private int age;

	public String getName() {
		return name;

	}

	public int getAge() {
		return age;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;

	}

	public void setInfo(String name, int age) {

		setName(name);
		setAge(age);
	}
}

public class App4 {

	public static void main(String[] args) {
		Frog frog1 = new Frog();

		// frog1.name = "Candy";
		// frog1.age = 21;

		// System.out.println(frog1.name);

	}

}
