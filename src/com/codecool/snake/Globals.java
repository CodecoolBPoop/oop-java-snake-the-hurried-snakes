package com.codecool.snake;

import com.codecool.snake.resources.Resources;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// class for holding all static stuff
public class Globals {
    private static Globals instance = null;

    public static final double WINDOW_WIDTH = 1800;
    public static final double WINDOW_HEIGHT = 1000;

    public Display display;
    public Game game;

    private GameLoop gameLoop;
    private Resources resources;

    public Stage primaryStage;
    public Main main;

    public static Globals getInstance() {
        if(instance == null) instance = new Globals();
        return instance;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void setupResources() {
        resources = new Resources();
        resources.addImage("HealthHeart", new Image("health_heart.png"));
        resources.addImage("SnakeHead", new Image("snake_head.png"));
        resources.addImage("SnakeBody", new Image("snake_body.png"));
        resources.addImage("CirclingEnemy", new Image("circling_enemy.png"));
        resources.addImage("RdmMovingEnemy", new Image("rdmmoving_enemy.png"));
        resources.addImage("SimpleEnemy", new Image("simple_enemy.png"));
        resources.addImage("PowerUpBerry", new Image("powerup_berry.png"));
        resources.addImage("PowerUpBoost", new Image("powerup_speed_boost.png"));
        resources.addImage("PowerUpHeart", new Image("powerup_heart.png"));
        resources.addImage("Laser", new Image("bullet.png"));
    }

    public static void newTimer(String powerUp){
        GameTimer powerUpTimer = new GameTimer();
        powerUpTimer.setup(powerUp);
        powerUpTimer.play();
    }

    public Image getImage(String name) { return resources.getImage(name); }

    public void startGame() { gameLoop.start(); }

    public void stopGame() { gameLoop.stop(); }

    private Globals() {
        // singleton needs the class to have private constructor
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
