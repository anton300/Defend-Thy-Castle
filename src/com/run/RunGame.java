package com.run;

import com.entities.GameWorld;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RunGame extends Application {
    // The window's dimensions in pixels
    public static final int STAGE_WIDTH = 1000;
    public static final int STAGE_HEIGHT = 700;

    public static final int CANVAS_WIDTH = STAGE_WIDTH - 20;
    public static final int CANVAS_HEIGHT = STAGE_HEIGHT - 20;

    private static int buttonClicked = -1;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Where all the JavaFX code is executed.
     *
     * @param stage Reference variable
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws IOException {
        GameWorld world = new GameWorld();

        gameButton(world);

        setUpStage(stage);
    }

    private void gameButton(GameWorld world) {
        Button btn = new Button("Start Game");
        btn.setLocation(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 4);
        btn.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Determines if the button was clicked or not.
                // 1 to start/resume the game, and -1 to pause it.
                buttonClicked *= -1;

                if (buttonClicked > 0) {
                    btn.setLabel("Pause");
                    world.playGame();

                } else {
                    btn.setLabel("Resume");
                    world.playGame();
                }
            }
        });
    }

    /**
     * Gives all the elements to make a window appear with the game on it.
     */
    private void setUpStage(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setTitle("Defend Thy Castle");

        GraphicsContext gc = canvas.getGraphicsContext2D();

        /* Retrieved from:
         https://gamedevelopment.tutsplus.com
         /tutorials/introduction-to-javafx-for-game-development--cms-23835
         Lee Stemkoski - A professor of mathematics and
         computer science with interests in 3D graphics
         and game development, 19th of May, 2015. */

        // Gets the time in nano seconds
        /* final long startNanoTime = System.nanoTime();

        // Allows for 60 FPS graphics rendering
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double time = (currentNanoTime - startNanoTime) / 1000000000.0d;

                // Graphics here
            }
        }.start(); */

        stage.show();
    }
}