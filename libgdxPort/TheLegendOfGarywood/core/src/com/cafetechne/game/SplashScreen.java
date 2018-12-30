package com.cafetechne.game;

/* Copyright (c) 2014 PixelScientists
 *
 * The MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * This is the very first {@link Screen} which is shown when the game starts. It
 * loads the most common resources and displays a splash image for a couple of
 * seconds. The most common resources are the ones needed for the main menu,
 * lobby and options screen.
 *
 * @author Original: Daniel Holderbaum, Adapted by: cafeTechne
 */

public class SplashScreen implements Screen {

    private float minimumShowTime = 3.0f;

    private OrthographicCamera camera;

    private Viewport viewport;

    private Texture splash;

    private TheLegendOfGarywood game;

    public SplashScreen(TheLegendOfGarywood game){
        this.game = game;
    }


    @Override
    public void show() {
        //TODO: Replace the splash.png
        TheLegendOfGarywood.assets.load("textures/splash.png", Texture.class);
        TheLegendOfGarywood.assets.finishLoading();
        splash = TheLegendOfGarywood.assets.get("textures/splash.png", Texture.class);

        TheLegendOfGarywood.assets.load("skins/uiskin.json", Skin.class);
        TheLegendOfGarywood.assets.load("icons/icons.atlas", TextureAtlas.class);

        camera = new OrthographicCamera();
        viewport = new FitViewport(splash.getWidth(), splash.getHeight(), camera);
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE ) {
                    game.setScreen(new StartScreen(game));
                }
                return true;
            }
        });

    }

    @Override
    public void resume() {
        TheLegendOfGarywood.assets.finishLoading();
    }

    @Override
    public void render(float deltaTime) {


        if (TheLegendOfGarywood.assets.update() && minimumShowTime <= 0) {
            game.setScreen(new StartScreen(game));
        }


        Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        TheLegendOfGarywood.spriteBatch.setProjectionMatrix(camera.combined);
        TheLegendOfGarywood.spriteBatch.begin();
        TheLegendOfGarywood.spriteBatch.draw(splash, 0, 0);
        TheLegendOfGarywood.spriteBatch.end();

        minimumShowTime -= deltaTime;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // NOOP
    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void dispose() {
    }

}