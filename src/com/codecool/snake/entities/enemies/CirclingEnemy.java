package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;


public class CirclingEnemy extends Enemy implements Animatable, Interactable {


    public CirclingEnemy() {
        super(20, 2, 2);
        setImage(Globals.getInstance().getImage("SimpleEnemy"));
    }
}
