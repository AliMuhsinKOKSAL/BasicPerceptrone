import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Main {
	 
	public static void main(String[] args) throws InterruptedException {
		Examples ex = new Examples();
		
		BasicPerceptrone bp   = new BasicPerceptrone();
		bp.init();
		
		ex.guesses = bp.createGuessSet(ex.x0s, ex.x1s, ex.numberOfExample);
		
		JFrame frame = new JFrame();
		frame.add(ex);
		frame.setSize((int)ex.screenMax,(int)ex.screenMax+38);	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  bp.training(ex.x0s[ex.ind], ex.x1s[ex.ind], ex.outputs[ex.ind]);
				  ex.guesses = bp.createGuessSet(ex.x0s, ex.x1s, ex.numberOfExample);
				  ex.line0 = bp.x0InTen();
				  ex.line1 = bp.mX0InTen();
				  frame.repaint();
				  ex.ind = (ex.ind + 1) % ex.numberOfExample;
			  }
			}, 0 , 10);
	}
}
