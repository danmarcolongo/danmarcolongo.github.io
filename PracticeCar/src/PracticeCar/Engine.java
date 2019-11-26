package PracticeCar;

public class Engine extends CarPart {
	int cylinders;
	
	public Engine(int durability, String partName, int cylinders) {
		super(durability, partName);
		this.cylinders = cylinders;
	}
	
	@Override
	public void function() {
		System.out.println("The engine has " + cylinders + " cylinders");
	}
	
	@Override
	public void status() {
		super.status();
	}
	
}
