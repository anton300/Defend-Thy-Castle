package com.entities;

import com.run.LaunchGame;
import javafx.scene.image.Image;

/**
 * This class creates the Missile to kill the robots.
 *
 * @author Anton Zenin.
 */
public class Missile {
    private int damage;
    // The area that will kill any robot
    private int[] blastRadius = new int[2];

    // The point from where the bomb will drop
    private int[] launchPoint = new int[2];

    // The graphics to show where the bomb will land
    private int[] areaOfEffect = new int[2];
    private Image bombImage;

    public Missile(int damage, int[] dropPoint) {
        this.damage = damage;
        this.launchPoint[0] = dropPoint[0];
        this.launchPoint[1] = dropPoint[1];

        computeBlastRadius();
    }

    public int[] getAreaOfEffect() {
        return areaOfEffect;
    }

    public int[] getLaunchPoint() {
        return launchPoint;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void computeBlastRadius() {
        final int radius = 60;
        // The X coordinates relative to the missile
        blastRadius[0] = launchPoint[0] + radius;
        blastRadius[1] = launchPoint[0] - radius;
    }

    public void setLaunchPoint(int newX, int newY) {
        if (newX < LaunchGame.SCENE_WIDTH && newX > 0) {
            if (newY < LaunchGame.SCENE_HEIGHT && newY > 0) {
                this.launchPoint[0] = newX;
                this.launchPoint[1] = newY;
            }
        }
    }

    public void launchMissile() {

    }
}