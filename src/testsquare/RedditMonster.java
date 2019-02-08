/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsquare;
/**
 *
 * @author Owner
 */

//RedditMonster class
public class RedditMonster extends Monster{
    
    public RedditMonster(int health,int speed, boolean isAlive, boolean isGameRunning) {
        super(health, speed, isAlive, isGameRunning);
    }   

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isIsAlive() {
        return isAlive;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    
}
