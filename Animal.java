
public abstract class Animal {
	private final static String EATEN = "_";
	private final static String PREFIX = "*";
	protected String str;
	public abstract boolean canEat(Animal other);
	public String toString(){
		return str;
	};
	public void markAsEaten(){
		str = EATEN;
	}
	public void markAsStart(){
		str = PREFIX + str;
	}
	public boolean hasEaten(){
		return (str.equals(EATEN));
	}
}
