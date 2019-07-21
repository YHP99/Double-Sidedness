package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.MyGdxGame;

import BackMusic.MusicPlayer;
import Screens.PlayScreen2;
import Screens.PlayScreen3;
import Sprite.Enemy2;
import Sprite.GM2;

public class WorldContactListener2 implements ContactListener {
	private MyGdxGame game;
	private MusicPlayer music;
	protected Enemy2 Enemy;
	protected GM2 GM;

	public boolean is_dialog = false;
	public int dialog = 0;

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();

		// ī�װ���Ʈ�� �̿��Ͽ� � contact �̺�Ʈ�� �����ϱ� ���� ���
		int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

		// GM�� �밡���� � ������Ʈ�� contact ���� �� �߻��ϴ� �̺�Ʈ -> ������������ ���� �밡���� �ڴ°�
		/*
		 * if(fixA.getUserData() == "head" || fixB.getUserData() == "head") { Fixture
		 * head = fixA.getUserData() == "head" ? fixA : fixB; Fixture object = head ==
		 * fixA ? fixB : fixA;
		 * 
		 * if(object.getUserData() != null &&
		 * InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())
		 * ) { ((InteractiveTileObject) object.getUserData()).onHeadHit(); } }
		 */

		// ���� ������Ʈ�� �����ÿ� �ݴ�� ���Բ� �̺�Ʈ ����
		if (cDef == (game.ENEMY_BIT | game.OBJECT_BIT)) {
			if (fixA.getFilterData().categoryBits == game.ENEMY_BIT)
				((Enemy2) fixA.getUserData()).reverseVelocity(true, false);
			else
				((Enemy2) fixB.getUserData()).reverseVelocity(true, false);
		}

		// ĳ���Ϳ� ���� �����ÿ� ĳ���Ͱ� �ݴ� �������� ƨ�ܳ����� �̺�Ʈ ����
		if (cDef == (game.GM_BIT | game.ENEMY_BIT)) {
			if (fixA.getFilterData().categoryBits == game.GM_BIT)
				((GM2) fixA.getUserData()).hit((Enemy2) fixB.getUserData());
			else
				((GM2) fixB.getUserData()).hit((Enemy2) fixA.getUserData());
		}

		// ĳ���Ϳ� �״� ������ �����ÿ� ĳ���Ͱ� �״� �̺�Ʈ ���� (�ι�° ���̺� ����Ʈ)
		if (cDef == (game.GM_BIT | game.DEAD2_BIT)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen2(null, false));
		}

		// ĳ���Ϳ� �״� ������ �����ÿ� ĳ���Ͱ� �״� �̺�Ʈ ���� (����° ���̺� ����Ʈ)
		if (cDef == (game.GM_BIT | game.DEAD3_BIT)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen3(null, true));
		}

		// DIALOG7
		if (cDef == (game.GM_BIT | game.DIALOG7_BIT)) {
			is_dialog = true;
			dialog = 7;
		}

		// DIALOG8
		if (cDef == (game.GM_BIT | game.DIALOG8_BIT)) {
			is_dialog = true;
			dialog = 8;
		}

		// ���� ���� �����ÿ� �ݴ�� ���Բ� �̺�Ʈ ����
		if (cDef == (game.ENEMY_BIT | game.ENEMY_BIT)) {
			((Enemy2) fixA.getUserData()).reverseVelocity(true, false);
			((Enemy2) fixB.getUserData()).reverseVelocity(true, false);
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
