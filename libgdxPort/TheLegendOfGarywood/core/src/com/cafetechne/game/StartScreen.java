package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

public class StartScreen extends InputAdapter implements Screen {

    //with a reference to the game object we don't need to reinstantiate resources!
    final TheLegendOfGarywood game;

    FitViewport viewport;

    private TextButton continueButton, newGameButton, settingsButton, exitButton;
    private Table table;
    private Stage stage;

//    Texture gameTitleTex = new Texture (Gdx.files.internal("data/gameTitle.png"));


    public StartScreen(final TheLegendOfGarywood game){
        this.game = game;
    }


    @Override
    public void show() {



        //setup a FitViewport with the constant appropriate for this screen
        viewport = new FitViewport(Constants.START_SCREEN_WORLD_SIZE, Constants.START_SCREEN_WORLD_SIZE);

        //initialize the stage object
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(this);

        //TODO: apply styling with scene2d.ui
        game.assets.load("skins/uiskin.json", Skin.class);
        game.assets.load("icons/icons.atlas", TextureAtlas.class);

        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
        tbs.font = game.font;

        newGameButton = new TextButton("New Game", tbs);
        continueButton = new TextButton("Continue", tbs);

        settingsButton = new TextButton("Settings", tbs);
        exitButton = new TextButton("Exit", tbs);

        table = new Table();

        table.row();
        //table.add(gameTitle).padTop(30f).colspan(2).expand();
        table.add(newGameButton).padTop(10f).colspan(2);
        table.row();
        table.add(continueButton).padTop(10f).colspan(2);
        table.row();
        table.add(settingsButton).padTop(10f).colspan(2);
        table.row();
        table.add(exitButton).padTop(10f).colspan(2);

        //sizing the table to the stage
        table.setFillParent(true);

        //packing our structural components to fit the size of the stage
        table.pack();

        //fade in animation for the table
        table.getColor().a = 0f;
        table.addAction(fadeIn(2f));


        Gdx.input.setInputProcessor(stage);

        // new game button listener
        newGameButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.log(TAG, "PLAY");
                System.out.println("PlayButton clicked!");
            };
        });
        // continue button listener
        continueButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ContinueScreen(game));
                System.out.println("continue clicked!");
            };
        });
        // settings button listener
        settingsButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.log(TAG, "PLAY");
                System.out.println("settings button clicked!");
                //game.showSettingsScreen();
                game.setScreen(new SettingsScreen(game));
            };
        });
        // exit button listener
        exitButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("exit clicked!");
                Gdx.app.exit();
            };
        });

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        //this is an easy way to draw text to the screen
        //game.font.draw(game.spriteBatch, "This is some text--test!", 100, 150);


        //TODO: Make a cursor indicator
        //TODO: Make current selected text blink?
        //TODO: Up & Down + ENTER or SPACE_BAR choose the appropriate item


        game.spriteBatch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        //when i comment these out, the game stops crashing:
        //going back to a previously hidden scene will show the fonts and buttons missing...
        //game.spriteBatch.dispose();
        //game.font.dispose();
        stage.dispose();
    }

    @Override
    public void dispose() {

    }



}
