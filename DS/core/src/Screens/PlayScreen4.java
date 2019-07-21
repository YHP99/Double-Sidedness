package Screens;

import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.badlogic.gdx.Game;
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
import Sprite.Enemy4;
import Sprite.GM4;
import Tools.B2WorldCreator4;
import Tools.WorldContactListener4;

public class PlayScreen4 implements Screen {
	/* ���̾�α׹ڽ� */
	private int uiScale = 3; // ���̾�α׹ڽ� ũ������

	private AssetManager assetManager;
	private Skin skin;
	private Stage uiStage;
	private Table root;
	protected DialogueBox dialogueBox;
	ArrayList<String> m = new ArrayList<String>();
	private Ment ment = new Ment();
	int idx = 0;
	/*************************/
	private boolean is_last_stage = false;
	int count = 0;
	private MyGdxGame game;

	// private Hud hud;

	private TextureAtlas atlas;
	private TextureAtlas atlasEnemy; // ��, ��� �׽�Ʈ��

	private OrthographicCamera gamecam;
	private Viewport gamePort;

	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	private WorldContactListener4 world_contact;
	private World world;
	private Box2DDebugRenderer b2dr;
	private B2WorldCreator4 creator;

	private GM4 player;
	private SpriteBatch batch = new SpriteBatch();

	public PlayScreen4(MyGdxGame game, boolean is_first) {
		// ���� ���� �ҽ��ڵ�
		MusicPlayer.BackMusicStop();
		MusicPlayer.MainBackgMusic("Music/Stage4.mp3");

		atlas = new TextureAtlas("Texture/cutegirl.pack");
		// ������ �̹��� ��� �Ἥ �׽�Ʈ
		atlasEnemy = new TextureAtlas("Texture/jil.pack");

		this.game = game;

		gamecam = new OrthographicCamera(); // ĳ���͸� ����ٴϴ� ī�޶�
		gamePort = new FitViewport(game.WIDTH / game.PPM, game.HEIGHT / game.PPM, gamecam);
		// FitViewport�� ��ũ�� ������� ������� � ��� ������ ����ؼ� ����������

		// hud = new Hud(game.batch); // ���ھ�, �ð�, ���� �� ����

		maploader = new TmxMapLoader();
		map = maploader.load("Map/untitled.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / game.PPM);

		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

		world = new World(new Vector2(0, -10), true);
		b2dr = new Box2DDebugRenderer();

		creator = new B2WorldCreator4(this);

		player = new GM4(this);

		world_contact = new WorldContactListener4();
		world.setContactListener(world_contact);

		if (is_first == true) {
			m = ment.ment12();
			DialogBox(m.get(0));
		} else {
			m = ment.ment12();
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

	public void handleInput(float dt) { // �¿� ������, ���� ������ ����

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

		for (Enemy4 enemy : creator.getGoombas())
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
				
				if(is_last_stage)
				{
					((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				}
			}
		}

		if (world_contact.is_dialog) {
			if (world_contact.dialog == 11) {
				m = ment.ment13();
			}
			if (world_contact.dialog == 12) 
			{
				long time = System.currentTimeMillis(); 
		        SimpleDateFormat dayTime = new SimpleDateFormat("ddmmhhyyyy");
		        String clear_code = dayTime.format(new Date(time));
		      
		        try 
				{
				  Socket socket = new Socket("localhost", 3333);
				  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				  out.println(clear_code + "\n");
				  out.close();
				  socket.close();
				} 
		        catch (Exception e) {  System.out.println("client err:" + e); }

				m = ment.ment13_clear(clear_code);
				is_last_stage = true;
				
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

		// b2dr.SHAPE_STATIC.set(0,0,0,0); �� shape ���� ����
		b2dr.render(world, gamecam.combined);
		b2dr.setDrawBodies(false); // body�� �׸����� ���� false�� ������ �� �׸�

		batch.setProjectionMatrix(gamecam.combined);

		uiStage.act(delta); // ���̾�α� ����

		batch.begin();
		player.draw(batch);
		for (Enemy4 enemy : creator.getGoombas()) {
			enemy.draw(batch);
		}
		batch.end();

		uiStage.draw(); // ���̾�α� �׸���
		/*
		 * game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		 * hud.stage.draw();
		 */

	}

	public void DialogBox(String text) {
		/* ���̾�α� �ڽ� �κ� */
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
