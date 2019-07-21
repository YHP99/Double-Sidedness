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
import Screens.PlayScreen3;
import Screens.PlayScreen4;
import Sprite.Enemy3;
import Sprite.GM3;

public class WorldContactListener3 implements ContactListener {
	private MyGdxGame game;
	private MusicPlayer music;
	protected Enemy3 Enemy;
	protected GM3 GM;

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
				((Enemy3) fixA.getUserData()).reverseVelocity(true, false);
			else
				((Enemy3) fixB.getUserData()).reverseVelocity(true, false);
		}

		// ĳ���Ϳ� ���� �����ÿ� ĳ���Ͱ� �ݴ� �������� ƨ�ܳ����� �̺�Ʈ ����
		if (cDef == (game.GM_BIT | game.ENEMY_BIT)) {
			if (fixA.getFilterData().categoryBits == game.GM_BIT)
				((GM3) fixA.getUserData()).hit((Enemy3) fixB.getUserData());
			else
				((GM3) fixB.getUserData()).hit((Enemy3) fixA.getUserData());
		}

		// ĳ���Ϳ� �״� ������ �����ÿ� ĳ���Ͱ� �״� �̺�Ʈ ���� (����° ���̺� ����Ʈ)
		if (cDef == (game.GM_BIT | game.DEAD3_BIT)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen3(null, false));
		}

		// ĳ���Ϳ� �״� ������ �����ÿ� ĳ���Ͱ� �״� �̺�Ʈ ���� (�׹�° ���̺� ����Ʈ)
		if (cDef == (game.GM_BIT | game.DEAD4_BIT)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen4(null, true));
		}

		// DIALOG10
		if (cDef == (game.GM_BIT | game.DIALOG10_BIT)) {
			is_dialog = true;
			dialog = 10;
		}

		// DIALOG11
		if (cDef == (game.GM_BIT | game.DIALOG11_BIT)) {
			is_dialog = true;
			dialog = 11;
		}

		// ���� ���� �����ÿ� �ݴ�� ���Բ� �̺�Ʈ ����
		if (cDef == (game.ENEMY_BIT | game.ENEMY_BIT)) {
			((Enemy3) fixA.getUserData()).reverseVelocity(true, false);
			((Enemy3) fixB.getUserData()).reverseVelocity(true, false);
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
