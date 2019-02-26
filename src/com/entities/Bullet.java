package com.entities;

/**
 * This class creates the bullet with it's physics.
 *
 * @author Anton Zenin
 */
public class Bullet implements RunComponentI {
    private final int velocity = 5;
    private int damage;
    private int damageBoost;
    private int[] travelPoint = new int[2];
//    private int angle;

    public Bullet(int damage, int damageBoost, int[] mouseXY) {
        this.damage = damage;
        this.damageBoost = damageBoost;

        this.travelPoint[0] = mouseXY[0];
        this.travelPoint[1] = mouseXY[1];
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public void setDamageBoost(int damageBoost) {
        this.damageBoost = damageBoost;
    }

    public void addDamageBoost(int damageBoost) {
        this.damage += damageBoost;
    }
}