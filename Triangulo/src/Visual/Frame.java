package Visual;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		setTitle("Triangulo.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setContentPane(new Panel());

	}
}
	
