package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;


public class SimpleEnemy extends Enemy implements Animatable, Interactable {

    public SimpleEnemy() {
        super(10, 1, 0);
        setImage(Globals.getInstance().getImage("SimpleEnemy"));
    }
}
