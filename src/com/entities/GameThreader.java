package com.entities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class manages multithreading of the game. Uses Java Concurrency Threads and Executors.
 */
public abstract class GameThreader {

    // Game Threads, each for a specific task
    private final ExecutorService gameLogicThread = Executors.newFixedThreadPool(1);
    private ExecutorService laserThread;
    private ExecutorService rocketThread;
    private ExecutorService droneThread;

    // Gives a single thread to all the threads
    public GameThreader() {
        this.laserThread = Executors.newSingleThreadExecutor();
        this.rocketThread = Executors.newSingleThreadExecutor();
        this.droneThread = Executors.newSingleThreadExecutor();
    }

    /**
     * Assigns a task to thread(s). Thread(s) runs the code in this method.
     */
    protected abstract void doTask();

    // Setters
    protected void setDroneAmount(int numberOfDrones) {
        this.droneThread = Executors.newFixedThreadPool(numberOfDrones);
    }

    protected void setLaserAmount(int numberOfLasers) {
        laserThread = Executors.newFixedThreadPool(numberOfLasers);
    }

    protected void setRocketAmount(int numberOfRockets) {
        rocketThread = Executors.newFixedThreadPool(numberOfRockets);
    }

    // Getters
    protected ExecutorService getGameLogicThread() {
        return gameLogicThread;
    }

    protected ExecutorService getLaserThread() {
        return laserThread;
    }

    protected ExecutorService getRocketThread() {
        return rocketThread;
    }

    protected ExecutorService getDroneThread() {
        return droneThread;
    }
}