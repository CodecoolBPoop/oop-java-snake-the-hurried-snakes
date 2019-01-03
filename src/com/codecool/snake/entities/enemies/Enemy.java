package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.Random;

public abstract class Enemy extends GameEntity{
    private final int damage;
    private static Random rnd = new Random();
    private Point2D heading;

    public Enemy(int damage, int speed) {
        super();
        this.damage = damage;
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
}
