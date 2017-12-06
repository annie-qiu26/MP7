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
	boolean hideme = false;
	ImageIcon X,O;
	static int value=0;
	static int randomX = (int)(Math.random()*10);
	static int randomY = (int)(Math.random()*10);
	static int[][] idBoard = new int[10][10];
	int ID; 
	int location;
	static int pastIndex = -1;
	
	/*
	0:nothing
	1:X
	2:O
	*/
	
	public MemoryCards(){
		while(idBoard[randomX][randomY] != 0) {
			randomX = (int)(Math.random()*10);
			randomY = (int)(Math.random()*10);
		}
		idBoard[randomX][randomY] = value;
		value++;
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		//preventing player from hiding card by selecting card twice
		if (pastIndex == this.location) {
			return;
		}
		pastIndex = this.location;
		switch(this.ID){
			case 0:
				setIcon(O);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
			case 3:
				setIcon(O);
				break;
			case 4:
				setIcon(O);
				break;
			case 5:
				setIcon(O);
				break;
			case 6:
				setIcon(O);
				break;
			case 7:
				setIcon(O);
				break;
			case 8:
				setIcon(O);
				break;
			case 9:
				setIcon(O);
				break;
		}
	}
}

