package part1;

class Thing {
	public String name;
	public static String description;
}

public class Var {

	public static void main(String[] args) {
		Thing.description = "I am desc";
		System.out.println(Thing.description);

		Thing thing1 = new Thing();
		Thing thing2 = new Thing();

		thing1.name = "Bob";
		thing2.name = "Marley";

		System.out.println(thing1.name);
		System.out.println(thing2.name);

	}

}
