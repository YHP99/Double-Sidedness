package Sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import Screens.PlayScreen5;

public class GM5 extends Sprite{
	private MyGdxGame game;
	public enum State {FALLING, JUMPING, STANDING, RUNNING};
	public State currentState;
	public State previousState;
	
	public World world;
	public Body gmbody;
	
	private TextureRegion gmStand;
	private Animation<TextureRegion> gmRun;
	private Animation<TextureRegion> gmJump;
	
	private float stateTimer;
	private boolean runningRight;
	public BodyDef bdef;
	
	
	public GM5(PlayScreen5 screen) {
		super(screen.getAtlas().findRegion("run"));
		this.world = screen.getWorld();
		
		currentState = State.STANDING;
		previousState = State.STANDING;
		stateTimer = 0;
		runningRight = true;
		
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for(int i=0; i<20; i++)
			frames.add(new TextureRegion(getTexture(), i * 416, 0, 416, 454));
		gmRun = new Animation<TextureRegion>(0.1f, frames);
		frames.clear();
		
		for(int i=0; i<20; i++)
			frames.add(new TextureRegion(getTexture(), i * 416, 0, 416, 454));
		gmJump = new Animation<TextureRegion>(0.1f, frames);
		
		gmStand = new TextureRegion(getTexture(), 0, 0, 454, 454);
		
		defineGM();
		setBounds(0, 0, 16 / game.PPM, 16 / game.PPM);
		setRegion(gmStand);
	}
	
	public void update(float dt) {
		setPosition(gmbody.getPosition().x - getWidth() / 2, gmbody.getPosition().y - getHeight() / 2);
		setRegion(getFrame(dt));
	}
	
	public TextureRegion getFrame(float dt) {
		currentState = getState();
		
		TextureRegion region;
		switch(currentState) {
			case JUMPING:
				region = gmJump.getKeyFrame(stateTimer);
				break;
			case RUNNING:
				region = gmRun.getKeyFrame(stateTimer, true);
				break;
			case FALLING:
			case STANDING:
			default:
				region = gmStand;
				break;
		}
		
		if ((gmbody.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
			region.flip(true, false);
			runningRight = false;
		}
		else if((gmbody.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
			region.flip(true, false);
			runningRight = true;
		}
		
		stateTimer = currentState == previousState ? stateTimer + dt : 0;
		previousState = currentState;
		return region;
	}

	public State getState() {
		if (gmbody.getLinearVelocity().y > 0 || (gmbody.getLinearVelocity().y < 0 && previousState == State.JUMPING))
			return State.JUMPING;
		else if (gmbody.getLinearVelocity().y < 0)
			return State.FALLING;
		else if (gmbody.getLinearVelocity().x != 0)
			return State.RUNNING;
		else
			return State.STANDING;
	}
	
	/*// 죽었을 때 
	public void die() {
		// maskBits을 NOTHING_BIT으로 지정해줌으로서 OBJECT_BIT와 충돌이 안됨
		Filter filter = new Filter();
		filter.maskBits = game.NOTHING_BIT;

		for (Fixture fixture : gmbody.getFixtureList()) {
			fixture.setFilterData(filter);
		}

	}*/
	
	// 적이랑 닿으면 날라감
	public void hit(Enemy4 enemy4) {
		gmbody.applyLinearImpulse(new Vector2(-4f, 4f), gmbody.getWorldCenter(), true); 
	}
	
	public float getStateTimer(){
        return stateTimer;
    }

	public void defineGM() {
		bdef = new BodyDef();
		bdef.position.set(14250 / game.PPM, 40 / game.PPM);		// 14250, 40
		bdef.type = BodyDef.BodyType.DynamicBody;
		gmbody = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(6 / game.PPM);
		// GM의 카테고리는 GM이라고 명시
		fdef.filter.categoryBits = game.GM_BIT;
		// 여기다가 해당 BIT를 넣어줘야 GM과 contact시 이벤트 구현이 가능해짐
		fdef.filter.maskBits = (short) (game.ENEMY_BIT | game.OBJECT_BIT
				| game.DEAD_BIT | game.DEAD2_BIT | game.DEAD3_BIT | game.DEAD4_BIT | game.DIALOG11_BIT);
		fdef.shape = shape;
		
		gmbody.createFixture(fdef).setUserData(this);
		
		// 대가리 shape 구현
		/*EdgeShape head = new EdgeShape();
		head.set(new Vector2(-2 / game.PPM, 6 / game.PPM), new Vector2(2 / game.PPM, 6 / game.PPM));
		fdef.shape = head;
		fdef.isSensor = true;
		
		gmbody.createFixture(fdef).setUserData("head");*/
	}

}
