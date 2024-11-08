package com.example.ranjanandcoamsjavafx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AppointmentController extends AnchorPane {

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnAppointment;

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnDates;

    @FXML
    private Button btnClients;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMinimize;

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void handleCloseButtonAction(ActionEvent event) {

    }

    @FXML
    void handleMinimizeButtonAction(ActionEvent event) {

    }

    public AppointmentController(){
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userdashboard.fxml"));
//
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
