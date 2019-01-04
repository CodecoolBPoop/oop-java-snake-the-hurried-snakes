package com.codecool.snake;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Scene mainScene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        Globals.getInstance().setPrimaryStage(primaryStage);

        game.start();
        spawnRestart(primaryStage);

        Globals.getInstance().setMain(this);
    }

    @Override
    public void stop() throws Exception {
        System.out.printf("Exiting...%n");
    }

    private void spawnRestart(Stage primaryStage) {
        Button btn = new Button("Restart");
        Globals.getInstance().display.addButton(btn);
        btn.setOnAction((event -> {
            Globals.getInstance().stopGame();
            stopAllTimers();
            start(primaryStage);
        }));

    }

    public void stopAllTimers() {
        List<Timeline> timers = GameTimer.getTimers();

        for (Timeline timer : timers) {
            timer.stop();
        }
    }


}
