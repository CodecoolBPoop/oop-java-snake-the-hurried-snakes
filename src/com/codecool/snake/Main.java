package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

        game.start();
        spawnRestart(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Exiting...");
    }

    private void spawnRestart(Stage primaryStage) {
        Button btn = new Button("Restart");
        Globals.getInstance().display.addButton(btn);
        btn.setOnAction((event -> {
            System.out.printf("Restart is clicked%n");
            start(primaryStage);
        }));

    }
}
