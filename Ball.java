
public class Ball {
	public Rec rec;
	public Rec lPaddle, RPaddle;

	private double vy = 300.0;
	private double vx = -100.0;

	public Ball(Rec rec, Rec lPaddle, Rec RPaddle) {
		this.rec = rec;
		this.lPaddle = lPaddle;
		this.RPaddle = RPaddle;
	}

	public void update(double dt) {
		if (vx < 0.0) {
			if (this.rec.x <= this.lPaddle.x + this.lPaddle.width && this.rec.x + this.rec.width >= this.lPaddle.x
					&& this.rec.y >= this.lPaddle.y && this.rec.y <= this.lPaddle.y + this.lPaddle.height) {
				this.vx *= -1;
				this.vy *= -1;
			} else if (this.rec.x + this.rec.width < this.lPaddle.x) {
				System.out.println("You lost a point");
			}
		} else if (vx > 0.0) {
			if (this.rec.x + this.rec.width >= this.RPaddle.x && this.rec.x <= this.RPaddle.x + this.RPaddle.width
					&& this.rec.y >= this.RPaddle.y && this.rec.y <= this.RPaddle.y + this.RPaddle.height) {
				this.vx *= -1;
				this.vy *= -1;
			} else if (this.rec.x + this.rec.width > this.RPaddle.x + this.RPaddle.width) {
				System.out.println("AI lost a point");
			}
		}

		if (vy > 0) {
			if (this.rec.y + this.rec.height > Variables.height) {
				this.vy *= -1;
			}
		} else if (vy < 0) {
			if (this.rec.y < Variables.toolBarHeight) {
				this.vy *= -1;
			}
		}
		this.rec.x += vx * dt;
		this.rec.y += vy * dt;
	}
}
