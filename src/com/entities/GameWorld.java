package com.entities;

import javafx.scene.Scene;

/**
 * This class combines all the game entities (components, classes) into one class.
 * Making the overall code simpler and straightforward. A singleton class.
 *
 * @author Anton Zenin.
 */
public class GameWorld implements Runnable {
    /* Allows for the pause/resume functionality
     As well as making this variable to be used
     many threads (what compiles code, line by line) */
    private volatile static boolean isRunning = false;

    private Base base;
    // Monster variables

    public GameWorld(Scene scene) {
        base = new Base(scene);
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

    @Override
    public void run() {
        playGame();
    }

    public void playGame() {

    }
}