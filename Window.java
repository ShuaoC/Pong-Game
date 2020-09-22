import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

	public Graphics2D g2;
	public KL keyListener = new KL();
	public Rec p1, ai, ballrec;
	public PlayerController pc;
	public AI aic;
	public Ball ball;

	public Window() {
		this.setSize(Variables.width, Variables.height);
		this.setTitle(Variables.GameTitle);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyListener);
		Variables.toolBarHeight = this.getInsets().top;
		g2 = (Graphics2D) this.getGraphics();
		p1 = new Rec(50, 100, Variables.PW, Variables.PH, Color.BLUE);
		ai = new Rec(Variables.width - 60, 100, Variables.PW, Variables.PH, Color.RED);
		ballrec = new Rec(Variables.width/2,Variables.height/2,Variables.BW,Variables.BW,Color.WHITE);
		ball = new Ball(ballrec,p1,ai);
		
		aic = new AI(new PlayerController(ai),ballrec);
		pc = new PlayerController(p1,keyListener);
	}

	public void update(double dt) {
		Image dbImage = createImage(getWidth(),getHeight());
		Graphics dbg = dbImage.getGraphics();
		this.draw(dbg);
		g2.drawImage(dbImage,0,0,this);
		pc.update(dt);
		aic.update(dt);
		ball.update(dt);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, Variables.width, Variables.height);
		p1.draw(g2);
		ai.draw(g2);
		ballrec.draw(g2);
	}//Smooth Frame Rate
	
	@Override
	public void run() {
		double lastFrameTime = 0.0;
		while (true) {
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime;
			lastFrameTime = time;

			update(deltaTime);

			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
		}
	}

}
