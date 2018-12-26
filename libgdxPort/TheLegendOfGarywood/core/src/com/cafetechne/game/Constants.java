package com.cafetechne.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final float START_SCREEN_LABEL_SCALE = 2f;
    public static final float START_SCREEN_WORLD_SIZE = 480.0f;

    public static final Color BACKGROUND_COLOR = Color.BLUE;

    public static final String NEWGAME_LABEL = "New Game";
    public static final String CONTINUE_LABEL = "Continue";
    public static final String OPTIONS_LABEL = "Options";

    public static final float START_SCREEN_BUTTON_RADIUS = START_SCREEN_WORLD_SIZE / 9;

    public static final Vector2 NEWGAME_CENTER = new Vector2(START_SCREEN_WORLD_SIZE /2, START_SCREEN_WORLD_SIZE - 150f);
    public static final Vector2 CONTINUE_CENTER = new Vector2(START_SCREEN_WORLD_SIZE /2, START_SCREEN_WORLD_SIZE - 200f);
    public static final Vector2 OPTIONS_CENTER = new Vector2(START_SCREEN_WORLD_SIZE /2, START_SCREEN_WORLD_SIZE - 250f);

}
