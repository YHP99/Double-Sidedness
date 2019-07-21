package Screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.dialog.DialogueBox;
import com.mygdx.dialog.Ment;
import com.mygdx.game.MyGdxGame;
import com.mygdx.util.SkinGenerator;

import BackMusic.MusicPlayer;
import Sprite.Enemy2;
import Sprite.GM2;
import Tools.B2WorldCreator2;
import Tools.WorldContactListener2;

public class PlayScreen2 implements Screen {
	/* 다이얼로그박스 */
	private int uiScale = 3; // 다이얼로그박스 크기조절

	private AssetManager assetManager;
	private Skin skin;
	private Stage uiStage;
	private Table root;
	protected DialogueBox dialogueBox;
	ArrayList<String> m = new ArrayList<String>();
	private Ment ment = new Ment();
	int idx = 0;
	/*************************/

	int count = 0;
	private MyGdxGame game;

	// private Hud hud;

	private TextureAtlas atlas;
	private TextureAtlas atlasEnemy; // 적, 잠깐 테스트용

	private OrthographicCamera gamecam;
	private Viewport gamePort;

	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	private WorldContactListener2 world_contact;
	private World world;
	private Box2DDebugRenderer b2dr;
	private B2WorldCreator2 creator;

	private GM2 player;
	private SpriteBatch batch = new SpriteBatch();

	public PlayScreen2(MyGdxGame game, boolean is_first) {
		// 사운드 관련 소스코드
		MusicPlayer.BackMusicStop();
		MusicPlayer.MainBackgMusic("Music/Stage2.mp3");
		
		atlas = new TextureAtlas("Texture/cutegirl.pack");
		// 마리오 이미지 잠깐 써서 테스트
		atlasEnemy = new TextureAtlas("Texture/jil.pack");

		this.game = game;

		gamecam = new OrthographicCamera(); // 캐릭터를 따라다니는 카메라
		gamePort = new FitViewport(game.WIDTH / game.PPM, game.HEIGHT / game.PPM, gamecam);
		// FitViewport는 스크린 사이즈와 관계없이 어떤 양상 비율을 계속해서 유지시켜줌

		// hud = new Hud(game.batch); // 스코어, 시간, 레벨 등 정보

		maploader = new TmxMapLoader();
		map = maploader.load("Map/untitled.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / game.PPM);

		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

		world = new World(new Vector2(0, -10), true);
		b2dr = new Box2DDebugRenderer();

		creator = new B2WorldCreator2(this);

		player = new GM2(this);

		world_contact = new WorldContactListener2();
		world.setContactListener(world_contact);

		if (is_first == true) {
			m = ment.ment6();
			DialogBox(m.get(0));
		} else {
			m = ment.ment6();
			DialogBox(m.get(0));
			dialogueBox.setVisible(false);
		}

	}

	public TextureAtlas getAtlas() {
		return atlas;
	}

	public TextureAtlas EnemyAtlas() {
		return atlasEnemy;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	public void handleInput(float dt) { // 좌우 움직임, 점프 움직임 구현

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
			player.gmbody.applyLinearImpulse(new Vector2(0, 3f), player.gmbody.getWorldCenter(), true);

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.gmbody.getLinearVelocity().x <= 1)
			player.gmbody.applyLinearImpulse(new Vector2(0.05f, 0), player.gmbody.getWorldCenter(), true);

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.gmbody.getLinearVelocity().x >= -1)
			player.gmbody.applyLinearImpulse(new Vector2(-0.05f, 0), player.gmbody.getWorldCenter(), true);

	}

	public void update(float dt) {
		handleInput(dt);

		world.step(1 / 60f, 6, 2);

		player.update(dt);

		for (Enemy2 enemy : creator.getGoombas())
			enemy.update(dt);

		gamecam.position.x = player.gmbody.getPosition().x;

		gamecam.update();
		renderer.setView(gamecam);

		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			idx++;
			if (idx < m.size()) {
				dialogueBox.animateText(m.get(idx));
				dialogueBox.setVisible(true);
			} else {
				idx = 0;
				dialogueBox.setVisible(false);
			}
		}

		if (world_contact.is_dialog) {
			if (world_contact.dialog == 7) {
				m = ment.ment7();
			}
			if (world_contact.dialog == 8) {
				m = ment.ment8();
			}

			dialogueBox.animateText(m.get(0));
			dialogueBox.setVisible(true);

			world_contact.is_dialog = false;
		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render();

		// b2dr.SHAPE_STATIC.set(0,0,0,0); 맵 shape 색깔 지정
		b2dr.render(world, gamecam.combined);
		b2dr.setDrawBodies(false); // body를 그리는지 여부 false로 지정시 안 그림

		batch.setProjectionMatrix(gamecam.combined);

		uiStage.act(delta); // 다이얼로그 액터

		batch.begin();
		player.draw(batch);
		for (Enemy2 enemy : creator.getGoombas()) {
			enemy.draw(batch);
		}
		batch.end();

		uiStage.draw(); // 다이얼로그 그리기
		/*
		 * game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		 * hud.stage.draw();
		 */
	}

	public void DialogBox(String text) {
		/* 다이얼로그 박스 부분 */
		assetManager = new AssetManager();
		assetManager.load("res/packed/uipack.atlas", TextureAtlas.class);
		assetManager.finishLoading();

		skin = SkinGenerator.generateSkin(assetManager);

		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale);

		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);

		dialogueBox = new DialogueBox(skin);
		dialogueBox.setVisible(true);
		dialogueBox.animateText(text);

		Table dialogTable = new Table();

		dialogTable.add(dialogueBox).expand().align(Align.right).space(8f).row();
		root.add(dialogTable).expand().align(Align.bottom);
	}

	@Override
	public void resize(int width, int height) {
		uiStage.getViewport().update(width / uiScale, height / uiScale, true);
		gamePort.update(width, height);
	}

	public TiledMap getMap() {
		return map;
	}

	public World getWorld() {
		return world;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		world.dispose();
		b2dr.dispose();
		// hud.dispose();

	}

}
