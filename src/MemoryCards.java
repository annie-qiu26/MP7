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
	ImageIcon X,O;
	static int value=0;
	/*
	0:nothing
	1:X
	2:O
	*/
	
	public MemoryCards(){
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		value++;
		value%=3;
		switch(value){
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
		}
	}
}

