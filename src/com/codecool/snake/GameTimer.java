package com.codecool.snake;

import com.codecool.snake.entities.powerups.Heart;
import com.codecool.snake.entities.powerups.SpeedBoost;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.List;


public class GameTimer {
    private static final double DEFAULT_60_FPS = 0.017;
    private double frameTime;
    private Timeline timer = new Timeline();
    private static List<Timeline> timers = new LinkedList<>();

    public static List<Timeline> getTimers(){
        return timers;
    }

    GameTimer() {
        this(DEFAULT_60_FPS);
    }

    GameTimer(double frameTime) {
        this.frameTime = frameTime;
        timers.add(timer);
        System.out.println("GameTimer created with frame time: " + frameTime);
    }

    public void setup(Runnable loopMethod) {
        timer.setCycleCount( Timeline.INDEFINITE );

        KeyFrame kf = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> loopMethod.run());

        timer.getKeyFrames().add( kf );
    }

    public void setup(String powerUp){
        timer.setCycleCount( Timeline.INDEFINITE );
        if (powerUp.equals("Heart")){

            KeyFrame powerUpMaker = new KeyFrame(
                    Duration.seconds(frameTime*300),
                    ae -> new Heart());

            KeyFrame stopper = new KeyFrame(
                    Duration.seconds(frameTime*310),
                    ae -> stop());

            timer.getKeyFrames().add( powerUpMaker );
            timer.getKeyFrames().add( stopper );

        } else if (powerUp.equals("SpeedBoost")){

            KeyFrame powerUpMaker = new KeyFrame(
                    Duration.seconds(frameTime*500),
                    ae -> new SpeedBoost());

            KeyFrame powerUpEnder = new KeyFrame(
                    Duration.seconds(frameTime*300),
                    ae -> Globals.getInstance().game.getSnake().setSpeed(2));

            KeyFrame stopper = new KeyFrame(
                    Duration.seconds(frameTime*510),
                    ae -> stop());

            timer.getKeyFrames().add( powerUpMaker );
            timer.getKeyFrames().add( powerUpEnder );
            timer.getKeyFrames().add( stopper );
        }
    }

    public void play() {
        timer.play();
        System.out.println("GameTimer playing.");
    }

    public void stop(){
        System.out.println("GameTimer stopping.");
        timers.remove(this.timer);
        timer.stop();
    }

    public double getFrameTime() {
        return frameTime;
    }
}
