package com.cafetechne.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TheLegendOfGarywood extends Game {
	public SpriteBatch batch;
    public Texture img;
    public BitmapFont font;

    @Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		//when we leave this blank we use the default Arial Font
		font = new BitmapFont();
		showStartScreen();

	}


	public void showStartScreen(){
		this.setScreen(new StartScreen(this));
	}

	public void showNewGameScreen(){
        this.setScreen(new StartScreen(this));
	}

	public void showContinueScreen(){
        this.setScreen(new StartScreen(this));
	}

	public void showStartOptionsScreen(){
        this.setScreen(new StartScreen(this));
	}

	public void render(){
	    super.render();
    }

    public void dispose(){
	    batch.dispose();
	    font.dispose();
    }

}
