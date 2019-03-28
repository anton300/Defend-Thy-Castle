package com.entities;

import com.run.LaunchGame;
import javafx.scene.Scene;

/**
 * This class combines all the game entities (components, classes) into one class.
 * Making the overall code simpler and straightforward. A singleton class.
 *
 * @author Anton Zenin.
 */
public class GameWorld extends GameThreader {
    /* Allows for the pause/resume functionality
     As well as making this variable to be used
     many threads (what compiles code, line by line) */
    private volatile static boolean isRunning = false;

    private Base base;
    private SpaceShip spaceShip;
    // Monster variables

    public GameWorld(Scene scene) {
        spaceShip = new SpaceShip(scene);
        base = new Base(spaceShip, 100);
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
        // Outer infinite game loop
//        while (true) {
        doTask();
//        }
    }

    /**
     * All game logic is run here. Allows for pause/resume functionality.
     */
    @Override
    protected void doTask() {
        getGameLogicThread().submit(() -> {
            getBase().getSpaceShip().flySpaceship(LaunchGame.BUTTON_ONE);
        });
    }
}