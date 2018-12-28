package com.cafetechne.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class GameScreen implements Screen {

    final TheLegendOfGarywood game;

    //not implemented but just an example... although should we use the AssetManager?
    //see: https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/assets/AssetManager.html
    Texture mainCharacterSprite;

    Sound swordSwingSound;

    Music gameMusic;

    ExtendViewport viewport;

    int goldCollected;

    Rectangle mainCharacterHitBox;


    public GameScreen(final TheLegendOfGarywood game){

        this.game = game;

        //how we set up sound
        swordSwingSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        gameMusic.setLooping(true);


        //This code is from the documentation but isn't it better to use the viewport class?

        // create the camera and the SpriteBatch
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 800, 480);

        // create a Rectangle to logically represent the bucket
        mainCharacterHitBox = new Rectangle();
        mainCharacterHitBox.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        mainCharacterHitBox.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        mainCharacterHitBox.width = 64;
        mainCharacterHitBox.height = 64;




    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        gameMusic.play();
    }

    @Override
    public void render(float delta) {

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //do we need to do this or is it automagically done?
        viewport.getCamera().update();


        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(viewport.getCamera().combined);


        //TODO: need a way to pull room data here and then use it to populate objects in the view

        // begin a new batch and draw the mainCharacter and
        // all enemies/objects/etc.
        game.font.draw(game.batch, "Gold: " + goldCollected, 0, 480);
        game.batch.draw(mainCharacterSprite, mainCharacterHitBox.x, mainCharacterHitBox.y, mainCharacterHitBox.width, mainCharacterHitBox.height);


        game.batch.end();

        //TODO: Meaningfully process input
/*
        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = touchPos.x - 64 / 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > 800 - 64)
            bucket.x = 800 - 64;

  */
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mainCharacterSprite.dispose();

        swordSwingSound.dispose();
        gameMusic.dispose();
    }
}
