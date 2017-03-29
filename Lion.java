
public class Lion extends Animal{
	public Lion(){
		super();
		str = "L";
	}
	public boolean canEat(Animal other){
		switch(other.getClass().getName()){
			case "Lion": 
				return false;
			default:
				return true;
		}
	}

}
