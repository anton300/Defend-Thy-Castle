package com.entities;

public class Drone extends AIMonster implements Runnable {
    private int health;
    private double speed;

    public Drone(int health, double speed, int health1, double speed1) {
        super(health, speed);
        this.health = health1;
        this.speed = speed1;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void run() {

    }
}