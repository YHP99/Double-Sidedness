package Screens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class MainMenu implements Screen, TextInputListener
{
	String text;
	private TweenManager tweenManager = new TweenManager();
	
	private Sprite splash;
	private Sprite splash2;
	private SpriteBatch batch = new SpriteBatch();
	
	private Stage stage;
	private Table table;
	
	public boolean is_textbox = false;
	public boolean is_final = false;
	
	public void show() {
		// TODO Auto-generated method stub
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		table = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-350);
		
		// 메인메뉴 배경
		Texture splash_background = new Texture("imgs/mainmenu_background.jpg");
		splash = new Sprite(splash_background);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// 타이틀 생성
		Texture splash_title = new Texture("imgs/Title.png");
		splash2 = new Sprite(splash_title);
		splash2.setX(310);
		splash2.setY(550);
		
		//start 생성
		Texture splash_start = new Texture("imgs/Start.png");
		Drawable start_drawable = new TextureRegionDrawable(new TextureRegion(splash_start));
		ImageButton btn_start = new ImageButton(start_drawable); 
		btn_start.addListener(new ClickListener() 
		{
			public void clicked(InputEvent event, float x, float y) { ((Game) Gdx.app.getApplicationListener()).setScreen(new Intro(null)); }
		});
		
		//code 생성
		Texture splash_code = new Texture("imgs/code.png");
		Drawable code_drawable = new TextureRegionDrawable(new TextureRegion(splash_code));
		ImageButton btn_code = new ImageButton(code_drawable); 
		btn_code.addListener(new ClickListener() 
		{
			public void clicked(InputEvent event, float x, float y) { 
				is_textbox = true;
			}
		});
		
		//Exit 생성
		Texture splash_exit = new Texture("imgs/Exit.png");
		Drawable exit_drawable = new TextureRegionDrawable(new TextureRegion(splash_exit));
		ImageButton btn_exit = new ImageButton(exit_drawable); 
		btn_exit.addListener(new ClickListener() 
		{
			public void clicked(InputEvent event, float x, float y) { Gdx.app.exit(); }
		});
		
		
		table.add(btn_start);
		table.row();
		table.add(btn_exit);
		table.row();
		table.add(btn_code);
		
		stage.addActor(table);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		if(is_textbox)
		{
			if(Gdx.input.justTouched())
			{
				Gdx.input.getTextInput(this, "Clear Code", null, null);
			}
		}
		
		batch.begin();
			splash.draw(batch);
			splash2.draw(batch);
		batch.end();
		
		stage.act(delta);
		stage.draw();
		
		if(is_final)
		{
			((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen5(null, true));
		}
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
		splash.getTexture().dispose();
		batch.dispose();
		
	}

	@Override
	public void input(String text) {
        // DB 다루는 부분
        String serverURL = "jdbc:mysql://localhost/ds";
        String id = "root"; String pw = "root";
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");         
            Connection con = DriverManager.getConnection(serverURL, id, pw);

            String query = "select code from clear where code='"+text+"'";
            java.sql.PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	this.text = rs.getString("code");
            	if(!rs.getString("code").isEmpty())
                {
                	is_final = true;
                }
                else
                {
                	break;
                }
            }
        } 
        catch (ClassNotFoundException e) { System.out.println("드라이버가 존재하지 않습니다"); this.text="error2"; } 
        catch (SQLException e) { e.printStackTrace(); this.text="error"; }
	}

	@Override
	public void canceled() {
		text = "Cancelled";
	}
}
