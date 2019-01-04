package com.codecool.snake.entities.healthBar;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.codecool.snake.Globals.WINDOW_WIDTH;

public class HealthBar extends GameEntity {

    public HealthBar(){
        setImage(Globals.getInstance().getImage("HealthHeart"));

        setX(WINDOW_WIDTH-140);
        setY(20);

        writeHealth(100);

    }

    public void writeHealth(int health){
        ObservableList<Node> gameChildren = Globals.getInstance().game.getChildren();

        for (int i = 0; i < gameChildren.size(); i++){
            if (gameChildren.get(i) instanceof Text) {
                gameChildren.remove(i);
            }
        }

        String healthString = String.valueOf(health);
        Text healthText = new Text(WINDOW_WIDTH-105, 95, healthString);
        healthText.setFont(Font.font ("Verdana", 30));

        gameChildren.add(healthText);
    }

}
