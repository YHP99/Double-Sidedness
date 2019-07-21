package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.Splash;

public class MyGdxGame extends Game
{	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 208;
	public static final float PPM = 100;
	
	public static final short GM_BIT = 1;
	public static final short DEAD_BIT = 2;
	public static final short DEAD2_BIT = 4;
	public static final short DEAD3_BIT = 8;
	public static final short DEAD4_BIT = 16;
	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;
	public static final short DIALOG2_BIT = 128;
	public static final short DIALOG3_BIT = 256;
	public static final short DIALOG4_BIT = 512;
	public static final short DIALOG5_BIT = 1024;
	public static final short DIALOG7_BIT = 2048;
	public static final short DIALOG8_BIT = 4096;
	public static final short DIALOG10_BIT = 8192;
	public static final short DIALOG11_BIT = 16384;
	
	public SpriteBatch batch;
	
	private int snjData;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		setScreen(new Splash());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		// TODO Auto-generated method stub
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		// TODO Auto-generated method stub
		return super.getScreen();
	}
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}
}
