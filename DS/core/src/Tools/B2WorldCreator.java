package Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import Screens.PlayScreen;
import Sprite.Goomba;

public class B2WorldCreator {
	private MyGdxGame game;
	private Array<Goomba> goombas;

	public B2WorldCreator(PlayScreen screen) {
		World world = screen.getWorld();
		TiledMap map = screen.getMap();

		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;

		// �� �� �����ϴ� ������Ʈ ���̾�, for() ��ȣ�ȿ� map.getLayers().get()���� get�ȿ� �� ���ڴ�
		// map���α׷��ȿ� �ִ� ���ϴ� layer�� ����
		// ���̾� 5�� ��ü���� Ʋ
		for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.OBJECT_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 6�� Enemy object
		goombas = new Array<Goomba>();
		for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			goombas.add(new Goomba(screen, (rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM));
		}

		// ���̾� 7�� Point1 object
		for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DEAD_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 8�� Point2 object
		for (MapObject object : map.getLayers().get(8).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DEAD2_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 11�� NPC1 object
		for (MapObject object : map.getLayers().get(11).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG2_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 12�� NPC2 object
		for (MapObject object : map.getLayers().get(12).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG3_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 13�� NPC3 object
		for (MapObject object : map.getLayers().get(13).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG4_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 14�� Dialog5 object
		for (MapObject object : map.getLayers().get(14).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG5_BIT;
			body.createFixture(fdef);

		}

	}

	public Array<Goomba> getGoombas() {
		return goombas;
	}

}
