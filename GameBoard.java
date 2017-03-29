import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
	private ArrayList<Animal> board;
	private int size;
	private final static String PREFIX = "| ";
	private final static String SUFIX = " |";
	private final static String SUFIX_S = " | ";
	public void initialize(int size){
		board = new ArrayList<Animal>(size*size);
		this.size = size;
		fillBoardRandom();
	}
	private void fillBoardRandom(){
		for(int i = 0; i < size*size; i++){
			board.add(getRandomAnimal());
		}
	}
	private Animal getRandomAnimal(){
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		switch(rand){
			case 0:
				return new Lion();
			case 1:
				return new Tiger();
			case 2:
				return new Fox();
			case 3:
				return new Chicken();
			default:
				return new Lion();
		}
	}
	public void printBoard(){
		for(int i = 0; i < size; i++){
			int j = 0;
			System.out.print(PREFIX);
			System.out.print(board.get(i*size).toString() + SUFIX_S);
			for(j = 1; j < size - 1; j++){
				System.out.print(board.get(calcIdx(i, j)).toString() + SUFIX_S);
			}
			System.out.print(board.get(calcIdx(i, j)).toString() + SUFIX);
			System.out.println();
		}
	}
	public void playFromRandomSpot(){
		int rand_i = ThreadLocalRandom.current().nextInt(0, size);
		int rand_j = ThreadLocalRandom.current().nextInt(0, size);
		Animal startSpot = board.get(calcIdx(rand_i, rand_j));
		playBoard(startSpot, rand_i, rand_j);
	}
	private void playBoard(Animal leader, int leader_i, int leader_j){
		leader.markAsStart();
		fillBoardRec(leader, leader_i, leader_j - 1);
		fillBoardRec(leader, leader_i - 1, leader_j);
		fillBoardRec(leader, leader_i, leader_j + 1);
		fillBoardRec(leader, leader_i + 1, leader_j);
	}
	private void fillBoardRec(Animal leader, int target_i, int target_j){
		if(target_i < 0 || target_i >= size|| target_j < 0|| target_j >= size) return;
		Animal targetAnimal = board.get(calcIdx(target_i, target_j));
		if(targetAnimal.hasEaten()) return;
		if(!leader.canEat(targetAnimal)) return;
		targetAnimal.markAsEaten();
		fillBoardRec(leader, target_i, target_j - 1);
		fillBoardRec(leader, target_i - 1, target_j);
		fillBoardRec(leader, target_i, target_j + 1);
		fillBoardRec(leader, target_i + 1, target_j);
	}
	private int calcIdx(int i, int j){
		return (i*size + j);
	}

}
