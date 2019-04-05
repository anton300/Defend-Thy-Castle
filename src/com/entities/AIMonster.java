package com.entities;

public class AIMonster {
    private int health;
    private double speed;

    public AIMonster(int health, double speed) {
        this.health = health;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public synchronized void takeAwayHealth(int damageTaken, AIMonster drone) {

    }
}