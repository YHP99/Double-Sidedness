package Sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import Screens.PlayScreen4;

public abstract class Enemy4 extends Sprite {
	protected World world;
	protected PlayScreen4 screen;
	public Body enemybody;
	public Vector2 velocity;

	public Enemy4(PlayScreen4 screen, float x, float y) {
		this.world = screen.getWorld();
		this.screen = screen;
		setPosition(x, y);
		defineEnemy();
		velocity = new Vector2(1, 0);
	}

	protected abstract void defineEnemy();

	public abstract void update(float dt);

	public void reverseVelocity(boolean x, boolean y) {
		if (x)
			velocity.x = -velocity.x;
		if (y)
			velocity.y = -velocity.y;
	}

}
