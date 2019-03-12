package com.run;

import com.entities.GameWorld;
import com.entities.HandleGraphics;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        Group root = new Group();
        Canvas[] images = new Canvas[7];
        Button startButton = new Button("Start Game");

        for (int i = 0; i < images.length; i++) {
            images[i] = new Canvas();
        }

        // Adds the images to the HandleGraphics static Class
        addImages();

        // Adds the to the Canvas's
        setImages(images);

        // Cell 0: background, 1: ground, 2: gun, 3: shooter, 4: castle, 5: monsters, 6: bullet
        root.getChildren().addAll(images[0], images[1], images[2], images[3], images[4], images[5], images[6], startButton);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setTitle("Defend Thy Castle");
    }

    /**
     * Sets each graphic to a Canvas.
     *
     * @param images Canvas Array Reference Variable.
     */
    private void setImages(Canvas[] images) {
        GraphicsContext context;

        for (int i = 0; i < images.length; i++) {
            context = images[i].getGraphicsContext2D();
        }
    }

    /**
     * Adds the images to the static HandleGraphics class.
     */
    private void addImages() {
        try {
            HandleGraphics.addGraphic(new ImagePattern(new Image(new FileInputStream("images/castle.png"))));

            HandleGraphics.addGraphic(new ImagePattern(new Image(new FileInputStream("images/clouds.jpg"))));

            HandleGraphics.addGraphic(new ImagePattern(new Image(new FileInputStream("images/ground.png"))));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}