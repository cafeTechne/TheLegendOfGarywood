package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;

public class ContinueScreen extends InputAdapter implements Screen {


    final TheLegendOfGarywood game;

    private Stage stage;

    private Skin skin;

    private Table table;

    FitViewport viewport;

    private TextButton backButton;

    private Label continuePageLabel;

    private int buttonToggleState = 1;

    public ContinueScreen(TheLegendOfGarywood game){
        this.game = game;
    }

    //hesitant to use Stage because this class will rely on Serialization, but we're not there yet... this is just a UI for the most part as of now



    @Override
    public void show() {
        //setup a FitViewport with the constant appropriate for this screen
        viewport = new FitViewport(Constants.START_SCREEN_WORLD_SIZE, Constants.START_SCREEN_WORLD_SIZE);
        //initialize the stage object
        stage = new Stage(viewport);
        //initialize the skin
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        table = new Table();

        Gdx.input.setInputProcessor(this);

        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.font;
        continuePageLabel = new Label("Continue", ls);


        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
        tbs.font = game.font;
        backButton = new TextButton("Back", tbs);

        table.add(continuePageLabel).padBottom((.1f * viewport.getScreenHeight()));
        table.row();
        table.add(backButton);

        //sizing the table to the stage
        table.setFillParent(true);
        //packing our structural components to fit the size of the stage
        table.pack();
        //fade in animation for the table
        table.getColor().a = 0f;
        table.addAction(fadeIn(2f));



        Gdx.input.setInputProcessor(stage);

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

        //this is an easy way to draw text to the screen
        //game.font.draw(game.spriteBatch, "This is some text--test!", 100, 150);


        //TODO: Make a cursor indicator
        //TODO: Make current selected text blink?
        //TODO: Up & Down + ENTER or SPACE_BAR choose the appropriate item


        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        stage.setKeyboardFocus(backButton);
        backButton.addAction(Actions.forever(Actions.sequence(fadeIn(.5f),fadeOut(.5f))));

        stage.addListener(new InputListener() {
            public boolean keyDown (InputEvent event, int keycode) {
                //only 1 button right now...
                if (keycode == Input.Keys.DOWN  || keycode == Input.Keys.S) {
                    if (buttonToggleState == 1 ) {//4, etc. however many buttons there are, set the limit here
                        buttonToggleState = 1;
                    } else {
                        buttonToggleState++;
                    }
                    System.out.println(buttonToggleState);

                    if(buttonToggleState == 1){
                        backButton.addAction(Actions.forever(Actions.sequence(fadeIn(.25f),fadeOut(.25f))));
                    }
                }

                if (keycode == Input.Keys.UP || keycode == Input.Keys.W) {
                    if (buttonToggleState == 1) {
                        buttonToggleState = 1; //4, etc. however many buttons there are, set the limit here
                    } else {
                        buttonToggleState--;
                    }
                    System.out.println(buttonToggleState);

                    if(buttonToggleState == 1){
                        backButton.addAction(Actions.forever(Actions.sequence(fadeIn(.25f),fadeOut(.25f))));
                    }
                }

                System.out.println(stage.getKeyboardFocus());
                if (keycode == Input.Keys.ENTER || keycode == Input.Keys.SPACE){
                    if(buttonToggleState == 1){
                        game.setScreen(new StartScreen(game));
                    }
                    /* set these for the other choices, etc.
                    else if(buttonToggleState == 2){
                        game.setScreen(new ContinueScreen(game));
                    }
                    else if(buttonToggleState == 3){
                        game.setScreen(new SettingsScreen(game));
                    }
                    else if(buttonToggleState == 4){
                        Gdx.app.exit();
                    }
                    */
                }

                switch (buttonToggleState) {
                    case 1:
                        stage.setKeyboardFocus(backButton);
                        break;
                    /* set these to the other button possibilities
                        case 2:
                        stage.setKeyboardFocus(continueButton);
                        break;
                    case 3:
                        stage.setKeyboardFocus(settingsButton);
                        break;
                    case 4:
                        stage.setKeyboardFocus(exitButton);
                        break;
                        */
                    default:
                        break;
                }

                return true;
            }
        });



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
        //uncommenting these causes game to crash when navigating between continueScreen and startScreen
        //skin.dispose();
        //stage.dispose();
    }

    @Override
    public void dispose() {

    }
}
