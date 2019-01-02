package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.snakes.Snake;
import java.util.Random;

import javafx.geometry.Point2D;



public class SimpleEnemy extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();

    public SimpleEnemy() {
        super(10);

        setImage(Globals.getInstance().getImage("SimpleEnemy"));

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

        double direction = rnd.nextDouble() * 360;
        setRotate(direction);

        int speed = 1;
        heading = Utils.directionToVector(direction, speed);
    }

    private boolean onSnakeHead(SimpleEnemy enemy, Snake snake) {
        SnakeHead head = snake.getHead();
        return head.getBoundsInParent().intersects(enemy.getBoundsInParent());
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}
