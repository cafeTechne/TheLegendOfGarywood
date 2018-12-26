package com.cafetechne.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TheLegendOfGarywood extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		showStartScreen();
	}


	public void showStartScreen(){
		setScreen(new StartScreen(this));
	}

	public void showNewGameScreen(){
		setScreen(new StartScreen(this));
	}

	public void showContinueScreen(){
		setScreen(new StartScreen(this));
	}

	public void showStartOptionsScreen(){
		setScreen(new StartScreen(this));
	}


}
