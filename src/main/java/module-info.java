module com.example.sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires unirest.java;
    requires org.json;
    requires java.sql;
    requires java.desktop;
    requires exp4j;


    opens com.example.sample to javafx.fxml;
    exports com.example.sample;
}