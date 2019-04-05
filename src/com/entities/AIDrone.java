package com.entities;

public class AIDrone {
    private int health;
    private double speed;

    public AIDrone(int health, double speed) {
        this.health = health;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public synchronized void damageAi(int damageTaken, AIDrone drone) {

        if (drone instanceof Drone) {
            Drone drone1 = (Drone) drone;
            drone1.damageBy(damageTaken);
        }

//        if (drone instanceof anotherDrone) {
//            // Do the same as the first if condition
//        }

        // Do as many of these as there are subclasses of type AIDrone (superclass)
    }
}