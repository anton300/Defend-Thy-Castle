package com.entities;

import com.run.LaunchGame;
import javafx.scene.Scene;

/**
 * This class creates the shooter with all it's components to play the game.
 *
 * @author Anton Zenin.
 */
public class SpaceShip {
    private Gun gun;
    private Missile missile;
    private Scene scene;

    private static final int[] MISSILE_LAUNCH_POINT = {LaunchGame.SCENE_HEIGHT, LaunchGame.SCENE_WIDTH / 2};
    private static final double[] FIRING_POINT = {175, LaunchGame.shipNode.getLayoutY()};
    private double[] target = new double[2];

    public SpaceShip(Scene scene) {
        this.scene = scene;
        gun = new Gun(35, 0, FIRING_POINT);

        missile = new Missile(500, MISSILE_LAUNCH_POINT);
    }

    public Gun getGun() {
        return gun;
    }

    public Missile getMissile() {
        return missile;
    }
}