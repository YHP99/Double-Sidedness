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

import Screens.PlayScreen3;
import Sprite.Goomba3;

public class B2WorldCreator3 {
	private MyGdxGame game;
	private Array<Goomba3> goombas;

	public B2WorldCreator3(PlayScreen3 screen) {
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
		goombas = new Array<Goomba3>();
		for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			goombas.add(new Goomba3(screen, (rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM));
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

		// ���̾� 10�� Point4 object
		for (MapObject object : map.getLayers().get(10).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DEAD4_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 17�� NPC6 object
		for (MapObject object : map.getLayers().get(17).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG10_BIT;
			body.createFixture(fdef);

		}

		// ���̾� 18�� NPC7 object
		for (MapObject object : map.getLayers().get(18).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();

			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM);

			body = world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2 / game.PPM, rect.getHeight() / 2 / game.PPM);

			fdef.shape = shape;
			fdef.filter.categoryBits = game.DIALOG11_BIT;
			body.createFixture(fdef);

		}

	}

	public Array<Goomba3> getGoombas() {
		return goombas;
	}

}
