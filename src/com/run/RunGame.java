package com.run;

import com.entities.GameWorld;
import com.entities.HandleGraphics;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        setUpStage(stage);

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

                // If the counter is 1
                if (buttonClicked > 0) {
                    btn.setText("Pause");

                    // If the counter is -1
                } else {
                    btn.setText("Resume");
                }
//                world.playGame();
            }
        });
    }

    /**
     * Gives all the elements to make a window appear with the game on it.
     */
    private void setUpStage(Stage stage) {
        VBox pane = new VBox(5);

        Button btn = new Button("Start Game");
        btn.setVisible(true);

        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);

        // Loads in the graphics and the canvas that they are on
        addImages();
        HandleGraphics.setCanvas(canvas);

        pane.getChildren().addAll(HandleGraphics.getCanvas());

        pane.setPadding(new Insets(15));

        StackPane stackPane = new StackPane();

        // The button that starts the game on the screen
        gameButton(btn);

        stackPane.getChildren().addAll(pane, btn);

        Scene scene = new Scene(stackPane, SCENE_WIDTH, SCENE_HEIGHT);

        stage.setScene(scene);

        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setTitle("Defend Thy Castle");
    }

    private void addImages() {
        try {
            HandleGraphics.addGraphic(new Image(new FileInputStream("images/castle.png")));

            HandleGraphics.addGraphic(new Image(new FileInputStream("images/clouds.jpg")));

            HandleGraphics.addGraphic(new Image(new FileInputStream("images/ground.png")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}