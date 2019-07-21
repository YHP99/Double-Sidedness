package Sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import Screens.PlayScreen3;

public class Goomba3 extends Enemy3{
	private MyGdxGame game;
	private float stateTimer;
	private Animation<TextureRegion> walkAnimation;
	private Array<TextureRegion> frames;
	public Body enemybody;

	public Goomba3(PlayScreen3 screen, float x, float y) {
		super(screen, x, y);
		frames = new Array<TextureRegion>();
		for (int i=0; i<2; i++)
			frames.add(new TextureRegion(screen.EnemyAtlas().findRegion("Áú»¶ÀÌ"), i * 16, 0, 14, 14));
		walkAnimation = new Animation<TextureRegion>(0.4f, frames);
		stateTimer = 0;
		setBounds(getX(), getY(), 16 / game.PPM, 16 / game.PPM);
	}
	
	public void update(float dt) {
		stateTimer += dt;
		enemybody.setLinearVelocity(velocity);
		setPosition(enemybody.getPosition().x - getWidth()/2, enemybody.getPosition().y - getHeight()/2);
		setRegion(walkAnimation.getKeyFrame(stateTimer, true));
	}

	@Override
	protected void defineEnemy() {
		BodyDef bdef = new BodyDef();
		// ¹ö¼¸ »õ³¢ À§Ä¡
		bdef.position.set(getX(), getY());
		bdef.type = BodyDef.BodyType.DynamicBody;
		enemybody = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(6 / game.PPM);
		fdef.filter.categoryBits = game.ENEMY_BIT;
		fdef.filter.maskBits = (short) (game.ENEMY_BIT | game.OBJECT_BIT | game.GM_BIT);
		fdef.shape = shape;
		
		enemybody.createFixture(fdef).setUserData(this);;
		
	}

}
