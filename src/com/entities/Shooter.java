package com.entities;

import com.run.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class creates the shooter with all it's components to play the game.
 *
 * @author Anton Zenin
 */
public class Shooter implements RunComponentI {
    private Gun gun;
    private Bomb bomb;

    private static final int[] GUN_ANCHOR_POINT = {250, 250};

    public Shooter() throws IOException {
        gun = new Gun(35, 0, GUN_ANCHOR_POINT);

        int[] dropPointCoor = {RunGame.CANVAS_HEIGHT, RunGame.CANVAS_WIDTH / 2};
        bomb = new Bomb(500, dropPointCoor, new Image(new FileInputStream("")));
    }

    public Gun getGun() {
        return gun;
    }

    public Bomb getBomb() {
        return bomb;
    }
}