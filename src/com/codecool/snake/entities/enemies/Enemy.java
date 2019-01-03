package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.powerups.Laser;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.Random;

public abstract class Enemy extends GameEntity implements Animatable, Interactable {
    private final int damage;
    private static Random rnd = new Random();
    private Point2D heading;
    private int speed;
    private float turnRate;

    public Enemy(int damage, int speed, float turnRate) {
        super();
        this.damage = damage;
        this.speed = speed;
        this.turnRate = turnRate;
        setPositionAtRandom();
        double direction = setDirectionAtRandom();
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }

    public double setDirectionAtRandom() {
        return rnd.nextDouble() * 360;
    }

    public void setPositionAtRandom() {
        double x = rnd.nextDouble() * Globals.WINDOW_WIDTH;
        setX(x);
        Snake snake = Globals.getInstance().game.getSnake();
        while (true) {
            double y = rnd.nextDouble() * Globals.WINDOW_HEIGHT;
            setY(y);
            if (!onSnakeHead(this, snake)) {
                break;
            }
        }
    }

    public int getDamage() {
        return damage;
    }

    public boolean onSnakeHead(Enemy enemy, Snake snake) {
        SnakeHead head = snake.getHead();
        return head.getBoundsInParent().intersects(enemy.getBoundsInParent());
    }

    public Point2D getHeading() {
        return heading;
    }

    public static Random getRandom() {
        return rnd;
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }
        if (entity instanceof Laser) {
            destroy();
        }
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        double headRotation = getRotate() - turnRate;

        // set rotation and position
        setRotate(headRotation);
        Point2D heading = Utils.directionToVector(headRotation, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}
