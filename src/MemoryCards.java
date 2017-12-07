import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Memory card class that implements the action listener class to make the grid responsive to clicks
 * @author annieq2
 *
 */
public class MemoryCards extends JButton implements ActionListener{
	boolean hideme = true;
	ImageIcon X,O, icon1;
	static int value=0;
	static int randomX = (int)(Math.random()*10);
	static int randomY = (int)(Math.random()*10);
	static int[][] idBoard = new int[10][10];
	static int count = 0;
	int ID; 
	int location;
	static int turnIndex = 0;
	static MemoryCards pastCard = null;
	static MemoryCards pastPastCard = null;
	static boolean setNull = false;
	static boolean gameIsOver = false;

	
	public MemoryCards(){
		while(idBoard[randomX][randomY] != 0) {
			randomX = (int)(Math.random()*10);
			randomY = (int)(Math.random()*10);
		}
		hideme = true;
		idBoard[randomX][randomY] = value;
		value++;
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		icon1 = new ImageIcon(this.getClass().getResource("icon-1.png"));
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (count == 100) {
			System.out.println("Game is over!");	
			MemoryGame.reset();
			return;
		}
		
		//preventing player from hiding card by selecting card twice
		if (pastCard != null && pastCard.location == this.location) {
			return;
		}
		if (!this.hideme) {
			return;
		}
		
		//indicates that it's the next player's turn, so flips wrong pairs over
		if (turnIndex == 2) {
			turnIndex = 0;
			if (setNull == true) {
				pastCard.setIcon(null);
				pastPastCard.setIcon(null);
				setNull = false;
			}
			pastCard = null;
		}
		turnIndex++;
		
		//puts the correct image with the corresponding number given to each tile
		switch(this.ID){
			case 0:
				setIcon(icon1);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
			case 3:
				setIcon(icon1);
				break;
			case 4:
				setIcon(O);
				break;
			case 5:
				setIcon(icon1);
				break;
			case 6:
				setIcon(O);
				break;
			case 7:
				setIcon(icon1);
				break;
			case 8:
				setIcon(O);
				break;
			case 9:
				setIcon(O);
				break;
		}	
		if (pastCard != null) {
			if (!this.compare(pastCard) && turnIndex == 2) {
				setNull = true;
				pastPastCard = pastCard;
			}
		} 
		pastCard = this;
		
	}
	
	//compares if the cards are the same, and if same, they can't be hidden again
	public boolean compare(MemoryCards past) {
		if (this.ID == past.ID) {
			this.hideme = false;
			past.hideme = false;
			count+=2;
			return true;
		}
		return false;
	}
}

