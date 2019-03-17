package com.entities;

/**
 * This class creates the gun for the shooter.
 *
 * @author Anton Zenin.
 */
public class Gun {
    private Bullet bullet;
    // The angle of the gun with respect to the mouse
    private double gunElevation;

    // From where the gun is shooting
    private double[] firingPoint = new double[2];

    // The range that you can aim. 10 to 170 degrees (160 degrees of freedom)
    public static final int MAX_GUN_ELEVATION = 10;
    public static final int MIN_GUN_ELEVATION = 170;

    // Constructor
    public Gun(int damage, int damageBoost, int[] firingPoint) {
        this.gunElevation = 90;

        // Creates the point from which the code knows where
        // shoot the bullet from, the origin point (0, 0)
        this.firingPoint[0] = firingPoint[0];
        this.firingPoint[1] = firingPoint[1];

        // Creates the bullet
        this.bullet = new Bullet(damage, damageBoost, firingPoint);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public double getGunElevation() {
        return gunElevation;
    }

    /**
     * Sets the gun elevation within a range of degrees.
     *
     * @param newGunElevation The new gun elevation.
     */
    public void setGunElevation(double newGunElevation) {
        // Gun elevation is in degrees. If the value is within the range of the elevation.
        // From 10 to 170 degrees, if it is in that range, then it will assign it to that value.
        if (newGunElevation >= MAX_GUN_ELEVATION && newGunElevation <= MIN_GUN_ELEVATION) {
            gunElevation = newGunElevation;
        }

        /* If the gun elevation is over the max limit, then it
           assign it to the max elevation. Meaning it never goes
           over the limit. */
        if (newGunElevation < MAX_GUN_ELEVATION) {
            gunElevation = MAX_GUN_ELEVATION;
        }

        // Same thing here, but for the minimum gun elevation
        if (newGunElevation > MIN_GUN_ELEVATION) {
            gunElevation = MIN_GUN_ELEVATION;
        }
    }
}