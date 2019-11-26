package PracticeCar;
import PracticeCar.Engine;
import PracticeCar.Wheels;

public class Car {
	Wheels wh = new Wheels(100, "Wheels", 94);
	Engine en = new Engine(80, "Engine", 8);
	Object[] carArr = new Object[] {wh, en};
	
	public void run(){
		wh.status();
		en.status();
		
		//loop through the car Array and use the functions
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i].equals(wh)) {
				wh.function();
			} else {
				en.function();
			}
		}
		
	}


	
	
	
	
}
