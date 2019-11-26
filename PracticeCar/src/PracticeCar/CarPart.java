package PracticeCar;

public class CarPart implements Functional {
	public int durability;
	public String partName;
	
	public CarPart(int durability, String partName) {
		this.durability = durability;
		this.partName = partName;
	}
	
	
	public void status() {
		System.out.println("The status of the " + partName + " is " + durability);
	}
	@Override
	public void function() {
	}
	
	
	
}
