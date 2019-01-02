package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import java.awt.*;
import java.util.List;

import com.codecool.snake.entities.snakes.Snake;
import javafx.scene.layout.Pane;
import javafx.scene.*;

import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.ButtonBase;

public class Display {
    private Pane displayPane;
    private DelayedModificationList<GameEntity> gameObjects = new DelayedModificationList<>();

    public Display(Pane pane) {
        displayPane = pane;
    }

    public void add(GameEntity entity) {
        displayPane.getChildren().add(entity);
        gameObjects.add(entity);
    }

    public void remove(GameEntity entity) {
        displayPane.getChildren().remove(entity);
        gameObjects.remove(entity);
    }

    public List<GameEntity> getObjectList() {
        return gameObjects.getList();
    }

    public void frameFinished() {
        gameObjects.doPendingModifications();
    }

    public void updateSnakeHeadDrawPosition(GameEntity snakeHead) {
        displayPane.getChildren().remove(snakeHead);
        displayPane.getChildren().add(snakeHead);
    }

    public void clear() {
        displayPane.getChildren().clear();
        gameObjects.clear();
    }


    public class GameOverPopup {

        public void displayGameOver(){

            Stage popupwindow = new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Game over!");

            Label label = new Label("Game over!");

            Button button = new Button("Close this pop up window");
            //button.setOnAction(e -> popupwindow.close());

            VBox layout = new VBox(10);

            //layout.getChildren().addAll(label, button);

            layout.setAlignment(Pos.CENTER);

            Scene scene1 = new Scene(layout, 300, 250);
            popupwindow.setScene(scene1);
            popupwindow.show();

        }

    }
}
