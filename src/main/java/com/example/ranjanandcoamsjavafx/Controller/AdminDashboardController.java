package com.example.ranjanandcoamsjavafx.Controller;

import com.example.ranjanandcoamsjavafx.DB.DBConnect;
import com.example.ranjanandcoamsjavafx.DB.DBUtils;
import com.example.ranjanandcoamsjavafx.DTO.AppointmentDTO;
import com.example.ranjanandcoamsjavafx.DTO.ClientsDTO;
import com.example.ranjanandcoamsjavafx.Main;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDashboardController implements Initializable {

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
    private Pane pnUsers;

    @FXML
    private Pane pnAppointment;

    @FXML
    private Pane pnAttendance;

    @FXML
    private Pane pnDates;

    @FXML
    private Pane pnClients;

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
    private TableView table1;


    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<AppointmentDTO> tableAppointment;

    @FXML
    private TableColumn<AppointmentDTO, String> idcolumn;

    @FXML
    private TableColumn<AppointmentDTO, String> availabledatecolumn;

    @FXML
    private TableColumn<AppointmentDTO, String> availabletimecolumn;

    @FXML
    private TableColumn<AppointmentDTO, String> titlecolumn;

//    ObservableList<AppointmentDTO> appointmentDTOObservableList = FXCollections.observableArrayList();



    DBUtils dbUtils = new DBUtils();
    PreparedStatement pst;
    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;


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
    public void btnActionUsers(){
        AppointmentController appointmentController = new AppointmentController();
        lblStatus.setText("Users");
//        pnContent.setCenter(appointmentController);
    }

    @FXML
    public void btnActionAppointment(){
        AppointmentController appointmentController = new AppointmentController();
        lblStatus.setText("Appointment");
//        pnContent.setCenter(appointmentController);
    }

    @FXML
    public void btnActionAttendance(){
        AttendanceController attendanceController = new AttendanceController();
//        pnContent.setCenter(attendanceController);
    }

    @FXML
    public void btnActionDates(){
        DatesController datesController = new DatesController();
//        pnContent.setCenter(datesController);
    }

    @FXML
    public void btnActionClients(){
        ClientsController clientsController = new ClientsController();

        Parent root = null;
        try {
            root= FXMLLoader.load(getClass().getResource("clients.fxml"));
        } catch (Exception e) {
        }
//        pnContent.setCenter(root);

       // pnContent.setCenter(clientsController);
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


//    @FXML
//    public void initialize() {
//
//
//    }

//
//        cmbGender.getItems().removeAll(cmbGender.getItems());
//        cmbGender.getItems().addAll("Male", "Female");
//        cmbGender.getSelectionModel().select("Male");










//        buildData();

//        try {
//            pst = dbUtils.con.prepareStatement("select * from appointment");
//            ResultSet rs = pst.executeQuery();
//            table1.setItems((ObservableList) DbUtils.resultSetToTableModel(rs));
//
//        } catch (SQLException e) {
//
//        }
        
        
        
        
//    }


//    private ObservableList getInitialTableData() {
//
//        List list = new ArrayList();
//        list.add(new Book("The Thief", "Fuminori Nakamura"));
//        list.add(new Book("Of Human Bondage", "Somerset Maugham"));
//        list.add(new Book("The Bluest Eye", "Toni Morrison"));
//        list.add(new Book("I Am Ok You Are Ok", "Thomas Harris"));
//        list.add(new Book("Magnificent Obsession", "Lloyd C Douglas"));
//        list.add(new Book("100 Years of Solitude", "Gabriel Garcia Marquez"));
//        list.add(new Book("What the Dog Saw", "Malcolm Gladwell"));
//        list.add(new Book("The Fakir", "Ruzbeh Bharucha"));
//        list.add(new Book("The Hobbit", "J.R.R. Tolkien"));
//        list.add(new Book("Strange Life of Ivan Osokin", "P.D. Ouspensky"));
//        list.add(new Book("The Hunt for Red October", "Tom Clancy"));
//        list.add(new Book("Coma", "Robin Cook"));
//
//        ObservableList data = FXCollections.observableList(list);
//
//        return data;
//    }

    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == btnUsers)
        {

            lblStatus.setText("Users");
//            pnUsers.toFront();
//            pnAppointment.toBack();
//            pnAttendance.toBack();
//            pnDates.toBack();
//            pnClients.toBack();


        }
        else if(event.getSource() == btnAppointment)
        {
            lblStatus.setText("Appointment");
//            pnAppointment.toFront();
//            pnUsers.toBack();
//            pnAttendance.toBack();
//            pnDates.toBack();
//            pnClients.toBack();
        }
        else if(event.getSource() == btnAttendance)
        {
            lblStatus.setText("Attendance");
//            pnAttendance.toFront();
//            pnAppointment.toBack();
//            pnUsers.toBack();
//            pnDates.toBack();
//            pnClients.toBack();
        }
        else if(event.getSource() == btnDates)
        {
            lblStatus.setText("Dates");
//            pnDates.toFront();
//            pnAppointment.toBack();
//            pnAttendance.toBack();
//            pnUsers.toBack();
//            pnClients.toBack();
        }
        else if(event.getSource() == btnClients)
        {
            lblStatus.setText("Clients");
//            pnClients.toFront();
//            pnAppointment.toBack();
//            pnAttendance.toBack();
//            pnDates.toBack();
//            pnUsers.toBack();
        }
    }



    public void adminDashboard(ActionEvent event)throws IOException{
        Main m = new Main();
        m.changeScene("admindashboard.fxml");
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        cmbDate.getItems().removeAll(cmbGender.getItems());
        cmbDate.getItems().addAll("2021-08-04", "2021-08-10", "2021-08-15", "2021-08-13");
        cmbDate.getSelectionModel().select("Male");


        cmbTime.getItems().removeAll(cmbGender.getItems());
        cmbTime.getItems().addAll("12:00:00", "03:00:00", "11:00:00");
        cmbTime.getSelectionModel().select("12:00:00");

//        try{

//            tablodoldur();

//            DBUtils dbUtils = new DBUtils();
//            Connection con = dbUtils.connect();
//
//            String Q_SELECT_ALL_APPOINTMENT = "SELECT * FROM appointment";
//
//          //  Statement statement = con.createStatement();
//            ResultSet queryOutput = con.createStatement().executeQuery(Q_SELECT_ALL_APPOINTMENT);
//
//
//            while (queryOutput.next()){
//
//
////                String qid = queryOutput.getString("id");
////                String qdate = queryOutput.getString("appointment_date");
////                String qtime = queryOutput.getString("appointment_time");
////                String qtitle = queryOutput.getString("title");
////
////                appointmentDTOObservableList.add(new AppointmentDTO(qid, qdate, qtime, qtitle));
//
//
//
//                appointmentDTOObservableList.add(new AppointmentDTO(queryOutput.getString(1), queryOutput.getString(2), queryOutput.getString(3), queryOutput.getString(4)));
//
//
//
//            }
//
//            idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//            availabledatecolumn.setCellValueFactory(new PropertyValueFactory<>("appointment_date"));
//            availabletimecolumn.setCellValueFactory(new PropertyValueFactory<>("appointment_time"));
//            titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));


         //   tableAppointment.setItems(appointmentDTOObservableList);

//            tableAppointment.getItems().add(new AppointmentDTO("1","24214","John", "Doe"));
//            tableAppointment.getItems().add(new AppointmentDTO("1","24214","John", "Doe"));



//        }catch (SQLException e)
//        {
//            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null,e);
//            e.printStackTrace();
//        }

    }
}
