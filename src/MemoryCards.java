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
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10;
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

	/**
	 * Constructor for MemoryCards
	 */
	public MemoryCards(){
		//gives each MemoryCard a random id
		while(idBoard[randomX][randomY] != 0) {
			randomX = (int)(Math.random()*10);
			randomY = (int)(Math.random()*10);
		}
		hideme = true;
		idBoard[randomX][randomY] = value;
		value++;
		
		//creates image icons for all the memory cards
		icon1 = new ImageIcon(this.getClass().getResource("icon1.png"));
		icon2 = new ImageIcon(this.getClass().getResource("icon2.png"));
		icon3 = new ImageIcon(this.getClass().getResource("icon3.png"));
		icon4 = new ImageIcon(this.getClass().getResource("icon4.png"));
		icon5 = new ImageIcon(this.getClass().getResource("icon5.png"));
		icon6 = new ImageIcon(this.getClass().getResource("icon6.png"));
		icon7 = new ImageIcon(this.getClass().getResource("icon7.png"));
		icon8 = new ImageIcon(this.getClass().getResource("icon8.png"));
		icon9 = new ImageIcon(this.getClass().getResource("icon9.png"));
		icon10 = new ImageIcon(this.getClass().getResource("icon10.png"));
		this.addActionListener(this);
	}
	
	/**
	 * @param e - represents the action of a click
	 */
	public void actionPerformed(ActionEvent e){
		//when all pairs are found, reset game
		if (count == 100) {
			System.out.println("\nGame is over!");	
			System.out.println("\nGame is starting over!");
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
				setIcon(icon2);
				break;
			case 2:
				setIcon(icon3);
				break;
			case 3:
				setIcon(icon4);
				break;
			case 4:
				setIcon(icon5);
				break;
			case 5:
				setIcon(icon6);
				break;
			case 6:
				setIcon(icon7);
				break;
			case 7:
				setIcon(icon8);
				break;
			case 8:
				setIcon(icon9);
				break;
			case 9:
				setIcon(icon10);
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
	
	/**
	 * 
	 * @param past - previous memory card
	 * @return true if the two cards are matching
	 */
	
	public boolean compare(MemoryCards past) {
		if (this.ID == past.ID) {
			//can't hide the cards again
			this.hideme = false;
			past.hideme = false;
			count+=2;
			return true;
		}
		return false;
	}
}

