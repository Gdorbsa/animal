import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard2 {
	private ArrayList<Animal2> board;
	private int size;
	private final static String PREFIX = "| ";
	private final static String EATEN = "-";
	private final static String STARTER = "*";
	private final static String SUFIX = " |";
	private final static String SUFIX_S = " | ";
	public void initialize(int size){
		board = new ArrayList<Animal2>(size*size);
		this.size = size;
		fillBoardRandom();
	}
	private void fillBoardRandom(){
		for(int i = 0; i < size*size; i++){
			board.add(getRandomAnimal());
		}
	}
	private Animal2 getRandomAnimal(){
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		switch(rand){
			case 0:
				return Animal2.Lion2;
			case 1:
				return Animal2.Tiger2;
			case 2:
				return Animal2.Fox2;
			case 3:
				return Animal2.Chicken2;
			default:
				return Animal2.Lion2;
		}
	}
	public void printBoard(){
		for(int i = 0; i < size; i++){
			int j = 0;
			Animal2 current = board.get(i*size + j);
			String str;
			if (current == null) str = EATEN;
			else str = current.getStr();
			System.out.print(PREFIX + str + SUFIX_S);			
			for(j = 1; j < size - 1; j++){
				current = board.get(i*size + j);
				if (current == null) str = EATEN;
				else str = current.getStr();
				System.out.print(str + SUFIX_S);
			}
			current = board.get(i*size + j);
			if (current == null) str = EATEN;
			else str = current.getStr();
			System.out.println(str + SUFIX);
		}
	}
	public void startPlay(){
		int rand_i = ThreadLocalRandom.current().nextInt(0, size);
		int rand_j = ThreadLocalRandom.current().nextInt(0, size);
		Animal2 starter = board.get(rand_i*size + rand_j);
		playBoard(starter, rand_i, rand_j);
	}
	public void playBoard(Animal2 starter, int i, int j){
		playBoardRec(starter, i+1, j);
		playBoardRec(starter, i-1, j);
		playBoardRec(starter, i, j+1);
		playBoardRec(starter, i, j-1);
		markStarter(i, j);
	}
	public void playBoardRec(Animal2 leader, int i, int j){
		if(i >= size || i < 0 || j >= size || j < 0) return;
		Animal2 target = board.get(i*size + j);
		if(target == null) return;
		if(!leader.canEat(target)) return;
		board.set(i*size + j, null);
		playBoardRec(leader, i+1, j);
		playBoardRec(leader, i-1, j);
		playBoardRec(leader, i, j+1);
		playBoardRec(leader, i, j-1);
	}
	public void markStarter(int i, int j){
		Animal2 oldStarter = board.get(i*size + j);
		Animal2 newStarter = Animal2.Starter;
		newStarter.setStr(STARTER + oldStarter.getStr());
		board.set(i*size + j, newStarter);
	}
}
