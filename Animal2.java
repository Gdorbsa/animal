
public enum Animal2 {
	Lion2("L"), Tiger2("T"), Fox2("F"), Chicken2("C"), Starter("");
	private String str;
	private Animal2(String str){
		this.str = str;
	}
	public String getStr(){
		return str;
	}
	public void setStr(String str){
		this.str = str;
	}
	public boolean canEat(Animal2 other){
		switch(this){
			case Lion2:
				switch(other){
					case Lion2:
						return false;
					default:
						return true;
				}
			case Tiger2:
				switch(other){
					case Lion2:
						return false;
					case Tiger2:
						return false;
					default:
						return true;
				}
			case Fox2:
				switch(other){
					case Lion2:
						return false;
					case Tiger2:
						return false;
					case Fox2:
						return false;
					default:
						return true;
				}
			case Chicken2:
				return false;
		}
		return true;
	}
}
