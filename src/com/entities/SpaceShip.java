package com.entities;

import com.run.LaunchGame;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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

    private static final int[] MISSILE_LAUNCH_POINT = {LaunchGame.SCENE_HEIGHT, LaunchGame.SCENE_WIDTH / 2};
    private static final int[] FIRING_POINT = {175, LaunchGame.positionOfShipY};
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

    public void flySpaceship() {

        Button buttonOne = new Button();
        buttonOne.setLayoutX(0);

        // Starting Y position of the ship
        buttonOne.setLayoutY(LaunchGame.positionOfShipY);
        buttonOne.setBackground(null);

        LaunchGame.ROOT.getChildren().add(buttonOne);

        // The code below moves the ship up and down
        buttonOne.setOnKeyPressed(event -> {

            // start movement according to key pressed
            switch (event.getCode()) {

                // When the player presses the W key, it moves the SPACE_SHIP upwards
                case W:
                    // Makes sure the SPACE_SHIP does not move off the screen
                    if (LaunchGame.positionOfShipY > 0) {
                        LaunchGame.shipShape.setFill(null);

                        // Moves the SPACE_SHIP up 40 pixels
                        LaunchGame.positionOfShipY = LaunchGame.positionOfShipY - 40;

                        // Makes a new spaceship
                        LaunchGame.shipShape = new Rectangle(0, LaunchGame.positionOfShipY, 191, 300);
                        System.out.println(LaunchGame.positionOfShipY);

                        // Sets a new image for the SPACE_SHIP
                        LaunchGame.shipShape.setFill(new ImagePattern(LaunchGame.SPACE_SHIP));

                        LaunchGame.ROOT.getChildren().add(LaunchGame.shipShape);
                    }
                    break;

                // When the player presses the S key, it moves the SPACE_SHIP downwards
                case S:
                    if (LaunchGame.positionOfShipY < LaunchGame.SCENE_HEIGHT) {
                        LaunchGame.shipShape.setFill(null);

                        // Moves the SPACE_SHIP by 40 pixels
                        LaunchGame.positionOfShipY = LaunchGame.positionOfShipY + 40;

                        LaunchGame.shipShape = new Rectangle(0, LaunchGame.positionOfShipY, 191, 300);

                        System.out.println(LaunchGame.positionOfShipY);

                        // Creates a new image for the SPACE_SHIP
                        LaunchGame.shipShape.setFill(new ImagePattern(LaunchGame.SPACE_SHIP));

                        LaunchGame.ROOT.getChildren().add(LaunchGame.shipShape);
                    }
                    break;
            }
        });
    }

    /**
     * Takes the gun graphics and aligns it to the mouse.
     */
    public void aimGun() {
        // Whenever the mouse is moved
        scene.setOnMouseMoved(event -> {
            // It will run this code
            // Gets the X coordinate of the mouse
            target[0] = event.getX();

            // Gets the Y coordinate of the mouse
            target[1] = event.getY();
        });
    }

    /**
     * Fires the gun whenever the mouse is clicked.
     */
    public void fireGun() {
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

            // The place where the PathTransition (the movement of the node must go to)
            Circle hitTarget = new Circle(1);
            hitTarget.setVisible(false);

            // Setting the circle 1200 pixels beyond the mouse's X & Y
            hitTarget.setLayoutX(target[0] + 1200);
            hitTarget.setLayoutY(target[1] + 1200);

            PathTransition moveLaser = new PathTransition();

            // What is moving (the laser)
            moveLaser.setNode(laser);

            // To where the laser will go to
            moveLaser.setPath(hitTarget);

            moveLaser.setDuration(Duration.seconds(1));
            moveLaser.play();

            // When the laser hits the top of the screen
            if (moveLaser.getNode().getTranslateY() <= 0) {
                moveLaser = null;
            }

            // When the laser hit the bottom of the screen
            if (moveLaser.getNode().getTranslateY() >= LaunchGame.SCENE_HEIGHT) {
                moveLaser = null;
            }

            // When the laser hits the right edge of the screen
            if (moveLaser.getNode().getTranslateX() >= LaunchGame.SCENE_WIDTH) {
                moveLaser = null;
            }
        });
    }
}