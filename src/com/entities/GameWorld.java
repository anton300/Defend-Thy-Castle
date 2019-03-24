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
    private volatile static boolean isRunning = false;
    private static Thread gameThread;

    private Base base;
    // Monster variable

    private static boolean exit = true;

    private GameWorld(Scene scene) {
        gameThread = new Thread();
        base = new Base(new SpaceShip(scene), 100);
        // Monster instance

        gameThread.start();

        // The first thread breaks out of the loop and returns back to the main class
        if (exit) {
            exit = false;
        } else {
            playGame();
        }
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
            System.out.println("Game is " + isRunning);
        }
    }
}