package part1;

class Machine {
	private String name;
	private int code;

	public Machine() {
		this("Monkey", 10);
		System.out.println("Constructor is running!");
	}

	public Machine(String name) {
		this(name, 0);
		
		System.out.println("Second constructor is running");
		this.name = name;

	}

	public Machine(String name, int code) {
		System.out.println("Third constructor is running");
		this.name = name;
		this.code = code;

	}

}

public class Constructor {

	public static void main(String[] args) {
		Machine machine1 = new Machine();

		Machine machine2 = new Machine("Berfy");

		Machine machine3 = new Machine("Chinky", 10);

	}

}
