package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.snakes.Snake;

import java.util.List;

public class GameLoop {
    private Snake snake;
    private boolean running = false;
    private long stepNumber = 0;

    public GameLoop(Snake snake) { this.snake = snake; }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void step() {
        if(running) {
            snake.step();
            for (GameEntity gameObject : Globals.getInstance().display.getObjectList()) {
                if (gameObject instanceof Animatable) {
                    ((Animatable) gameObject).step();
                }
            }
            stepNumber++;
            spawnNewEnemy(3);
            checkCollisions();
        }
        Globals.getInstance().display.frameFinished();
    }

    private void spawnNewEnemy(int secondsBetweenTwoSpawning) {
        double stepDuration = Globals.getInstance().game.getGameTimer().getFrameTime();
        if (Math.ceil(stepNumber * stepDuration) % (secondsBetweenTwoSpawning + 1) == 0) {
            new SimpleEnemy();
            stepNumber = 0;
        }
    }

    private void checkCollisions() {
        List<GameEntity> gameObjs = Globals.getInstance().display.getObjectList();
        for (int idxToCheck = 0; idxToCheck < gameObjs.size(); ++idxToCheck) {
            GameEntity objToCheck = gameObjs.get(idxToCheck);
            if (objToCheck instanceof Interactable) {
                for (int otherObjIdx = idxToCheck + 1; otherObjIdx < gameObjs.size(); ++otherObjIdx) {
                    GameEntity otherObj = gameObjs.get(otherObjIdx);
                    if (otherObj instanceof Interactable){
                        if(objToCheck.getBoundsInParent().intersects(otherObj.getBoundsInParent())){
                            ((Interactable) objToCheck).apply(otherObj);
                            ((Interactable) otherObj).apply(objToCheck);
                        }
                    }
                }
            }
        }
    }
}
