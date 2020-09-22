
public class AI {
	public PlayerController pc;
	public Rec ball;
	
	public AI(PlayerController pc, Rec ball) {
		this.pc = pc;
		this.ball = ball;
	}
	
	public void update(double dt) {
		pc.update(dt);
		
		if(ball.y < pc.rec.y) {
			pc.moveup(dt);
		}else if(ball.y + ball.height > pc.rec.y+pc.rec.height) {
			pc.movedown(dt);
		}
	}
} 
