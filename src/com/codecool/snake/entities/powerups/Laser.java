package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.snakes.SnakeHead;


import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Point2D;



public class Laser extends GameEntity implements Interactable, Animatable {
    private Point2D heading;

    public Laser(Vec2d position, double headRotation) {
        setImage(Globals.getInstance().getImage("Laser"));

        // Laser appears at top of snake
        setX(position.x);
        setY(position.y);

        // Lets give it a heading
        setRotate(headRotation - 90);

        // The laser moves and shoots and kills
        int speed = 7;
        heading = Utils.directionToVector(headRotation, speed);
    }

    @Override
    public void apply(GameEntity entity) {
        // if some key is presses
        if(entity instanceof Enemy){
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return "Shoot!";
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }
}
