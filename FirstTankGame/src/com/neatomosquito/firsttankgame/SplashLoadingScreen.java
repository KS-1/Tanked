package com.neatomosquito.firsttankgame;

import com.neatomosquito.framework.Game;
import com.neatomosquito.framework.Graphics;
import com.neatomosquito.framework.Graphics.ImageFormat;
import com.neatomosquito.framework.Screen;

/**
 * Loads the objects from assets for the game. 
 * @author kevin.sparks
 *
 */
public class SplashLoadingScreen extends Screen {

    public SplashLoadingScreen(Game game) {
	super(game);
    }

    @Override
    public void update(float deltaTime) {
	Graphics g = game.getGraphics();
	Assets.splash = g.newImage("splash.jpg", ImageFormat.RGB565);
	
	game.setScreen(new LoadingScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
	// TODO Auto-generated method stub

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
