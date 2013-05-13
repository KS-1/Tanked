package com.neatomosquito.firsttankgame;

import com.neatomosquito.framework.Screen;
import com.neatomosquito.framework.implementation.AndroidGame;

/**
 * Used by other classes to create a new game. Checks to see if this is the first time created.
 * Sets the splash loading screen to load all game assets and sets off the creation of a new game.
 * @author kevin.sparks
 *
 */
public class Game extends AndroidGame {
    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {
	if(firstTimeCreate) {
	    // Load from Assets class
	    // Assets.load(this);
	    firstTimeCreate = false;
	}
	
	return new SplashLoadingScreen(this);
    }

    @Override
    public void onBackPressed() {
	getCurrentScreen().backButton();
    }
    
    @Override
    public void onResume() {
	super.onResume();
    }
    
    @Override
    public void onPause() {
	super.onPause();
    }
}
