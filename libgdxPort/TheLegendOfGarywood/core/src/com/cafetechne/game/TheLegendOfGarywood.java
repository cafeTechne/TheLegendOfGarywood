package com.cafetechne.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Logger;
import com.cafetechne.game.inventory.InventoryScreen;
import com.cafetechne.game.inventory.SlotSource;

import java.util.Random;

public class TheLegendOfGarywood extends Game {


    public static final Game game = new Game() {

        @Override
        public void create() {
            setScreen(new SplashScreen());
        }
    };




    public Texture img;

    public BitmapFont font;

	public static final Logger logger = new Logger("LibGDX Utils");

	public static final AssetManager assets = new AssetManager();

	public static final Random random = new Random();

	public static SpriteBatch spriteBatch;

	public static ModelBatch modelBatch;

    public static TextureAtlas icons;

    //com.cafetechne.game.TheLegendOfGarywood.assets.get("icons/icons.atlas", TextureAtlas.class);

    //TextureRegion icon = icons.findRegion(SlotSource.payloadSlot.getItem().getTextureRegion());


		@Override
	public void create () {
			try {
				logger.setLevel(Logger.DEBUG);
				Gdx.app.setLogLevel(Application.LOG_DEBUG);

				Texture.setAssetManager(assets);

				spriteBatch = new SpriteBatch();
				modelBatch = new ModelBatch();

                icons = new TextureAtlas(new FileHandle("icons/icons.atlas"));

                //batch = new SpriteBatch();
                //img = new Texture("badlogic.jpg");
                //when we leave this blank we use the default Arial Font
                font = new BitmapFont();

                //normally we will start the startScreen first, but here we are testing the inventory screen as of now


                showInventoryScreen();

                //this works but there is no way set up to break out of it as of yet...
               // showStartScreen();

                //working once more
               //setScreen(new SplashScreen());



			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				Gdx.app.exit();
			}
	}


	public void showStartScreen(){
		this.setScreen(new StartScreen(this));
	}

	public void showNewGameScreen(){
        this.setScreen(new StartScreen(this));
	}

    public void showInventoryScreen(){
        this.setScreen(new InventoryScreen());
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
	    spriteBatch.dispose();
	    font.dispose();
    }

}
