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
	MemoryCards buttons[]=new MemoryCards[100];
	static int randomX = (int)(Math.random()*10);
	static int randomY = (int)(Math.random()*10);
	static int[][] idBoard = new int[10][10];
	int ID = 0;
	
	public void shuffle() {
		p.setLayout(new GridLayout(10,10));
		for(int i=0;i<100;i++){
			buttons[i]=new MemoryCards();
			p.add(buttons[i]);
			while(idBoard[randomX][randomY] != 0) {
				randomX = (int)(Math.random()*10);
				randomY = (int)(Math.random()*10);
			}
			idBoard[randomX][randomY] = ID;
			ID++;
		}
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
	
	public static void main(String args[]){
		new MemoryGame();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(idBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
