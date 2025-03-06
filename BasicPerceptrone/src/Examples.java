import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Examples extends JPanel {

	float[] x0s, x1s;
	int[] outputs;
	int numberOfExample;
	
	public int[] guesses;
	
	float exampleMin = -10f;
	float exampleMax = 10f;
	
	float screenMin = 0f;
	float screenMax = 750f;
	
	int ind = 0;
	public float line0,line1;
	
	Random r;

	public Examples() {
		numberOfExample = 100;
		ind = ind%numberOfExample;
		x0s = new float[numberOfExample];
		x1s = new float[numberOfExample];
		outputs  = new int[numberOfExample];
		r = new Random();

		for (int i = 0; i < numberOfExample; i++) {
			x0s[i] = (r.nextFloat()-0.5f)*20;
			x1s[i] = (r.nextFloat()-0.5f)*20;
			if(x0s[i]+7>x1s[i]) {
				outputs[i] = 1;
			}else {
				outputs[i] = -1;
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, (int)screenMax, (int)screenMax);
		g.setColor(Color.black);
		g.drawLine((int)screenMax/2, 0, (int)screenMax/2, (int)screenMax);
		g.drawLine(0, (int)screenMax/2, (int)screenMax, (int)screenMax/2);
			
		g.drawLine(changeRange(10), (int)screenMax - changeRange(line0), changeRange(-10), (int)screenMax - changeRange(line1));
		for(int i = 0;i < numberOfExample; i++) {
			if(outputs[i] == 1) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(changeRange(x0s[i]),(int)screenMax - changeRange(x1s[i]), 15, 15);
			
			if(guesses[i] == outputs[i]) {
				g.setColor(Color.white);
			}else {
				g.setColor(Color.black);
			}
			g.fillOval(changeRange(x0s[i])+3,(int)screenMax - changeRange(x1s[i])+3, 10, 10);
		}
	}
	
	public int changeRange(float number) {
		return (int) (screenMin+(screenMax - screenMin)*(number - exampleMin) / (exampleMax - exampleMin));
	}
}
