
public class Fox extends Animal{
	public Fox(){
		super();
		str = "F";
	}
	public boolean canEat(Animal other){
		switch(other.getClass().getName()){
			case "Lion": 
				return false;
			case "Tiger": 
				return false;
			case "Fox": 
				return false;
			default:
				return true;
		}
	}
}
