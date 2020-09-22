import java.awt.event.KeyEvent;

public class PlayerController {
	public Rec rec;
	public KL keylistener;

	public PlayerController(Rec rec, KL keylistener) {
		this.rec = rec;
		this.keylistener = keylistener;
	}

	public PlayerController(Rec rec) {
		this.rec = rec;
		this.keylistener = null;
	}

	public void update(double dt) {
		if (keylistener != null) {

			if (keylistener.isKeypressed(KeyEvent.VK_S)) {
				movedown(dt);
			} else if (keylistener.isKeypressed(KeyEvent.VK_W)) {
				moveup(dt);
			}
		}
	}

	public void moveup(double dt) {
		if (rec.y - 100 * dt > Variables.toolBarHeight) {
			this.rec.y -= (Variables.speed * dt);
		}
	}

	public void movedown(double dt) {
		if ((rec.y + 100 * dt) + rec.height < Variables.height) {
			this.rec.y += (Variables.speed * dt);
		}
	}
}
