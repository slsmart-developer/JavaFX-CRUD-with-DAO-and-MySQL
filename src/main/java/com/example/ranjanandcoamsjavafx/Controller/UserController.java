package com.example.ranjanandcoamsjavafx.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserController extends AnchorPane {

    public UserController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentA.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
