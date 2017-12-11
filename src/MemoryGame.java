import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
/**
 * A class that implements a memory game where player(s) take(s) turns finding matches in order to clear the board
 * @author annieq2
 *
 */
public class MemoryGame extends JFrame{
	JPanel p=new JPanel();
	static MemoryCards buttons[]=new MemoryCards[100];
	
	/**
	 * Shuffle the cards in the memory board
	 */
	public void shuffle() {
		p.setLayout(new GridLayout(10,10));
		for(int i=0;i<100;i++){
			buttons[i]=new MemoryCards();
			buttons[i].location = i;
			p.add(buttons[i]);
		}
		
		//prints the corresponding card in each tile of the grid
		for(int i = 0, j = 0; i<100; i++,j++) {
			if (j == 10) {
				System.out.println();
				j = 0;
			}
			buttons[i].ID = MemoryCards.idBoard[i/10][j]/10;
			System.out.print(buttons[i].ID + " ");
		}
		System.out.println();
		System.out.println();
		
		//prints out the location of each memory card with respect to the board
		for(int i = 0, j = 0; i<100; i++,j++) {
			if (j == 10) {
				System.out.println();
				j = 0;
			}
			System.out.print(buttons[i].location + " ");
		}
		System.out.println();
		System.out.println();
		add(p);
	}
	
	public MemoryGame(){
		super("MemoryGame");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		shuffle();
		setVisible(true);
	}	
	
	/**
	 * Resets the game
	 */
	public static void reset() {
		if (MemoryCards.count == 100) {
			for (int i = 0; i < 100; i++) {
				buttons[i].setIcon(null);
				buttons[i].hideme = true;
			}
		}
		MemoryCards.count = 0;
	}
	
	/**
	 * Main Method.
	 * @param args
	 */
	public static void main(String args[]){
		//starts the game
		new MemoryGame();
		
		//prints out the id's of each memory card
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(MemoryCards.idBoard[i][j] + " ");
			}
			System.out.println();
		}

		
	}
}
