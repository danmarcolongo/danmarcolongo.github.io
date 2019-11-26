package PracticeCar;

public class Wheels extends CarPart {
	int tread;
	
	public Wheels(int durability, String partName, int tread) {
		super(durability, partName);
		this.tread = tread;
	}
	
	@Override
	public void function() {
		System.out.println("These tires are at " + tread + "% tread");
	}
	
	@Override
	public void status() {
		super.status();
	}
	
}
