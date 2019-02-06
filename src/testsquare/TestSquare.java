/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsquare;

import static java.awt.Color.BLUE;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Owner
 */
public class TestSquare extends Application {
    
    //pane public and accessible to whole class
    public static Pane root = new Pane();   
    //scene public and accessible to whole class
    public static Scene scene = new Scene(root, 1500, 800);

    @Override
    public void start(Stage primaryStage) { 
        
        //creating a type of Image so it will be read into a method that will print the monster on the screen
        Image imageReddit;
        //This creates a new monster, the reddit monster
        RedditMonster reddit = new RedditMonster(1,20,true,true); 
        //This creates the image for the reddit monster, it is assigned to a type image
        Image redditMonsterImage = reddit.paintMonster(imageReddit = new Image("images/reddit.png"), 1300, 600, 112, 211);
        //This lets the monster move on the map, it is assigned to a type Rectangle
        Rectangle redditMonster =  reddit.moveMonster(redditMonsterImage, 1400, 600, 100, 100);
        
        //This method prints the map (for now, version one)
        printMap();
        //This adds the moving monster to the pane
        root.getChildren().addAll(redditMonster);
        //Names the screen "Test scene!"
        primaryStage.setTitle("Test scene!");
        //sets the scene
        primaryStage.setScene(scene);
        //shows the scene
        primaryStage.show();     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //print map method
    public static void printMap(){
      
        //Creates an array of type Image, will store any images used in an array data structure
        Image[] image = new Image[5];
        image[0] = new Image("images/clouds.jpg");
        image[1] = new Image("images/ground.png");
        image[2] = new Image("images/ground.png");
        image[3] = new Image("images/ground.png");
        image[4] = new Image("images/castle.png");
        
        //Creates an array of type ViewImage, will view as many images as you want (assigning the array size of course)
        ImageView[] viewImage = new ImageView[5];
        //image one
        viewImage[0] = new ImageView(image[0]);
        //image two
        viewImage[1] = new ImageView(image[1]);
        //image three 
        viewImage[2] = new ImageView(image[2]); 
        //image four
        viewImage[3] = new ImageView(image[3]); 
        //image five
        viewImage[4] = new ImageView(image[4]); 

        //setting the image to view image one (cloud image)
        viewImage[0].setImage(image[0]);
        //Setting the preserve ratio of the image view 
        viewImage[0].setPreserveRatio(true);

        //setting the image to view image two (ground image)
        viewImage[1].setImage(image[1]);
        viewImage[1].setLayoutX(0);
        viewImage[1].setLayoutY(700);
        //Setting the preserve ratio of the image view 
        viewImage[1].setPreserveRatio(true);
        
        //setting the image to view image three (ground image)
        viewImage[2].setImage(image[2]);
        viewImage[2].setLayoutX(600);
        viewImage[2].setLayoutY(700);
        viewImage[2].setPreserveRatio(true);
        
        //setting the image to view image four (ground image)
        viewImage[3].setImage(image[3]);
        viewImage[3].setLayoutX(1200);
        viewImage[3].setLayoutY(700);
        viewImage[3].setPreserveRatio(true);
        
        //setting the image to view image five (castle image)
        viewImage[4].setImage(image[4]);
        viewImage[4].setLayoutX(-100);
        viewImage[4].setLayoutY(400);
        viewImage[4].setPreserveRatio(true);
        
        //adds all the children to the pane
        root.getChildren().addAll(viewImage[0],viewImage[1],viewImage[2],viewImage[3],viewImage[4]);
       
    }
}
