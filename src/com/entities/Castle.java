package com.entities;

/**
 * The castle object that contains the castle's health and shooter.
 *
 * @author Anton Zenin.
 */
public class Castle {
    private Shooter shooter;
    private int health;

    public Castle(Shooter shooter, int health) {
        this.shooter = shooter;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void removeHealth(int amount) {
        this.health -= amount;
    }

    public Shooter getShooter() {
        return shooter;
    }
}