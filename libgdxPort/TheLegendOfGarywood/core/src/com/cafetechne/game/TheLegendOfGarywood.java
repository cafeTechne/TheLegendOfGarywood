package com.cafetechne.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Logger;
import com.cafetechne.game.inventory.InventoryScreen;


import java.util.Random;

public class TheLegendOfGarywood extends Game {


    public static final Game game = new Game() {

        @Override
        public void create() {
    //        setScreen(new SplashScreen(this));
        }
    };

    public static final Random random = new Random();

    public Texture img;

    //freetype font declaration
    public static FreeTypeFontGenerator fontGenerator;
    public static FreeTypeFontGenerator.FreeTypeFontParameter textParameter;
    public static BitmapFont font;


	public static final Logger logger = new Logger("LibGDX Utils");

	public static final AssetManager assets = new AssetManager();

	public static SpriteBatch spriteBatch;

	public static ModelBatch modelBatch;

    public static TextureAtlas icons;

    Music gameMusic;


    @Override
	public void create () {
			try {


				logger.setLevel(Logger.DEBUG);
				Gdx.app.setLogLevel(Application.LOG_DEBUG);

				Texture.setAssetManager(assets);

				spriteBatch = new SpriteBatch();
				modelBatch = new ModelBatch();

                icons = new TextureAtlas(new FileHandle("icons/icons.atlas"));

                fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P-Regular.ttf"));
                textParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

                textParameter.size = 18;
                font = fontGenerator.generateFont(textParameter);

                setScreen(new SplashScreen(this));


                //gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music/rain.mp3"));
                //gameMusic.setLooping(true);

                //normally we will start the startScreen first, but here we are testing the inventory screen as of now

                //showInventoryScreen();

                //setScreen(new SplashScreen());
                //showStartScreen();



               //setScreen(new SplashScreen());



			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				Gdx.app.exit();
			}
	}


	public void showStartScreen(){
		setScreen(new StartScreen(this));
	}

	public void showNewGameScreen(){
        this.setScreen(new StartScreen(this));
	}

	//TODO: Clean up the Inventory Screen UI and make it function with game mechanics
    public void showInventoryScreen() {
        this.setScreen(new InventoryScreen());
    }

   //TODO: Make a Continue Screen and game save mechanics
    /*
	public void showContinueScreen(){
        this.setScreen(new ContinueScreen(this));
	}
    */

	//TODO: Make a Settings Screen w/ appropriate start options

	public void showSettingsScreen(){
        //this.setScreen(new SettingsScreen(this));
	}


	public void render(){
	    super.render();
    }

    public void dispose(){
	    spriteBatch.dispose();

	    //when running from commandline using ./gradlew :desktop:run , the assets must be in the Android folder
        //otherwise the play button at the top of android studio is set to the core file folder...
	    font.dispose();
        fontGenerator.dispose(); // don't forget to dispose to avoid memory leaks!

    }

}
