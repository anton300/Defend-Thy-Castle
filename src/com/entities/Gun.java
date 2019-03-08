package com.entities;

import com.run.RunGame;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

/**
 * This class creates the gun for the shooter.
 *
 * @author Anton Zenin.
 */
public class Gun {
    private Bullet bullet;
    // The angle of the gun with respect to the mouse
    private double gunElevation;
    // What the gun is shooting
    private double[] target = new double[2];
    // From where the gun is shooting
    private double[] firingPoint = new double[2];

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

    public double getGunElevation() {
        return gunElevation;
    }

    /**
     * Sets the gun elevation within a range of degrees.
     *
     * @param newGunElevation The new gun elevation.
     */
    public void setGunElevation(double newGunElevation) {
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
                target[0] = event.getX();
                // Gets the Y coordinate of the mouse
                target[1] = event.getY();

                // Sets the angle for the gun to point at the target
                // using Trig math
                rotate.setAngle(Math.toDegrees(Math.atan(target[0] / target[1])));

                // Sets the gun elevation to the calculated angle
                setGunElevation(rotate.getAngle());

                // Gun Graphics here

                fireGun(btn, graph, rotate);
            }
        });
    }

    /**
     * Fires the gun whenever the mouse is clicked.
     *
     * @param btn   Reference Variable.
     * @param graph Reference Variable.
     */
    private void fireGun(Button btn, GraphicsContext graph, Rotate rotate) {
        // Computes the magnitude (length) of the vector
        // from the gun to the mouse
        final int DISTANCE = (int) rotate.deltaTransform(target[0], target[1]).magnitude();

        // Whenever the mouse is clicked
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // It runs the code in here
            @Override
            public void handle(MouseEvent event) {
                // Shoots the bullet along the magnitude of the vector

                // TODO
                // Make a bullet graphic

                while (true) {
                    // Iterate Bullet graphics

                    // If the Bullet hits the edge of the Map
                    if (RunGame.SCENE_WIDTH) {
                        // Set the graphics to null
                        // Exit the loop
                    }

                    if (RunGame.SCENE_HEIGHT) {
                        // Set the graphics to null
                        // Exit the loop
                    }
                }
            }
        });
    }
}