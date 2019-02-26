package com.entities;

/**
 * Makes sure that each Component or Object has a method
 * that determines if it is running or not. To make the
 * pause/resume feature handy.
 *
 * @author Anton Zenin
 */
interface RunComponentI {
    boolean runObject(boolean b);
}