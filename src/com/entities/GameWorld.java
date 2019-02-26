package com.entities;

import java.io.IOException;

/**
 * This class combines all the game entities (components, classes) into one class.
 * Making the overall code simpler and straightforward.
 *
 * @author Anton Zenin
 */
public class GameWorld {
    private volatile boolean isRunning = false;
    private Castle castle;
    // Monster variable

    public GameWorld() throws IOException {
        castle = new Castle(new Shooter(), 100);
        // Monster instance
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Castle getCastle() {
        return castle;
    }

    /**
     * Runs the game with all the components collaborating.
     * Acts as an access method to the rest of the game.
     *
     * @return True if the game is running. Otherwise false.
     */
    public void playGame() {
        while (true) {
            runGameLogic();
        }
    }

    private void runGameLogic() {
        while (isRunning) {
            // Game logic
        }
    }
}