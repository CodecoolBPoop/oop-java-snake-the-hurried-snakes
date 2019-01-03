package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.powerups.Berry;

import com.codecool.snake.entities.powerups.Heart;
import com.codecool.snake.entities.powerups.Laser;
import com.codecool.snake.entities.powerups.SpeedBoost;
import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Point2D;


public class SnakeHead extends GameEntity implements Interactable {
    private static final float turnRate = 2;
    private Snake snake;

    public SnakeHead(Snake snake, Vec2d position) {
        this.snake = snake;
        setImage(Globals.getInstance().getImage("SnakeHead"));
        setPosition(position);
    }

    public void updateRotation(SnakeControl turnDirection, float speed) {
        double headRotation = getRotate();

        if (turnDirection.equals(SnakeControl.TURN_LEFT)) {
            headRotation = headRotation - turnRate;
        }
        if (turnDirection.equals(SnakeControl.TURN_RIGHT)) {
            headRotation = headRotation + turnRate;
        }

        // set rotation and position
        setRotate(headRotation);
        Point2D heading = Utils.directionToVector(headRotation, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        if (turnDirection.equals(SnakeControl.SHOOT)) {
            new Laser(getPosition(), headRotation);
        }
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof Enemy){
            System.out.println(getMessage());
            int damage = -((Enemy) entity).getDamage();
            snake.changeHealth(damage);
        }
        if(entity instanceof Berry){
            snake.addPart(4);
        }
        if(entity instanceof Heart){
            snake.changeHealth(((Heart) entity).getHealing());
        }
        if(entity instanceof SpeedBoost){
            snake.setSpeed(((SpeedBoost) entity).getNewSpeed());
        }
    }

    @Override
    public String getMessage() {
        return "IMMA SNAEK HED! SPITTIN' MAH WENOM! SPITJU-SPITJU!";
    }
}
