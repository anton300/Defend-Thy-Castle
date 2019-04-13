package com.run;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Loads the game and it's graphics.
 *
 * @author Patryk.
 * @author Anton Zenin.
 */
public class LaunchGame extends Application {

    // The window's (stage) dimensions in pixels
    public static final int STAGE_WIDTH = 1500;
    public static final int STAGE_HEIGHT = 820;

    // The window's dimensions in pixels where all the
    // graphics are displayed and where the game runs
    public static final int SCENE_WIDTH = STAGE_WIDTH - 20;
    public static final int SCENE_HEIGHT = 480;

    // We will be using a CSS file that will connect to our JavaFX application
    // this will be used for setting a global text font, text color, etc.
    private static final double WIDTH = 1250, HEIGHT = 600;
    private static final String SHIP_IMAGE = "images/spaceship.png";
    private static final String DRONE_IMAGE = "images/drone.png";
    private static final String LASER_IMAGE = "images/laserBullet.png";
    private static final String CITY_IMAGE = "images/spaceCity.jpg";

    private Image shipImage, droneImage, laserImage, cityImage;
    private Node shipNode;
    private ArrayList<Node> lasers = new ArrayList<>();
    private ArrayList<Node> drones = new ArrayList<>();
    private Group board;
    private Text scoreText, livesText;
    private int dLaser = 10, dDrone = -4, modifier = 150, droneCounter = modifier - 1, score = 0, lives = 3;

    private boolean goNorth, goSouth, goWest, goEast, shooting;
    public static final int SPACESHIP_MOVE_AMOUNT = 4;

    @Override
    public void start(Stage stage) {

        shipImage = new Image(SHIP_IMAGE);
        shipNode = new ImageView(shipImage);

        droneImage = new Image(DRONE_IMAGE);
        laserImage = new Image(LASER_IMAGE);
        cityImage = new Image(CITY_IMAGE);

        board = new Group();
        scoreText = new Text(110, 10, "Score: " + score);
        livesText = new Text(170, 10, "Lives: " + lives);
        board.getChildren().addAll(shipNode, scoreText, livesText);

        moveShipTo(50, HEIGHT / 2);
        Scene scene = new Scene(board, WIDTH, HEIGHT, new ImagePattern(cityImage));

        // Whenever the player presses a key to play the game
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                // Flies the spaceship up
                case W:
                    goNorth = true;
                    break;

                // Flies the spaceship down
                case S:
                    goSouth = true;
                    break;

                // Flies the spaceship left
                case A:
                    goWest = true;
                    break;

                // Flies the spaceship right
                case D:
                    goEast = true;
                    break;

                // To fire the lasers
                case SPACE:
                    if (!shooting) {
                        ImageView laser1 = new ImageView(laserImage);
                        ImageView laser2 = new ImageView(laserImage);

                        Node newLaser1 = laser1;
                        Node newLaser2 = laser2;
                        newLaser1.relocate(shipNode.getLayoutX() + shipNode.getBoundsInLocal().getWidth(), shipNode.getLayoutY() + 55);
                        newLaser2.relocate(shipNode.getLayoutX() + shipNode.getBoundsInLocal().getWidth(), shipNode.getLayoutY() + 175);

                        lasers.add(newLaser1);
                        lasers.add(newLaser2);
                        board.getChildren().addAll(newLaser1);
                        shooting = true;
                    }
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                    goNorth = false;
                    break;

                case S:
                    goSouth = false;
                    break;

                case D:
                    goEast = false;
                    break;

                case A:
                    goWest = false;
                    break;

                case SPACE:
                    shooting = false;
                    break;
            }
        });

        stage.setScene(scene);
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                // Moves the spaceship by n pixels
                if (goNorth) {
                    dy -= SPACESHIP_MOVE_AMOUNT;
                }
                if (goSouth) {
                    dy += SPACESHIP_MOVE_AMOUNT;
                }
                if (goWest) {
                    dx -= SPACESHIP_MOVE_AMOUNT;
                }
                if (goEast) {
                    dx += SPACESHIP_MOVE_AMOUNT;
                }
                droneCounter++;

                if (droneCounter % modifier == 0) {
                    if (modifier > 20) {
                        modifier--;
                    }
                    Node newDrone = new ImageView(droneImage);
                    newDrone.relocate(WIDTH, (int) (Math.random() * (HEIGHT - 250) - newDrone.getBoundsInLocal().getHeight()) + 100);
                    drones.add(newDrone);
                    board.getChildren().add(newDrone);
                }

                moveShipTo(shipNode.getLayoutX() + dx, shipNode.getLayoutY() + dy);
                shoot(dLaser);
                moveDrone(dDrone);
                checkHit();

                if (lives == 0) {
                    Text gameOver = new Text(WIDTH / 2 - 50, HEIGHT / 2, "Game Over!");
                    gameOver.setFill(Color.RED);
                    gameOver.setFont(Font.font("Verdana", 20));
                    board.getChildren().add(gameOver);
                    this.stop();
                }
            }
        }.start();
    }

    private void checkHit() {
        for (int i = 0; i < lasers.size(); i++) {
            for (int j = 0; j < drones.size(); j++) {
                if (lasers.get(i).getBoundsInParent().intersects(drones.get(j).getBoundsInParent())) {
                    board.getChildren().remove(drones.get(j));
                    drones.remove(j);
                    board.getChildren().remove(lasers.get(i));
                    lasers.remove(i);
                    score++;
                    scoreText.setText("Score: " + score);
                }
            }
        }
    }

    private void moveDrone(int delta) {
        for (int i = 0; i < drones.size(); i++) {
            if (drones.get(i).getLayoutX() > -drones.get(i).getBoundsInLocal().getWidth()) {
                drones.get(i).relocate(drones.get(i).getLayoutX() + delta, drones.get(i).getLayoutY());
            } else {
                board.getChildren().remove(drones.get(i));
                drones.remove(i);
                lives--;
                livesText.setText("Lives: " + lives);
            }
        }
    }

    private void shoot(int moveAmt) {
        for (int i = 0; i < lasers.size(); i++) {
            if (lasers.get(i).getLayoutX() < WIDTH) {
                lasers.get(i).relocate(lasers.get(i).getLayoutX() + moveAmt, lasers.get(i).getLayoutY());
            } else {
                board.getChildren().remove(lasers.get(i));
                lasers.remove(i);
            }
        }
    }

    private void moveShipTo(double x, double y) {
        if (x >= 0 && x <= 150 && y >= 0 && y <= HEIGHT - shipNode.getBoundsInLocal().getHeight()) {
            shipNode.relocate(x, y);
        }
    }

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        // Starts the game
        launch(args);
    }
}