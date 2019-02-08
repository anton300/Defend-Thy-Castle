
package testsquare;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Monster {
    protected int health; 
    protected int speed;
    protected boolean isAlive; 
    protected boolean isGameRunning;

    public Monster(int health, int speed, boolean isAlive, boolean isGameRunning) {
        this.health = health;
        this.speed = speed;
        this.isAlive = isAlive;
        this.isGameRunning = isGameRunning;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    } 
    
    
    //moveMonster method, an algorythm that moves the monster from point A to B
    public Rectangle moveMonster(Image image,int rectX, int rectY, int rectWidth, int rectHeight){    
        Rectangle rectangle= new Rectangle(rectX,rectY,rectWidth,rectHeight);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectangle.xProperty(), 191);
        final KeyFrame kf = new KeyFrame(Duration.seconds(getSpeed()),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();  
        rectangle.setFill(new ImagePattern(image));
        System.out.println(kf.getTime());
        BooleanBinding intersecting = rectangle.xProperty().lessThanOrEqualTo(191); 
        intersecting.addListener((obs,wasIntersecting,isNowIntersecting)->{
            rectangle.setFill(Color.RED);
        }); 
        return rectangle;
    }
    //paints the monster
    public Image paintMonster(Image image,int rectX, int rectY, int rectWidth, int rectHeight){
        ImageView viewImage = new ImageView();
        viewImage.setImage(image);
        viewImage.setLayoutX(rectX);
        viewImage.setLayoutY(rectY);
        viewImage.setFitHeight(rectWidth);
        viewImage.setFitWidth(rectHeight);
        return image;
    }
}
