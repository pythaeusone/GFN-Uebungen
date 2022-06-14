package de.mufa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

class Stuecke {	
	double value;
	Color color;
	public Stuecke(double value, Color color) {
		this.value = value;
		this.color = color;
	}
	
}

class Cut extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	Stuecke[] stuecke = new Stuecke[24];

	Cut(int gegessen) {
		int verbleiben = 12 - gegessen;
		int j = 0;
		for(int i = 0; i < 12; i++) {
			if(verbleiben > 0) {
				stuecke[j] = new Stuecke(15, Color.orange);
				verbleiben--;
			}else {
				stuecke[j] = new Stuecke(15, Color.gray);
			}
			j++;
			stuecke[j] = new Stuecke(1, Color.gray);
			j++;
		}
	
	}
	
	public void paint(Graphics g) {
		
		Rectangle kuchen = new Rectangle();
		kuchen.setRect(30, 30, 400, 400);
		zeichneKuchen((Graphics2D) g, kuchen, stuecke);
		
	}

	void zeichneKuchen(Graphics2D g, Rectangle area, Stuecke[] stuecke) {
		
		double total = 0.0D;
		for (int i = 0; i < stuecke.length; i++) {
		total += stuecke[i].value;
		
	}

	double curValue = 0.0D;
	int startAngle = 0;
	for (int i = 0; i < stuecke.length; i++) {
		
		startAngle = (int) (curValue * 360 / total);
		int arcAngle = (int) (stuecke[i].value * 360 / total);
		
		g.setColor(stuecke[i].color);
		g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
		curValue += stuecke[i].value;
	}
	
  }

}

public class Cutter {
	
	void createWindow(String name, int stuecke) {
		JFrame frame = new JFrame();
		frame.setTitle(name+"kuchen Stücke");
	    frame.getContentPane().add(new Cut(stuecke));
	    frame.setSize(500, 500);
	    frame.getContentPane().setBackground(Color.gray);
	    frame.setVisible(true);
	}
	
}
