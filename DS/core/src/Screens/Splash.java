package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import BackMusic.MusicPlayer;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class Splash implements Screen
{
	private Sprite splash;
	private Sprite splash2;
	private Sprite splash3;
	private SpriteBatch batch = new SpriteBatch();
	private TweenManager tweenManager = new TweenManager();
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Tween.registerAccessor(Sprite.class,  new SpriteAccessor());
		
		MusicPlayer.MainBackgMusic("Music/backsound.mp3");
		
		// 배경 생성s
		Texture splash_background = new Texture("imgs/splash_background.jpg");
		splash = new Sprite(splash_background);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// Double  생성 
		Texture splash_gamename1 = new Texture("imgs/GameName1.png");
		splash2 = new Sprite(splash_gamename1);
		splash2.setX(340);
		splash2.setY(406);
		Tween.set(splash2, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(splash2, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 2).start(tweenManager);//이미지 천천히 생성
		
		//  Sidedness 생성
		Texture splash_gamename2 = new Texture("imgs/GameName2.png");
		splash3 = new Sprite(splash_gamename2);
		splash3.setX(750);
		splash3.setY(415);
		Tween.set(splash3, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(splash3, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 1).delay(1).setCallback(new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		}).start(tweenManager);//이미지 천천히 생성
		
		
		/*
		splash4 = new Sprite(splash_start);
		splash4.setX(550);
		splash4.setY(200);
		Tween.set(stage, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(stage, SpriteAccessor.ALPHA, 2).target(1).delay(2).start(tweenManager);//이미지 천천히 생성
		
		splash5 = new Sprite(splash_exit);
		splash5.setX(550);
		splash5.setY(30);
		Tween.set(splash5, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(splash5, SpriteAccessor.ALPHA, 2).target(1).delay(2).start(tweenManager);//이미지 천천히 생성
		*/
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		batch.begin();
			splash.draw(batch);
			splash2.draw(batch);
			splash3.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		splash.getTexture().dispose();
		splash2.getTexture().dispose();
		splash3.getTexture().dispose();
	}

}
