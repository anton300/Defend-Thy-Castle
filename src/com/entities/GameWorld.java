package com.entities;

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
    // Monster variable

    private GameWorld(Scene scene) {
        base = new Base(new SpaceShip(scene), 100);
        // Monster instance
    }

    public static void getInstance(Scene scene) {
        GameWorld world = new GameWorld(scene);
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void setRunning(boolean running) {
        isRunning = running;
    }

    public Base getBase() {
        return base;
    }

    /**
     * The infinite outer loop that runs the game until the player clicks
     * the exit button of the window.
     */
    private void playGame() {
        // Outer infinite game loop
        while (true) {
            runGameLogic();
        }
    }

    /**
     * All game logic is run here. Allows for pause/resume functionality.
     */
    private void runGameLogic() {
        while (isRunning) {

        }
    }
}