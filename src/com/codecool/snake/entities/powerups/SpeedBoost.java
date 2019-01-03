package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;

import java.util.Random;


public class SpeedBoost extends GameEntity implements Interactable {
    private static Random rnd = new Random();
    private float newSpeed = 3;

    public SpeedBoost() {
        setImage(Globals.getInstance().getImage("PowerUpBoost"));

        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            Globals.newTimer("SpeedBoost");
            destroy();
        }
    }



    public float getNewSpeed() {
        return newSpeed;
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
