
public class Tiger extends Animal{
	public Tiger(){
		super();
		str = "T";
	}
	public boolean canEat(Animal other){
		switch(other.getClass().getName()){
			case "Lion": 
				return false;
			case "Tiger": 
				return false;
			default:
				return true;
		}
	}
}
