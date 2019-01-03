package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;


import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Point2D;



public class Laser extends GameEntity implements Interactable {
    private double headRotation;
    private Point2D heading;
    private int speed;

    public Laser(Vec2d position, double headRotation) {
        setImage(Globals.getInstance().getImage("Laser"));

        // Laser appears at top of snake
        setX(position.x);
        setY(position.y);

        // Lets give it a heading
        System.out.printf("The initial heading is %s%n", headRotation);
        setRotate(headRotation - 90);






    }

    @Override
    public void apply(GameEntity entity) {
        // if some key is presses
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            new Berry();
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return "Shoot!";
    }
}
