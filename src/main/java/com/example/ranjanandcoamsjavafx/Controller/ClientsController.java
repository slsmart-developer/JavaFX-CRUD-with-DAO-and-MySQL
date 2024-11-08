package com.example.ranjanandcoamsjavafx.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ClientsController extends AnchorPane {

    public ClientsController(){
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com.example.ranjanandcoamsjavafx.Controller/clients.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ranjanandcoamsjavafx/clients.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
