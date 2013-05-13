package com.neatomosquito.firsttankgame;

import java.util.List;

import com.neatomosquito.framework.Game;
import com.neatomosquito.framework.Graphics;
import com.neatomosquito.framework.Input.TouchEvent;
import com.neatomosquito.framework.Screen;

/**
 * Main menu of the game. Handles touch events to start the game and all other options from
 * the main menu image.
 * @author kevin.sparks
 *
 */
public class MainMenuScreen extends Screen {

    public MainMenuScreen(Game game) {
	super(game);
    }

    // Listens for touch events and creates a new screen based on the different options available.
    @Override
    public void update(float deltaTime) {
	Graphics g = game.getGraphics();
	List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
	
	int len = touchEvents.size();
	for(int i = 0; i < len; i++) {
	    TouchEvent event = touchEvents.get(i);
	    if(event.type == TouchEvent.TOUCH_UP) {
		if(inBounds(event, 50, 350, 250, 450)) {
		    // TODO: Create game screen
		    // game.setScreen(new GameScreen(game));
		}
	    }
	}
    }
    
    /**
     * Called by update(). Checks to see if the touch event was inside the box sent to the method.
     * @param event - touch event
     * @param x - x-coordinate pixel
     * @param y - y-coordinate pixel
     * @param width - width of the touch box
     * @param height - height of the touch box
     * @return - true if inside touch box, false if outside
     */
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
	if (event.x > x && event.x < x + width - 1 && event.y > y
		&& event.y < y + height - 1)
	    return true;
	else
	    return false;
    }

    @Override
    public void paint(float deltaTime) {
	Graphics g = game.getGraphics();
	g.drawImage(Assets.menu, 0, 0);
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

    // Kills the game and sends them back to the previous screen (usually whatever screen they were on when they opened the game)
    @Override
    public void backButton() {
	android.os.Process.killProcess(android.os.Process.myPid());
    }

}
