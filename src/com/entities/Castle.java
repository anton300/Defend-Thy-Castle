package com.entities;

/**
 * The castle object that contains the castle's health and shooter.
 *
 * @author Anton Zenin
 */
public class Castle implements RunComponentI {
    private static Shooter shooter;
    private static int health;

    public Castle(Shooter shooter) {
        this.shooter = shooter;
    }

    public int getHealth() {
        return health;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public void run() {

    }
}