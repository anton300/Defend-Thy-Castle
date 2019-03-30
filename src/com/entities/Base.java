package com.entities;

import javafx.scene.Scene;

/**
 * The castle object that contains the castle's health and SPACE_SHIP.
 *
 * @author Anton Zenin.
 */
public class Base {
    private SpaceShip spaceShip;
    private int health;

    public Base(Scene scene) {
        this.spaceShip = new SpaceShip(scene);
        this.health = 100;
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