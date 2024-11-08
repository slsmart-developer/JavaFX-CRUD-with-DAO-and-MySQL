package com.example.ranjanandcoamsjavafx;

import com.example.ranjanandcoamsjavafx.DB.DBUtils;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class Main extends Application {

    Parent root;
    private static Stage stg;


    private TableView tableview;
    DBUtils dbUtils = new DBUtils();

    @Override
    public void start(Stage primaryStage) throws IOException {


        stg = primaryStage;

//        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("admindashboard.fxml"));
//        root = FXMLLoader.load(getClass().getResource("admindashboard.fxml"));

//        root = FXMLLoader.load(getClass().getResource("appointment.fxml"));



        Scene scene = new Scene(root);

//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        primaryStage.setTitle("Ranjan & Co Appointment Management System");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();


    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch();
    }













//    @Override
//    public void start(Stage stage) throws Exception {
//        //TableView
//        tableview = new TableView();
//        buildData();
//
//        //Main Scene
//        Scene scene = new Scene(tableview);
//
//        stage.setScene(scene);
//        stage.show();
//    }







}