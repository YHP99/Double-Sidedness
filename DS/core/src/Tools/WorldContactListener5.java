package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.MyGdxGame;

import Screens.Credit;
import Sprite.Enemy4;
import Sprite.Enemy5;
import Sprite.GM5;

public class WorldContactListener5 implements ContactListener {
	private MyGdxGame game;
	protected Enemy5 Enemy;
	protected GM5 GM;

	public boolean is_dialog = false;
	public int dialog = 0;

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();

		// 카테고리비트를 이용하여 어떤 contact 이벤트를 구현하기 위한 기반
		int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

		// GM의 대가리가 어떤 오브젝트에 contact 됬을 때 발생하는 이벤트 -> 마리오에서는 벽돌 대가리로 박는거
		/*
		 * if(fixA.getUserData() == "head" || fixB.getUserData() == "head") { Fixture
		 * head = fixA.getUserData() == "head" ? fixA : fixB; Fixture object = head ==
		 * fixA ? fixB : fixA;
		 * 
		 * if(object.getUserData() != null &&
		 * InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())
		 * ) { ((InteractiveTileObject) object.getUserData()).onHeadHit(); } }
		 */

		// 적과 오브젝트가 만날시에 반대로 가게끔 이벤트 구현
		if (cDef == (game.ENEMY_BIT | game.OBJECT_BIT)) {
			if (fixA.getFilterData().categoryBits == game.ENEMY_BIT)
				((Enemy5) fixA.getUserData()).reverseVelocity(true, false);
			else
				((Enemy5) fixB.getUserData()).reverseVelocity(true, false);
		}

		// 캐릭터와 적이 만날시에 캐릭터가 반대 방향으로 튕겨나가는 이벤트 구현
		if (cDef == (game.GM_BIT | game.ENEMY_BIT)) {
			if (fixA.getFilterData().categoryBits == game.GM_BIT)
				((GM5) fixA.getUserData()).hit((Enemy4) fixB.getUserData());
			else
				((GM5) fixB.getUserData()).hit((Enemy4) fixA.getUserData());
		}

		// credit으로 넘어감
		if (cDef == (game.GM_BIT | game.DEAD4_BIT)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new Credit(null));
		}

		// DIALOG11
		if (cDef == (game.GM_BIT | game.DIALOG11_BIT)) {
			is_dialog = true;
			dialog = 11;
		}

		// 적과 적이 만날시에 반대로 가게끔 이벤트 구현
		if (cDef == (game.ENEMY_BIT | game.ENEMY_BIT)) {
			((Enemy5) fixA.getUserData()).reverseVelocity(true, false);
			((Enemy5) fixB.getUserData()).reverseVelocity(true, false);
		}

	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
