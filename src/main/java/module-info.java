module com.example.four_bugs_problem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.four_bugs_problem to javafx.fxml;
    exports com.example.four_bugs_problem;
}