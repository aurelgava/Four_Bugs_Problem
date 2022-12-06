package com.example.four_bugs_problem;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloController {


    public Circle bug1;
    public Circle bug2;
    public Circle bug3;
    public Circle bug4;
    public AnchorPane canvas;
    boolean timerRunning=false;
    private final double deltaR = 5;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            moveTowards(bug1,bug2);
            moveTowards(bug2,bug3);
            moveTowards(bug3,bug4);
            moveTowards(bug4,bug1);
            if(bug1.intersects(bug2.getBoundsInParent()) && bug2.intersects(bug3.getBoundsInParent())
                && bug3.intersects(bug4.getBoundsInParent()) && bug4.intersects(bug1.getBoundsInParent()) ){
                timer.stop();
                timerRunning=false;
            }
        }
    };

    private void moveTowards(Circle b1, Circle b2) {
        double alfa = Math.atan2(b2.getCenterY() - b1.getCenterY(), b2.getCenterX() - b1.getCenterX());
        double deltaX = deltaR * Math.cos(alfa);
        double deltaY = deltaR * Math.sin(alfa);
        b1.setCenterX(b1.getCenterX() + deltaX);
        b1.setCenterY(b1.getCenterY() + deltaY);
        Circle dot = new Circle();
        dot.setCenterX(b1.getCenterX());
        dot.setCenterY(b1.getCenterY());
        dot.setRadius(1);
        canvas.getChildren().add(dot);
    }

    public void onStartClicked(ActionEvent actionEvent) {
        if(!timerRunning){
            bug1.setRadius(2);
            bug2.setRadius(2);
            bug3.setRadius(2);
            bug4.setRadius(2);
            timer.start();
            timerRunning=true;
        }else{
            timer.stop();
            timerRunning=false;
        }
    }
}