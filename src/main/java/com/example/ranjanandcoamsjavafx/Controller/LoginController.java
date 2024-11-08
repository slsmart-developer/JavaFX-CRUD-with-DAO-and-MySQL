package com.example.ranjanandcoamsjavafx.Controller;

import com.example.ranjanandcoamsjavafx.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox cmbUserRoll;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCloseLogin;


    @FXML
    public void initialize() {
        cmbUserRoll.getItems().removeAll(cmbUserRoll.getItems());
        cmbUserRoll.getItems().addAll("Admin", "User");
        cmbUserRoll.getSelectionModel().select("Admin");
    }

    @FXML
    void btnActionCloseLogin(ActionEvent event) {
        Stage stage = (Stage) btnCloseLogin.getScene().getWindow();
        stage.close();
    }


    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    private void checkLogin() throws IOException{

        Main m = new Main();

        String userRoll, userName, password;
        userRoll = String.valueOf(cmbUserRoll.getValue());
        userName = txtUserName.getText().toString();
        password = txtPassword.getText().toString();

//        userRoll.equals("") &&

        if( userRoll.equals("Admin") && userName.equals("admin") && password.equals("123")){


            m.changeScene("appointment.fxml");



        }

        else if( userRoll.equals("User") && userName.equals("user") && password.equals("123")){


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ranjan & Co Appointment Management System");
            alert.setHeaderText("Please enter details first");
            alert.setContentText("Please enter details first");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        }
        else if( userName.isEmpty() && password.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ranjan & Co Appointment Management System");
            alert.setHeaderText("try again!");
            alert.setContentText("Please enter details first");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }

        else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ranjan & Co Appointment Management System");
            alert.setHeaderText("try again!");
            alert.setContentText("Wrong details");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }
}