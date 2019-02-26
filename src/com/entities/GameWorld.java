package com.entities;


import java.io.IOException;

/**
 * This class combines all the game entities (components, classes) into one class.
 * Making the overall code simpler and straightforward.
 *
 * @author Anton Zenin
 */
public class GameWorld {
    private static Castle castle;
    // Monster variable

    public GameWorld() throws IOException {
        castle = new Castle(new Shooter());
        // Monster instance
    }

    public Castle getCastle() {
        return castle;
    }

    /**
     * Runs the game with all the components collaborating.
     * Acts as an access method to the rest of the game.
     *
     * @param condition true or false.
     * @return True if the game is running. Otherwise false.
     */
    public boolean playGame(boolean condition) {
        while (condition) {

        }
        return false;
    }
}