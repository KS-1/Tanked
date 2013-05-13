package com.neatomosquito.firsttankgame;

import java.util.List;

import com.neatomosquito.framework.Game;
import com.neatomosquito.framework.Input.TouchEvent;
import com.neatomosquito.framework.Screen;

/**
 * This class handles the main screen of the game. It will handle most of the user interaction and the user 
 * input via touch event handlers. This class will run the overall game. All of the various classes the tank
 * or projectile class will be updated through this class by this class calling each class' update method in
 * this class' very own update method.
 * 
 * @author kevin.sparks
 *
 */
public class GameScreen extends Screen {
    enum GameState {
	Ready, Running, Paused, GameOver
    }
    
    GameState state = GameState.Running;
    
    // Variable setup
    // TODO: Add google map load
    
    public GameScreen(Game game) {
	super(game);
	
	// Initialize game objects here
	// TODO: Initialize game objects
    }

    /**
     * Handles the touch Events and fixes the game state
     */
    @Override
    public void update(float deltaTime) {
	List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
	
	// Use four separate update methods for this. Depending on the state of the game, call different update methods.
	if(state == GameState.Ready)
	    updateReady(touchEvents);
	if(state == GameState.Running)
	    updateRunning(touchEvents, deltaTime);
	if(state == GameState.Paused)
	    updatePaused(touchEvents);
	if(state == GameState.GameOver)
	    updateGameOver(touchEvents);
    }
    
    /**
     * Waits for a user's touch input, in this case touching anywhere on screen and then initiates the 
     * main game by removing the ReadyUI
     * @param touchEvents - List of all touch events sent to the method
     */
    private void updateReady(List<TouchEvent> touchEvents) {
	if(touchEvents.size() > 0)
	    state = GameState.Running;
    }
    
    
    /**
     * Handles the main running of the game. All update methods are called here. This is were the heart of the 
     * game and its game play are handled. The game essentially runs through this class. 
     * 
     * @param touchEvents - List of all touch events sent to the method
     * @param deltaTime - Keeps track of how long it's been since last update
     */
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
	// This is identical to the update() method in applets
	
	// 1. All touch input is handled here:
	
	// 2. Check miscellaneous events like death:
	// if(death == true)
		// state = GameState.GameOver;
	
	// 3. Call individual update() methods here. This is where all the game updates happen.
	// Example would be a projectile update like this:
	/*
	 * ArrayList projectiles = tank.getProjectiles();
	 * for(int i = 0; i < projectiles.size(); i++) {
	 * 	Projectile p = (Projectile) projectiles.get(i);
	 * 	if(p.isVisible() = true) {
	 * 		p.update();
	 * 	} else {
	 * 		projectiles.remove(i);
	 * 	}
	 */
    }
    
    // inBounds methods here
    
    
    /**
     * Handles the paused game state. I.E. if the game is paused then the paused UI is overlaid on the 
     * game screen. This then listens for the user's touch event (most likely a resume or quit event) and 
     * handles those actions. 
     * 
     * @param touchEvents - Touch Events that are passed to the method
     */
    private void updatePaused(List<TouchEvent> touchEvents) {
	int len = touchEvents.size();
	for(int i = 0; i < len; i++) {
	    TouchEvent event = touchEvents.get(i);
	    if(event.type == TouchEvent.TOUCH_UP) {
		// TODO: Handle touch events here.
	    }
	}
    }
    
    /**
     * If game over handles the GameOver UI and the end of one game by clearing all parameters for the 
     * game and returning the user to the main menu screen. 
     * @param touchEvents - Touch Events that are passed to the method
     */
    private void updateGameOver(List<TouchEvent> touchEvents) {
	int len = touchEvents.size();
	for(int i = 0; i < len; i++) {
	    TouchEvent event = touchEvents.get(i);
	    if(event.type == TouchEvent.TOUCH_DOWN) {
		// TODO: Handle game over 
		// To handle game over we tell the user game over and when they press a main menu option on the screen
		// clear out all the variables and call a new main menu screen
		// if(inBounds(event, 0, 0, 0, 0)) {
		   // nullify();
		   // game.setScreen(new MainMenuScreen(game));
		   // return;
		// }
	    }
	}
    }
    
    /**
     * This method literally paint's everything to the screen. The objects that you want to be on top get
     * painted last and the ones that are in the back (background usually but also could be floors or 
     * ceilings) are painted first. This also paints the main objects in this case a tank and it's projectiles.
     * 
     * @param deltaTime - keeps track of how long it's been since the last update
     */
    @Override
    public void paint(float deltaTime) {
	// Lastly draw game status UI above game elements
	// This would be done last.
	if(state == GameState.Ready)
	    drawReadyUI();
	if(state == GameState.Running)
	    drawRunningUI();
	if(state == GameState.Paused)
	    drawPausedUI();
	if(state == GameState.GameOver)
	    drawGameOverUI();
    }
    
    /**
     * Sets every variable that is called at the beginning of the class equal to null. Then
     * it "suggests" to the system to garbage collect. 
     */
    private void nullify() {
	// Here you would set everything to null
	// background = null;
	// Call garbage collector to clean up memory.
	System.gc();
    }
    
    /**
     * Handles the ready state UI
     */
    private void drawReadyUI() {
	// TODO: draw ready ui
    }
    
    /**
     * Handles running state UI
     */
    private void drawRunningUI() {
	// TODO: draw running ui
    }
    
    /**
     * Handles Paused state UI
     */
    private void drawPausedUI() {
	// TODO: draw paused UI
    }
    
    /**
     * Handles game over UI
     */
    private void drawGameOverUI() {
	// TODO: draw game over UI
    }
    
    @Override
    public void pause() {
	if(state == GameState.Running)
	    state = GameState.Paused;
    }

    @Override
    public void resume() {
	if(state == GameState.Paused)
	    state = GameState.Running;
    }

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public void backButton() {
	pause();
    }

    // Not needed now but potentially in the future. Good to have for now.
    private void goToMenu() {
	game.setScreen(new MainMenuScreen(game));
    }
    
    /*
     * Not needed now put potentially in the future. Good to have for now.
     * public static Tank getTank() {
     * 		return tank;
     */
}
