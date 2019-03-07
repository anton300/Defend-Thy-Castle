package com.run;

import com.entities.GameWorld;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Where all the code and graphics is run.
 *
 * @author Anton Zenin & Patryk Kownacki.
 */
public class RunGame extends Application {
    // The window's (stage) dimensions in pixels
    public static final int STAGE_WIDTH = 1000;
    public static final int STAGE_HEIGHT = 700;

    // The window's dimensions in pixels where all the
    // graphics are displayed and where the game runs
    public static final int SCENE_WIDTH = STAGE_WIDTH - 20;
    public static final int SCENE_HEIGHT = STAGE_HEIGHT - 20;

    private static int buttonClicked = -1;

    public static void main(String[] args) {
        // Starts the game
        launch(args);
    }

    /**
     * Where all the user created JavaFX code is executed.
     *
     * @param stage Reference variable.
     */
    @Override
    public void start(Stage stage) {
        Button btn = setUpStage(stage);

//        gameButton(btn);

        // Makes the stage (window) visible
        stage.show();
    }

    private void gameButton(Button btn) {
        GameWorld world = new GameWorld();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Determines when to set the text of the button to pause or
                // resume.
                buttonClicked *= -1;

                world.playGame();

                // If the counter is 1
                if (buttonClicked > 0) {
                    btn.setText("Pause");

                    // If the counter is -1
                } else {
                    btn.setText("Resume");
                }
            }
        });
    }

    /**
     * Creates the graphics and renders them at or around 60 FPS.
     */
    private void createGameGraphics(Canvas canvas) {
//        GraphicsContext gc = canvas.getGraphicsContext2D();

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
    }

    /**
     * Gives all the elements to make a window appear with the game on it.
     */
    private Button setUpStage(Stage stage) {
        VBox pane = new VBox(5);

        Button btn = new Button("Start Game");
        btn.setVisible(true);

        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);

        pane.getChildren().addAll(canvas);
        pane.setPadding(new Insets(15));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(pane, btn);

        Scene scene = new Scene(stackPane, SCENE_WIDTH, SCENE_HEIGHT);

        createGameGraphics(canvas);

        stage.setScene(scene);

        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setTitle("Defend Thy Castle");

        return btn;
    }
}