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

import Screens.PlayScreen5;
import Sprite.Goomba5;

public class B2WorldCreator5 {
	private MyGdxGame game;
	private Array<Goomba5> goombas;

	public B2WorldCreator5(PlayScreen5 screen) {
		World world = screen.getWorld();
		TiledMap map = screen.getMap();

		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;

		// 맵 상에 존재하는 오브젝트 레이어, for() 괄호안에 map.getLayers().get()에서 get안에 들어갈 숫자는
		// map프로그램안에 있는 원하는 layer의 순서
		// 레이어 5번 전체적인 틀
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

		// 레이어 6번 Enemy object
		goombas = new Array<Goomba5>();
		for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			goombas.add(new Goomba5(screen, (rect.getX() + rect.getWidth() / 2) / game.PPM,
					(rect.getY() + rect.getHeight() / 2) / game.PPM));
		}

		// 레이어 10번 Point4 object
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

		// 레이어 17번 NPC6 object
		for (MapObject object : map.getLayers().get(17).getObjects().getByType(RectangleMapObject.class)) {
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

	public Array<Goomba5> getGoombas() {
		return goombas;
	}

}
