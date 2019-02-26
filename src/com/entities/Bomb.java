package com.entities;

import com.run.*;
import javafx.scene.image.Image;

/**
 * This class creates the bomb to kill the monsters and it's physics.
 *
 * @author Anton Zenin
 */
public class Bomb implements RunComponentI {
    private static int damage;
    private static int[] blastRadius;
    private static int[] dropPoint;
    private static int[] areaOfEffect;
    private static Image bombImage;

    public Bomb(int damage, int[] dropPoint, Image bombImage) {
        this.damage = damage;
        this.dropPoint = dropPoint;
        this.areaOfEffect = computeBlastRadius();
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
        Bomb.damage = damage;
    }

    public int[] computeBlastRadius() {
        final int radius = 60;
        // The X coordinates relative to the bomb
        blastRadius[0] = dropPoint[0] + radius;
        blastRadius[1] = dropPoint[0] - radius;
        return blastRadius;
    }

    public void setDropPoint(int newX, int newY) {
        if (newX < RunGame.PANE_WIDTH && newX > 0) {
            if (newY < RunGame.PANE_HEIGHT && newY > 0) {
                Bomb.dropPoint[0] = newX;
                Bomb.dropPoint[1] = newY;
            }
        }
    }

    public void dropBomb() {

    }
}