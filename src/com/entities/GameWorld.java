package com.entities;

import javafx.scene.Scene;

/**
 * This class combines all the game entities (components, classes) into one class.
 * Making the overall code simpler and straightforward.
 *
 * @author Anton Zenin.
 */
public class GameWorld {
    /* Allows for the pause/resume functionality
     As well as making this variable to be used
     many threads (what compiles code, line by line) */
    private volatile boolean isRunning = false;

    private Base base;
    // Monster variable

    public GameWorld(Scene scene) {

        base = new Base(new SpaceShip(scene), 100);
        // Monster instance
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Base getBase() {
        return base;
    }

    /**
     * The infinite outer loop that runs the game until the player clicks
     * the exit button of the window.
     */
    public void playGame() {
        while (true) {
            runGameLogic();
        }
    }

    /**
     * All game logic is run here. Allows for pause/resume functionality
     */
    private void runGameLogic() {
        while (isRunning) {
            // Game logic
        }
    }
}