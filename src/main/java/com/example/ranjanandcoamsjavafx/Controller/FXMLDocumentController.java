package com.example.ranjanandcoamsjavafx.Controller;

import com.example.ranjanandcoamsjavafx.DB.DBConnect;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class FXMLDocumentController extends Spinner<LocalTime> implements Initializable {

    private ObservableList<ObservableList> data;



    @FXML
    private TableView tableview;

    @FXML
    private Button btnClose;

    @FXML
    private ComboBox cmbGender;

    @FXML
    private Button btnMinimize;

    @FXML
    private ComboBox cmbDate;

    @FXML
    private ComboBox cmbTime;

    @FXML
    private Spinner spinnerTime;






    @FXML
    private void handleButtonAction(ActionEvent event) {
        tableview.getColumns().clear();
        tablodoldur();
//        loadComboData();
    }

    @FXML
    void deleteAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ranjan & Co Appointment Management System");
        alert.setHeaderText("Success!");
        alert.setContentText("Delete Successful");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });

    }

    @FXML
    void saveAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ranjan & Co Appointment Management System");
        alert.setHeaderText("Success!");
        alert.setContentText("Save Successful");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });

    }




    @FXML
    void searchAction(ActionEvent event) {
    }

    @FXML
    void updateAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ranjan & Co Appointment Management System");
        alert.setHeaderText("Success!");
        alert.setContentText("Update Successful");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });

    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleMinimizeButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnMinimize.getScene().getWindow();
        stage.setIconified(true);
    }



    private void tablodoldur()
    {


      //  cmbDate.getItems().removeAll(cmbGender.getItems());
        cmbDate.getItems().addAll("","2021-08-17","2021-08-04", "2021-08-10", "2021-08-15", "2021-08-13");
        cmbDate.getSelectionModel().select("2021-08-13");

//        cmbDate.getItems().addAll("","available","not available", "Male", "Female","Team Building Meeting","Meeting About Business", "Status Update Meeting", "Problem-Solving Meeting");
//        cmbDate.getSelectionModel().select("Meeting About Business");


       // cmbTime.getItems().removeAll(cmbGender.getItems());
        cmbTime.getItems().addAll("","12:30:00","12:00:00", "09:30:00", "03:00:00", "11:00:00");
        cmbTime.getSelectionModel().select("12:00:00");

//        cmbTime.getItems().addAll("","Done","Pending", "Success", "Not Success");
//        cmbTime.getSelectionModel().select("12:00:00");





        tableview.getColumns().clear();
        Connection c ;
        data = FXCollections.observableArrayList();
        try{
            c = (Connection) DBConnect.connect();
            //sql string ifademiz.
            String SQL = "SELECT * from appointment";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            // TABLO SÜTUNLARINI DİNAMİK OLARAK EKLEYECEĞİMİZ YAPI

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            //ObservableList e verileri ekleyen döngü
            while(rs.next()){
                //Satırları yinele
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //sütunları yinele
                    row.add(rs.getString(i));
                }
                System.out.println("Satır eklendi "+row );
                data.add(row);
            }

            //Sonucu tabloya ekleme
            tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Hata oluştu");
        }
    }

    @FXML
    private TextField txtad; //txtadi tanımladık. Uyarı verdiği yere tıklayarak TextFieldi import edebiliriz.

    @FXML
    private void handleEkle(ActionEvent event){
        Connection c;

        try{
            c = (Connection) DBConnect.connect();
            String query = "insert into appointment(id) values(?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString (1, txtad.getText().toString());
            preparedStmt.execute();
            tablodoldur();
            txtad.setText("");

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO



    }
}
