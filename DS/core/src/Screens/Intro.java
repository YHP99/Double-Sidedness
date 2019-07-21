package Screens;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.dialog.DialogueBox;
import com.mygdx.dialog.Ment;
import com.mygdx.game.MyGdxGame;
import com.mygdx.util.SkinGenerator;

public class Intro implements Screen 
{
	/*다이얼로그박스 */
	private int uiScale = 3;	// 다이얼로그박스 크기조절
	
	private AssetManager assetManager;
	private Skin skin;
	private Stage uiStage;
	private Table root;
	protected DialogueBox dialogueBox;
	ArrayList<String> m = new ArrayList<String>();
	private Ment ment = new Ment();
	int idx = 0;
	private Viewport gameViewport;
	/*************************/
	
	private SpriteBatch batch = new SpriteBatch();
	
	public Intro(MyGdxGame game)
	{
		gameViewport = new ScreenViewport();
		
		m = ment.intro();
		DialogBox(m.get(0));
		dialogueBox.setVisible(true);
	}
	public void show() 
	{
		
	}
	public void update(float dt) 
	{
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
		{
			idx++;
			if(idx < m.size())
			{
				dialogueBox.animateText(m.get(idx));
				dialogueBox.setVisible(true);
			}
			else
			{
				idx=0;
				dialogueBox.setVisible(false);
				((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen(null, true));
			}
		}
	}
	@Override
	public void render(float delta) 
	{
		update(delta);
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		uiStage.act(delta); //다이얼로그 액터
		
		gameViewport.apply();
		
		batch.begin();
		batch.end();
		
		uiStage.draw();  //다이얼로그 그리기
	}

	public void DialogBox(String text)
	{
		/*다이얼로그 박스 부분*/
		assetManager = new AssetManager();
		assetManager.load("res/packed/uipack.atlas", TextureAtlas.class);
		assetManager.finishLoading();
		
		skin = SkinGenerator.generateSkin(assetManager);
		
		uiStage = new Stage(new ScreenViewport());
		uiStage.getViewport().update(Gdx.graphics.getWidth()/uiScale, Gdx.graphics.getHeight()/uiScale);
		
		root = new Table();
		root.setFillParent(true);
		uiStage.addActor(root);
		
		dialogueBox = new DialogueBox(skin);
		dialogueBox.setVisible(true);
		dialogueBox.animateText(text);
		
		Table dialogTable = new Table();
		
		dialogTable.add(dialogueBox)
						.expand()
						.align(Align.right)
						.space(8f)
						.row();
		root.add(dialogTable).expand().align(Align.center);
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		uiStage.getViewport().update(width/uiScale, height/uiScale, true);
		gameViewport.update(width, height);
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
		// TODO Auto-generated method stub
		batch.dispose();
		
	}
}