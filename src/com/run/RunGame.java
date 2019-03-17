package com.run;

import com.entities.GameWorld;
import com.entities.HandleGraphics;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
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

    /**
     * Allows for the player to start the game, pause and resume it.
     *
     * @param btn   Reference Variable.
     * @param scene Reference Variable.
     */
    private void gameButton(Button btn, Scene scene) {
        GameWorld world = new GameWorld(scene);

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

        Canvas[] images = new Canvas[4];

        Button startButton = new Button("Start Game");
        startButton.setVisible(true);

        // Initializes the Canvas
        for (int i = 0; i < images.length; i++) {
            images[i] = new Canvas();
        }

        // Loads the background images for the Canvas'
        addCanvasBackgrounds();

        // Loads the individual images to use for the Nodes
        addImages();

        // Adds the images to the Canvas
        setCanvasBackgrounds(images, root);

        root.getChildren().add(startButton);

        // Setting the layout of the button
        root.getChildren().get(root.getChildren().size() - 1).setTranslateX(SCENE_WIDTH / 2);
        root.getChildren().get(root.getChildren().size() - 1).setTranslateY(SCENE_HEIGHT / 10);

        Scene scene = new Scene(root);

        gameButton(startButton, scene);

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
    private Group setCanvasBackgrounds(Canvas[] images, Group root) {

        // Sets the all the Canvas' backgrounds to an image
        for (int i = 0; i < images.length; i++) {
            images[i].getGraphicsContext2D().setFill(HandleGraphics.getBackground(i));

            root.getChildren().add(images[i]);
        }
        return root;
    }

    /**
     * Adds the images to the static HandleGraphics class.
     */
    private void addCanvasBackgrounds() {
        // Cell 0: backgroundCanvas, 1: groundCanvas, 2: castleCanvas, 3: monsterCanvas.
        try {
            HandleGraphics.addCanvasBackground(new ImagePattern(new Image(new FileInputStream("src/com/images/backgroundCanvas.jpg"))));
            HandleGraphics.addCanvasBackground(new ImagePattern(new Image(new FileInputStream("src/com/images/groundCanvas.png"))));
            HandleGraphics.addCanvasBackground(new ImagePattern(new Image(new FileInputStream("src/com/images/castleCanvas.png"))));
            HandleGraphics.addCanvasBackground(new ImagePattern(new Image(new FileInputStream("src/com/images/monsterCanvas.png"))));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addImages() {
        try {
            // Cell 0: Gun, 1: Bullet, 2: Shooter.
            HandleGraphics.addImage(new ImagePattern(new Image(new FileInputStream("src/com/images/gun.png"))));
            HandleGraphics.addImage(new ImagePattern(new Image(new FileInputStream("src/com/images/bullet.png"))));
            HandleGraphics.addImage(new ImagePattern(new Image(new FileInputStream("src/com/images/shooter.png"))));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}