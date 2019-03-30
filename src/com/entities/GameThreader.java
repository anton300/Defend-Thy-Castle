package com.entities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class manages multithreading of the game. Uses Java Concurrency's Threads and Executors.
 */
public class GameThreader {

    // Game Threads, each for a specific task
    private final ExecutorService flySpaceshipThread = Executors.newSingleThreadExecutor();
    private ExecutorService laserThread;
    private ExecutorService rocketThread;
    private ExecutorService droneThread;

    // Gives a single thread to all the threads
    public GameThreader() {
        this.laserThread = Executors.newSingleThreadExecutor();
        this.rocketThread = Executors.newSingleThreadExecutor();
        this.droneThread = Executors.newSingleThreadExecutor();
    }

    // Setters
    public void setDroneAmount(int numberOfDrones) {
        this.droneThread = Executors.newFixedThreadPool(numberOfDrones);
    }

    public void setLaserAmount(int numberOfLasers) {
        laserThread = Executors.newFixedThreadPool(numberOfLasers);
    }

    public void setRocketAmount(int numberOfRockets) {
        rocketThread = Executors.newFixedThreadPool(numberOfRockets);
    }

    // Getters
    public ExecutorService getLaserThread() {
        return laserThread;
    }

    public ExecutorService getRocketThread() {
        return rocketThread;
    }

    public ExecutorService getDroneThread() {
        return droneThread;
    }

    public ExecutorService getFlySpaceshipThread() {
        return flySpaceshipThread;
    }
}