public class Main {
	public static void main(String[] args) {
		GameBoard a = new GameBoard();
		a.initialize(10);
		a.printBoard();
		a.playFromRandomSpot();
		System.out.println();
		a.printBoard();
	}
}