
public class Chicken extends Animal{
	public Chicken(){
		super();
		str = "C";
	}
	public boolean canEat(Animal other){
		switch(other.getClass().getName()){
			case "Lion": 
				return false;
			case "Tiger": 
				return false;
			case "Fox": 
				return false;
			case "Chicken": 
				return false;
			default:
				return true;
		}
	}
}
