package com.neatomosquito.firsttankgame;

import com.neatomosquito.framework.Game;
import com.neatomosquito.framework.Graphics;
import com.neatomosquito.framework.Graphics.ImageFormat;
import com.neatomosquito.framework.Screen;

/**
 * Loads objects from assets class to set up main menu.
 * @author kevin.sparks
 *
 */
public class LoadingScreen extends Screen {

    public LoadingScreen(Game game) {
	super(game);
    }

    @Override
    public void update(float deltaTime) {
	// Load the game
	Graphics g = game.getGraphics();
	Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);

	// Start game when everything is loaded
	game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
	Graphics g = game.getGraphics();
	g.drawImage(Assets.splash, 0, 0);
    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public void backButton() {
	// TODO Auto-generated method stub

    }

}
