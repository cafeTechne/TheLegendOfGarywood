package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

public class SettingsScreen extends InputAdapter implements Screen {


    final TheLegendOfGarywood game;

    FitViewport viewport;

    private TextButton backButton;
    private Table table;
    private Stage stage;
    private Slider gameVolumeSlider, musicVolumeSlider;
    private Skin skin;
    private Label gameVolumeSliderLabel, musicVolumeSliderLabel, settingsScreenLabel;

    //Texture gameTitleTex = new Texture (Gdx.files.internal("data/gameTitle.png"));


    public SettingsScreen(final TheLegendOfGarywood game){
        this.game = game;
    }


    @Override
    public void show() {

        //setup a FitViewport with the constant appropriate for this screen
        viewport = new FitViewport(Constants.START_SCREEN_WORLD_SIZE, Constants.START_SCREEN_WORLD_SIZE);

        //initialize the stage object
        stage = new Stage(viewport);

        //initialize the skin
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));

        Gdx.input.setInputProcessor(this);


        //game.font.draw(game.spriteBatch, "This is some text--test!", 100, 150);



        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
        tbs.font = game.font;

        backButton = new TextButton("Back", tbs);

        gameVolumeSlider = new Slider(0f, 100f, 1f, false, skin);

        //sets the volume slider's default value to 50
        gameVolumeSlider.setValue(50f);

        musicVolumeSlider = new Slider(0f, 100f, 1f, false, skin);

        //sets the volume slider's default value to 50
        musicVolumeSlider.setValue(50f);


        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.font;

        gameVolumeSliderLabel = new Label("Game Volume", ls);
        musicVolumeSliderLabel = new Label("Music Volume", ls);
        settingsScreenLabel = new Label("Settings", ls);

        table = new Table();

        table.add(settingsScreenLabel).colspan(2).padBottom(50f);
        table.row().padTop(25f);
        //text that says SETTINGS as a header

        //TODO: Option to change color of menus
        //TODO: Option to load different text?
        //TODO: Option for different text sizes?
        table.add(gameVolumeSliderLabel).padRight(25f).left();
        table.add(gameVolumeSlider);
        //slider
        table.row().padTop(25f);
        table.add(musicVolumeSliderLabel).padRight(25f).left();
        table.add(musicVolumeSlider);

        table.row();
        table.add(backButton).padTop(50f).colspan(2);

        //sizing the table to the stage
        table.setFillParent(true);

        //packing our structural components to fit the size of the stage
        table.pack();

        //fade in animation for the table
        table.getColor().a = 0f;
        table.addAction(fadeIn(2f));


        Gdx.input.setInputProcessor(stage);

        //TODO: Set up the logic to change the game music
        musicVolumeSlider.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.app.log(TAG, "slider changed to: " + slider.getValue());
                System.out.println("" + musicVolumeSlider.getValue());
                // Set volume to slider.getValue();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            };
        });

        //TODO: Set up logic to change the game sounds
        gameVolumeSlider.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.app.log(TAG, "slider changed to: " + slider.getValue());
                System.out.println("" + gameVolumeSlider.getValue());
                // Set volume to slider.getValue();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            };
        });

        // back button listener
        backButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("backButton clicked!");
                game.showStartScreen();
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

    }

    @Override
    public void dispose() {
        stage.dispose();
    }



}
