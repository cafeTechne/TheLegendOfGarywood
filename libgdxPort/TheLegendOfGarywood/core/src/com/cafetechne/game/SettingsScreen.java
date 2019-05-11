package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;

import com.badlogic.gdx.Input.Keys;

public class SettingsScreen extends InputAdapter implements Screen {


    final TheLegendOfGarywood game;

    FitViewport viewport;

    private TextButton backButton;
    private Table table;
    private Stage stage;
    private Slider gameVolumeSlider, musicVolumeSlider;
    private Skin skin;
    private Label gameVolumeSliderLabel, musicVolumeSliderLabel, settingsScreenLabel;

    private int buttonToggleState = 1;
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
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Button Pressed");
                game.showStartScreen();
            }
        });

        backButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("backButton clicked!");
                game.showStartScreen();
            };
        });

        stage.addActor(table);



        stage.setKeyboardFocus(gameVolumeSlider);
        gameVolumeSliderLabel.addAction(Actions.forever(Actions.sequence(fadeIn(.5f),fadeOut(.5f))));

        stage.addListener(new InputListener() {
            public boolean keyDown (InputEvent event, int keycode) {
                if (keycode == Keys.DOWN  || keycode == Keys.S) {
                    if (buttonToggleState == 3) {
                        buttonToggleState = 1;
                    } else {
                        buttonToggleState++;
                    }
                    System.out.println(buttonToggleState);

                    if(buttonToggleState == 1){
                        gameVolumeSliderLabel.addAction(Actions.forever(Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        backButton.clearActions();
                        backButton.addAction(fadeIn(.5f));
                    }
                    if(buttonToggleState == 2){
                        musicVolumeSliderLabel.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        gameVolumeSliderLabel.clearActions();
                        gameVolumeSliderLabel.addAction(fadeIn(.5f));
                    }
                    if(buttonToggleState == 3){
                        backButton.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        musicVolumeSliderLabel.clearActions();
                        musicVolumeSliderLabel.addAction(fadeIn(.5f));
                    }
                }

                if (keycode == Input.Keys.UP || keycode == Keys.W) {
                    if (buttonToggleState == 1) {
                        buttonToggleState = 3;
                    } else {
                        buttonToggleState--;
                    }
                    System.out.println(buttonToggleState);


                    if(buttonToggleState == 1){
                        gameVolumeSliderLabel.addAction(Actions.forever(Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        musicVolumeSliderLabel.clearActions();
                        musicVolumeSliderLabel.addAction(fadeIn(.5f));
                    }
                    if(buttonToggleState == 2){
                        musicVolumeSliderLabel.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        backButton.clearActions();
                        backButton.addAction(fadeIn(.5f));
                    }
                    if(buttonToggleState == 3){
                        backButton.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(fadeIn(.5f),fadeOut(.5f))));
                        gameVolumeSliderLabel.clearActions();
                        gameVolumeSliderLabel.addAction(fadeIn(.5f));
                    }


                }

                if (keycode == Keys.RIGHT || keycode == Keys.D){
                    if(stage.getKeyboardFocus() == gameVolumeSlider){
                        float volumeValue = gameVolumeSlider.getValue();
                        gameVolumeSlider.setValue(volumeValue+5);
                        System.out.println(gameVolumeSlider.getValue());
                    }
                    if(stage.getKeyboardFocus() == musicVolumeSlider){
                        float volumeValue = musicVolumeSlider.getValue();
                        musicVolumeSlider.setValue(volumeValue+5);
                        System.out.println(musicVolumeSlider.getValue());
                    }
                }
                if (keycode == Keys.LEFT || keycode == Keys.A){
                    if(stage.getKeyboardFocus() == gameVolumeSlider){
                        float volumeValue = gameVolumeSlider.getValue();
                        gameVolumeSlider.setValue(volumeValue-5);
                        System.out.println(gameVolumeSlider.getValue());
                    }
                    if(stage.getKeyboardFocus() == musicVolumeSlider){
                        float volumeValue = musicVolumeSlider.getValue();
                        musicVolumeSlider.setValue(volumeValue-5);
                        System.out.println(musicVolumeSlider.getValue());
                    }
                }
                if (keycode == Keys.ENTER || keycode == Keys.SPACE){
                    if(stage.getKeyboardFocus() == backButton){
                        backButton.toggle();
                    }
                }

                switch (buttonToggleState) {
                    case 1:
                        stage.setKeyboardFocus(gameVolumeSlider);
                        break;
                    case 2:
                        stage.setKeyboardFocus(musicVolumeSlider);
                        break;
                    case 3:
                        //backButton.setChecked(true);
                        stage.setKeyboardFocus(backButton);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });

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
