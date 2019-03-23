/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacecity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.input.KeyEvent;
import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class SpaceCity extends Application {

    //We will be using a CSS file that will connect to our JavaFX application 
    //this will be used for setting a global text font, text color, etc. 
    Image spaceShip = new Image("spacecity/spaceship.png");

    Image cloudCity = new Image("spacecity/cloud-city-background-427801.jpg");

    int postionOfShip = 0;

    Rectangle shipRect = new Rectangle(0, postionOfShip, 191, 300);

    @Override
    public void start(Stage primaryStage) {

        Rectangle background = new Rectangle(0, 0, 1500, 800);
        background.setFill(new ImagePattern(cloudCity));

        Button buttonOne = new Button();//what initializes the ship
        buttonOne.setLayoutX(0);
        buttonOne.setLayoutY(postionOfShip);//starting Y position of the ship
        buttonOne.setBackground(null);

        Rectangle uiW = new Rectangle(650, 100, 100, 100);//just the W rectangle on the screen
        uiW.setFill(Color.YELLOW);
        Rectangle uiS = new Rectangle(825, 100, 100, 100);//just the S rectangle on the screen
        uiS.setFill(Color.YELLOW);

        Label label = new Label("W");//the W letter corresponding with the uiW rectangle
        label.setLayoutX(690);
        label.setLayoutY(135);

        Label label2 = new Label("S");//the S letter corresponding with the uiS rectangle
        label2.setLayoutX(865);
        label2.setLayoutY(135);

        shipRect.setFill(new ImagePattern(spaceShip));

        Pane root = new Pane();

        buttonOne.setOnKeyPressed(//key event for the button which configures the ship
                event -> {
                    // start movement according to key pressed
                    switch (event.getCode()) {
                        case W://if user press W, moves ship up by 15
                            uiS.setFill(Color.YELLOW);
                            shipRect.setFill(null);//sets previous image to null
                            postionOfShip = postionOfShip - 15;//adjusts the position by -15
                            shipRect = new Rectangle(0, postionOfShip, 191, 300);
                            System.out.println(postionOfShip);
                            shipRect.setFill(new ImagePattern(spaceShip));//creates new image
                            uiW.setFill(Color.RED);
                            root.getChildren().add(shipRect);
                            break;
                        case S://if user press S, moves ship up by 15
                            uiW.setFill(Color.YELLOW);
                            shipRect.setFill(null);//sets previous image to null
                            postionOfShip = postionOfShip + 15;//adjusts the position by +15
                            shipRect = new Rectangle(0, postionOfShip, 191, 300);
                            System.out.println(postionOfShip);
                            shipRect.setFill(new ImagePattern(spaceShip));//creates new image
                            uiS.setFill(Color.RED);
                            root.getChildren().add(shipRect);
                            break;
                    }
                });

        root.getChildren().addAll(background, shipRect, buttonOne, uiW, uiS, label, label2);
        Scene scene = new Scene(root, 1500, 800);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
