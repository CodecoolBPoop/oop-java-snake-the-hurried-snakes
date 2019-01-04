package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;

import java.util.Random;


public class Heart extends GameEntity implements Interactable {
    private static Random rnd = new Random();
    private int healing = rnd.nextInt(20);

    public Heart() {
        setImage(Globals.getInstance().getImage("PowerUpHeart"));

        setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH - 50));
        setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT - 50));
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            Globals.newTimer("Heart");
            destroy();
        }
    }

    public int getHealing() {
        return healing;
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
