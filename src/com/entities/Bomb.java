package com.entities;

import com.run.RunGame;
import javafx.scene.image.Image;

/**
 * This class creates the bomb to kill the monsters and it's physics.
 *
 * @author Anton Zenin.
 */
public class Bomb {
    private int damage;
    // The area that will kill any Monster
    private int[] blastRadius = new int[2];

    // The point from where the bomb will drop
    private int[] dropPoint = new int[2];

    // The graphics to show where the bomb will land
    private int[] areaOfEffect = new int[2];
    private Image bombImage;

    public Bomb(int damage, int[] dropPoint, Image bombImage) {
        this.damage = damage;
        this.dropPoint[0] = dropPoint[0];
        this.dropPoint[1] = dropPoint[1];

        computeBlastRadius();
        this.bombImage = bombImage;
    }

    public int[] getAreaOfEffect() {
        return areaOfEffect;
    }

    public int[] getDropPoint() {
        return dropPoint;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void computeBlastRadius() {
        final int radius = 60;
        // The X coordinates relative to the bomb
        blastRadius[0] = dropPoint[0] + radius;
        blastRadius[1] = dropPoint[0] - radius;
    }

    public void setDropPoint(int newX, int newY) {
        if (newX < RunGame.SCENE_WIDTH && newX > 0) {
            if (newY < RunGame.SCENE_HEIGHT && newY > 0) {
                this.dropPoint[0] = newX;
                this.dropPoint[1] = newY;
            }
        }
    }

    public void dropBomb() {

    }
}