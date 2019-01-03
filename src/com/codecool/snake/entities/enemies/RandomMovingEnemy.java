package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;


public class RandomMovingEnemy extends Enemy implements Animatable, Interactable {
    private static float turnRate;
    private static final int speed = 2;

    public RandomMovingEnemy() {
        super(20, 2, getRandom().nextFloat() * 10 - 5);
        setImage(Globals.getInstance().getImage("SimpleEnemy"));
    }

    @Override
    public void step() {
        super.step();
        setX(getX() + getHeading().getX());
        setY(getY() + getHeading().getY());
    }
}
