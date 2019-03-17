package com.entities;

import com.run.RunGame;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

/**
 * This class creates the shooter with all it's components to play the game.
 *
 * @author Anton Zenin.
 */
public class Shooter {
    private Gun gun;
    private Bomb bomb;
    private Scene scene;

    private static final int[] FIRING_POINT = {250, 250};
    private int[] target = new int[2];

    public Shooter(Scene scene) {
        this.scene = scene;
        gun = new Gun(35, 0, FIRING_POINT);

        int[] dropPointCoor = {RunGame.SCENE_HEIGHT, RunGame.SCENE_WIDTH / 2};
        bomb = new Bomb(500, dropPointCoor, null);
    }

    public Gun getGun() {
        return gun;
    }

    public Bomb getBomb() {
        return bomb;
    }

    /**
     * Takes the gun graphics and aligns it to the mouse.
     */
    public void aimGun() {
        Rotate rotate = new Rotate(getGun().getGunElevation(), FIRING_POINT[0], FIRING_POINT[1]);

        // Whenever the mouse is moved
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            // It will run this method
            @Override
            public void handle(MouseEvent event) {
                // Gets the X coordinate of the mouse
                target[0] = (int) event.getX();
                // Gets the Y coordinate of the mouse
                target[1] = (int) event.getY();

                // Sets the angle for the gun to point at the target
                // using Trig math
                rotate.setAngle(Math.toDegrees(Math.atan(target[0] / target[1])));

                // Sets the gun elevation to the calculated angle
                getGun().setGunElevation(rotate.getAngle());

                // Gun Graphics here

                fireGun(scene, rotate);
            }
        });
    }

    /**
     * Fires the gun whenever the mouse is clicked.
     *
     * @param scene  Reference Variable.
     * @param rotate Reference Variable.
     */
    private void fireGun(Scene scene, Rotate rotate) {
        // Computes the magnitude (length) of the vector
        // from the gun to the mouse
        final int DISTANCE = (int) rotate.deltaTransform(target[0], target[1]).magnitude();

        // Whenever the mouse is clicked
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // It runs the code in here
            @Override
            public void handle(MouseEvent event) {
                // Shoots the bullet along the magnitude of the vector

                // TODO
                // Make a bullet graphic

                while (true) {
                    // Iterate Bullet graphics

                    // If the Bullet hits the edge of the Map
//                    if (RunGame.SCENE_WIDTH) {
//                        // Set the graphics to null
//                        // Exit the loop
//                    }
//
//                    if (RunGame.SCENE_HEIGHT) {
//                        // Set the graphics to null
//                        // Exit the loop
//                    }

                    /* TODO
                     * If the bullet hits a Monster, then call the Monster's super class
                     * damage method to damage the monster that it hit.
                     * Transfer the bullet data to the Monster, and take away health. */
                }
            }
        });
    }
}