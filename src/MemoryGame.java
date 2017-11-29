import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class MemoryGame extends JFrame{
	JPanel p=new JPanel();
	MemoryCards buttons[]=new MemoryCards[100];
	
	public static void main(String args[]){
		new MemoryGame();
	}
	
	public MemoryGame(){
		super("MemoryGame");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(10,10));
		for(int i=0;i<100;i++){
			buttons[i]=new MemoryCards();
			p.add(buttons[i]);
		}
		add(p);
		
		setVisible(true);
	}	
}
