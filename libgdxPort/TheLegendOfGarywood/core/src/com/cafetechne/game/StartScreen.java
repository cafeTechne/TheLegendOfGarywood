package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class StartScreen extends InputAdapter implements Screen {

    //with a reference to the game object we don't need to reinstantiate resources!
    final TheLegendOfGarywood game;

    FitViewport viewport;


    public StartScreen(final TheLegendOfGarywood game){
        this.game = game;
    }


    @Override
    public void show() {

        //setup a FitViewport with the constant appropriate for this screen
        viewport = new FitViewport(Constants.START_SCREEN_WORLD_SIZE, Constants.START_SCREEN_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        //TODO: apply styling with scene2d.ui
        game.assets.load("skins/uiskin.json", Skin.class);
        game.assets.load("icons/icons.atlas", TextureAtlas.class);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        //this is an easier way to draw text to the screen than the method directly below this
        game.font.draw(game.spriteBatch, "This is some text--test!", 100, 150);


        final GlyphLayout newGameLayout = new GlyphLayout(game.font, Constants.NEWGAME_LABEL);
        game.font.draw(game.spriteBatch, Constants.NEWGAME_LABEL, Constants.NEWGAME_CENTER.x, Constants.NEWGAME_CENTER.y + newGameLayout.height / 2, 0, Align.center, false);

        final GlyphLayout continueLayout = new GlyphLayout(game.font, Constants.CONTINUE_LABEL);
        game.font.draw(game.spriteBatch, Constants.CONTINUE_LABEL, Constants.CONTINUE_CENTER.x, Constants.CONTINUE_CENTER.y + continueLayout.height / 2, 0, Align.center, false);

        final GlyphLayout optionsLayout = new GlyphLayout(game.font, Constants.OPTIONS_LABEL);
        game.font.draw(game.spriteBatch, Constants.OPTIONS_LABEL, Constants.OPTIONS_CENTER.x, Constants.OPTIONS_CENTER.y + optionsLayout.height / 2, 0, Align.center, false);


        game.spriteBatch.end();
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

        //game.spriteBatch.dispose();
        //game.font.dispose();

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));


        /*This way of setting up buttons is just unsustainable... getting into scene2d.ui to do it the real way */
        //TODO: set for the coordinates/region of the button to be pressed--this needs TLC based on design
        if (worldTouch.dst(Constants.NEWGAME_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            //game.showNewGameScreen();
            System.out.println("Touched the newgame button");
        }

        if (worldTouch.dst(Constants.CONTINUE_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            //game.showContinueScreen();
            System.out.println("Touched the continue button");
        }

        if (worldTouch.dst(Constants.OPTIONS_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            //game.showStartOptionsScreen();
            System.out.println("Touched the options button");
        }

        return true;
    }

}
