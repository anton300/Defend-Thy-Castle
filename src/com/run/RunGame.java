package com.run;

import com.entities.GameWorld;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RunGame extends Application {
    // The window's dimensions in pixels
    public static final int STAGE_WIDTH = 1000;
    public static final int STAGE_HEIGHT = 700;

    public static final int PANE_WIDTH = STAGE_WIDTH - 20;
    public static final int PANE_HEIGHT = STAGE_HEIGHT - 20;

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
        // Makes a Stage
        stage = new Stage();
        VBox pane = new VBox(10);
        // Sets the scene of the Stage
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);

        GameWorld world = new GameWorld();
        gameButton(world);

        setUpStage(stage, scene);
    }

    private void gameButton(GameWorld world) {
        Button btn = new Button("Start Game");
        btn.setLocation(PANE_WIDTH / 2, PANE_HEIGHT / 4);
        btn.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Determines if the button was clicked or not.
                // 1 to start/resume the game, and -1 to pause it.
                buttonClicked *= -1;

                if (buttonClicked > 0) {
                    btn.setLabel("Pause");
                    world.playGame(true);

                } else {
                    btn.setLabel("Resume");
                    world.playGame(false);
                }
            }
        });
    }

    /**
     * Gives all the elements to make a window appear with the game on it.
     *
     * @param stage
     * @param scene
     */
    private void setUpStage(Stage stage, Scene scene) {
        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setScene(scene);
        stage.setTitle("Defend Thy Castle");
        stage.show();
    }
}