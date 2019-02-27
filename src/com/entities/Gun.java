package com.entities;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * This class creates the gun.
 *
 * @author Anton Zenin
 */
public class Gun implements RunComponentI {
    private int damage;
    private int gunElevation;
    private Bullet bullet;
    private int[] anchorPoint = new int[2];

    public static final int MAX_GUN_ELEVATION = 10;
    public static final int MIN_GUN_ELEVATION = 170;

    public Gun(int damage, int damageBoost, int[] anchorPoint) {
        this.damage = damage;
        this.gunElevation = 90;

        this.anchorPoint[0] = anchorPoint[0];
        this.anchorPoint[1] = anchorPoint[1];

        this.bullet = new Bullet(this.damage, damageBoost, anchorPoint);
    }

    public int getDamage() {
        return damage;
    }

    public int getGunElevation() {
        return gunElevation;
    }

    public void setGunElevation(int gunElevation) {
        // Gun elevation is in degrees. If the value is within the range of the elevation.
        // From 10 to 170 degrees, if it is in that range, then it will assign it to that value.
        if (gunElevation >= MAX_GUN_ELEVATION && gunElevation <= MIN_GUN_ELEVATION) {
            this.gunElevation = gunElevation;
        }

        if (gunElevation < MAX_GUN_ELEVATION) {
            this.gunElevation = MAX_GUN_ELEVATION;
        }

        if (gunElevation > MIN_GUN_ELEVATION) {
            this.gunElevation = MIN_GUN_ELEVATION;
        }
    }

    /**
     * Fires the gun.
     */
    private void fire() {

    }

    /**
     * Takes the gun graphics and adjusts it relative to the mouse.
     */
    public void alignGunToMouse() {
        int[] mouseXY = new int[2];

        Button btn = new Button();
        btn.setVisible(false);

        // Whenever the mouse is moved
        btn.setOnMouseMoved(new EventHandler<MouseEvent>() {
            // It will run this method
            @Override
            public void handle(MouseEvent event) {
                // Gets the X coordinate of the mouse
                mouseXY[0] = (int) event.getX();
                // Gets the Y coordinate of the mouse
                mouseXY[1] = (int) event.getY();
            }
        });
    }
}