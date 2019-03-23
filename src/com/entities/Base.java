package com.entities;

/**
 * The castle object that contains the castle's health and spaceShip.
 *
 * @author Anton Zenin.
 */
public class Base {
    private SpaceShip spaceShip;
    private int health;

    public Base(SpaceShip shooter, int health) {
        this.spaceShip = shooter;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void removeHealth(int amount) {
        this.health -= amount;
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }
}