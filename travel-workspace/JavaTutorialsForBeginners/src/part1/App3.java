package part1;

class Robot {

	public void speak(String text) {

		System.out.println(text);
	}

	public void jump(int height) {

		System.out.println("Jumping: " + height);
	}
	
	public void move(String direction, double distance) {
		
		System.out.println("Moving " + distance + " metres in direction " + direction);
	}

}

public class App3 {

	public static void main(String[] args) {

		Robot sam = new Robot();

		sam.speak("I am kd");
		sam.jump(5);
		
		sam.move("East", 9.1);
		
		String greetings = "Hello Kd";
		sam.speak(greetings);
		
		int value = 10;
		sam.jump(value);
		
		double size = 7.5;
		sam.move("east", 7.5);

	}

}
