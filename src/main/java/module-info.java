module com.example.ranjanandcoamsjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.ranjanandcoamsjavafx to javafx.fxml;
    exports com.example.ranjanandcoamsjavafx;
    exports com.example.ranjanandcoamsjavafx.Controller;
    opens com.example.ranjanandcoamsjavafx.Controller to javafx.fxml;
}