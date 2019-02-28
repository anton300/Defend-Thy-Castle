package com.entities;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

/**
 * This class creates the gun.
 *
 * @author Anton Zenin.
 */
public class Gun {
    private Bullet bullet;
    // The angle of the gun with respect to the mouse
    private int gunElevation;
    // What the gun is shooting
    private int[] target = new int[2];
    // From where the gun is shooting
    private int[] firingPoint = new int[2];

    // The range that you can aim. 10 to 170 degrees (160 degrees of freedom)
    public static final int MAX_GUN_ELEVATION = 10;
    public static final int MIN_GUN_ELEVATION = 170;

    // Constructor
    public Gun(int damage, int damageBoost, int[] firingPoint) {
        this.gunElevation = 90;

        // Creates the point from which the code knows where
        // shoot the bullet from, the origin point (0, 0)
        this.firingPoint[0] = firingPoint[0];
        this.firingPoint[1] = firingPoint[1];

        // Creates the bullet
        this.bullet = new Bullet(damage, damageBoost, firingPoint);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public int getGunElevation() {
        return gunElevation;
    }

    /**
     * Sets the gun elevation within a range.
     *
     * @param newGunElevation The new gun elevation.
     */
    public void setGunElevation(int newGunElevation) {
        // Gun elevation is in degrees. If the value is within the range of the elevation.
        // From 10 to 170 degrees, if it is in that range, then it will assign it to that value.
        if (newGunElevation >= MAX_GUN_ELEVATION && newGunElevation <= MIN_GUN_ELEVATION) {
            gunElevation = newGunElevation;
        }

        /* If the gun elevation is over the max limit, then it
           assign it to the max elevation. Meaning it never goes
           over the limit. */
        if (newGunElevation < MAX_GUN_ELEVATION) {
            gunElevation = MAX_GUN_ELEVATION;
        }

        // Same thing here, but for the minimum gun elevation
        if (newGunElevation > MIN_GUN_ELEVATION) {
            gunElevation = MIN_GUN_ELEVATION;
        }
    }

    /**
     * Takes the gun graphics and aligns it to the mouse.
     */
    public void aimGun(GraphicsContext graph) {
        Button btn = new Button();
        btn.setVisible(false);

        Rotate rotate = new Rotate(gunElevation, firingPoint[0], firingPoint[1]);

        // Whenever the mouse is moved
        btn.setOnMouseMoved(new EventHandler<MouseEvent>() {
            // It will run this method
            @Override
            public void handle(MouseEvent event) {
                // Gets the X coordinate of the mouse
                target[0] = (int) event.getX();
                // Gets the Y coordinate of the mouse
                target[1] = (int) event.getY();

                // Computes the magnitude (length) of the vector
                // from the gun to the mouse
                final int DISTANCE = (int) rotate.deltaTransform(target[0], target[1]).magnitude();

                // TODO
                // Set the gun angle to the mouse's X & Y coordinates setAngle()
                // with respect to the magnitude

                // Update the gun graphics with the new elevation getAngle()
                // and use the setGunElevation() method

                // Gun Graphics here

                fireGun(btn, graph, DISTANCE);
            }
        });
    }

    /**
     * Fires the gun whenever the mouse is clicked.
     *
     * @param btn   Reference Variable.
     * @param graph Reference Variable.
     */
    private void fireGun(Button btn, GraphicsContext graph, int distance) {
        // Whenever the mouse is clicked
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // It runs the code in here
            @Override
            public void handle(MouseEvent event) {
                // Shoot the bullet along the magnitude of the vector

            }
        });
    }
}