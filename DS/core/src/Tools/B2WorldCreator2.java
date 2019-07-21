package Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

import Screens.PlayScreen2;
import Sprite.Goomba2;

public class B2WorldCreator2 {
	private MyGdxGame game;
	private Array<Goomba2> goombas;

	public B2WorldCreator2(PlayScreen2 screen) {
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
		goombas = new Array<Goomba2>();
		for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			goombas.add(new Goomba2(screen, (rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM));
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

		// ���̾� 9�� Point3 object
		for (MapObject object : map.getLayers().get(9).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DEAD3_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 15�� NPC4 object
		for (MapObject object : map.getLayers().get(15).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG7_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 16�� NPC5 object
		for (MapObject object : map.getLayers().get(16).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG8_BIT;
			body.createFixture(fdef);

		}

	}

	public Array<Goomba2> getGoombas() {
		return goombas;
	}

}
