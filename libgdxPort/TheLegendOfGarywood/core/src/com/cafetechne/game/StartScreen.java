package com.cafetechne.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class StartScreen extends InputAdapter implements Screen {


    TheLegendOfGarywood game;

    SpriteBatch batch;
    FitViewport viewport;

    BitmapFont font;

    public StartScreen(TheLegendOfGarywood game){
        this.game = game;
    }


    @Override
    public void show() {

        batch = new SpriteBatch();

        //setup a FitViewport with the constant appropriate for this screen
        viewport = new FitViewport(Constants.START_SCREEN_WORLD_SIZE, Constants.START_SCREEN_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        font = new BitmapFont();
        font.getData().setScale(Constants.START_SCREEN_LABEL_SCALE);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();

        final GlyphLayout newGameLayout = new GlyphLayout(font, Constants.NEWGAME_LABEL);
        font.draw(batch, Constants.NEWGAME_LABEL, Constants.NEWGAME_CENTER.x, Constants.NEWGAME_CENTER.y + newGameLayout.height / 2, 0, Align.center, false);

        final GlyphLayout continueLayout = new GlyphLayout(font, Constants.CONTINUE_LABEL);
        font.draw(batch, Constants.CONTINUE_LABEL, Constants.CONTINUE_CENTER.x, Constants.CONTINUE_CENTER.y + continueLayout.height / 2, 0, Align.center, false);

        final GlyphLayout optionsLayout = new GlyphLayout(font, Constants.OPTIONS_LABEL);
        font.draw(batch, Constants.OPTIONS_LABEL, Constants.OPTIONS_CENTER.x, Constants.OPTIONS_CENTER.y + optionsLayout.height / 2, 0, Align.center, false);


        batch.end();
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
        batch.dispose();
        font.dispose();

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

        //TODO: set for the coordinates/region of the button to be pressed--this needs TLC based on design
        if (worldTouch.dst(Constants.NEWGAME_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            game.showNewGameScreen();
        }

        if (worldTouch.dst(Constants.CONTINUE_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            game.showContinueScreen();
        }

        if (worldTouch.dst(Constants.OPTIONS_CENTER) < Constants.START_SCREEN_BUTTON_RADIUS) {
            game.showStartOptionsScreen();
        }

        return true;
    }

}
