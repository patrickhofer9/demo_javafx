package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Canvas canvas;

    private boolean drawn = false;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        if(!drawn)
            drawThings();
        else
            eraseThings();
        drawn = !drawn;

    }


    private void drawThings()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawRect(gc, 0, 0, canvas.getHeight(),canvas.getWidth());
        drawLine(gc, 0, 0, canvas.getHeight(),canvas.getWidth());
        drawLine(gc, canvas.getHeight(), 0, 0,canvas.getWidth());
    }

    private void eraseThings(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getHeight(),canvas.getWidth());
    }

    private static void drawLine(GraphicsContext gc, double x1, double y1, double x2, double y2){
        gc.setLineWidth(10);
        gc.setStroke(Color.RED);
        gc.strokeLine(x1, y1, x2, y2);
    }

    private static void drawRect(GraphicsContext gc, double x1, double y1, double x2, double y2){
        gc.setLineWidth(10);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x1, y1, x2, y2);
    }

}