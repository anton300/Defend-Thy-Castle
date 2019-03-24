package com.entities;

import com.run.LaunchGame;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * This class creates the shooter with all it's components to play the game.
 *
 * @author Anton Zenin.
 */
public class SpaceShip {
    private Gun gun;
    private Missile missile;
    private Scene scene;

    private static final int[] MISSILE_LAUNCH_POINT_COOR = {LaunchGame.SCENE_HEIGHT, LaunchGame.SCENE_WIDTH / 2};
    private static final int[] FIRING_POINT = {175, LaunchGame.positionOfShipY};
    private int[] target = new int[2];

    public SpaceShip(Scene scene) {
        this.scene = scene;
        gun = new Gun(35, 0, FIRING_POINT);

        missile = new Missile(500, MISSILE_LAUNCH_POINT_COOR);
    }

    public Gun getGun() {
        return gun;
    }

    public Missile getMissile() {
        return missile;
    }

    /**
     * Takes the gun graphics and aligns it to the mouse.
     */
    public void aimGun() {
        Rotate rotate = new Rotate(getGun().getGunElevation(), FIRING_POINT[0], FIRING_POINT[1]);

        // Whenever the mouse is moved
        scene.setOnMouseMoved(event -> {
            // It will run this code
            // Gets the X coordinate of the mouse
            target[0] = (int) event.getX();
            // Gets the Y coordinate of the mouse
            target[1] = (int) event.getY();

            // Sets the angle for the gun to point at the target
            // using Trig math
            rotate.setAngle(Math.toDegrees(Math.atan(target[0] / target[1])));

            // Sets the gun elevation to the calculated angle
            getGun().setGunElevation(rotate.getAngle());

            fireGun(scene, rotate);
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
        scene.setOnMouseClicked(event -> {
            // It runs the code in here
            // Shoots the laser along the magnitude of the vector

            Rectangle laser = new Rectangle();
            laser.setFill(Color.RED);
            laser.setWidth(15);
            laser.setHeight(8);

            // Places the laser to where it must shot from (the Spaceship)
            // The X and Y coordinates
            laser.setLayoutX(FIRING_POINT[0]);
            laser.setLayoutY(FIRING_POINT[1]);

            PathTransition move = new PathTransition();

            // A circle to indicate where the laser should go
            Circle dest = new Circle(1);
            dest.setVisible(false);
            dest.setLayoutX(target[0] + 1000);
            dest.setLayoutY(target[1] + 1000);

            // Where the laser needs to go
            move.setNode(dest);
            // The graphic that is being moved
            move.setPath(laser);
            // How long the laser will take to reach it's destination
            move.setDuration(Duration.seconds(1));
            move.play();

            /* TODO
             * If the bullet hits a Monster, then call the Monster's super class
             * damage method to damage the monster that it hit.
             * Transfer the bullet data to the Monster, and take away health. */

            // When the laser hits the screen's boundaries
            if (laser.getY() <= 0) {
                laser = null;
                move = null;

            } else if (laser.getY() >= LaunchGame.SCENE_HEIGHT) {
                laser = null;
                move = null;
            }

            if (laser.getX() >= LaunchGame.SCENE_WIDTH) {
                laser = null;
                move = null;
            }
        });
    }
}