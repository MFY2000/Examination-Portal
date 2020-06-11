package Exam_System;

import Exam_System.db.jdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

interface Login_plane {

    public void login(ActionEvent event)  throws SQLException, IOException,Exception;
    public void ADMIN_CALLER(ActionEvent actionEvent) throws IOException;
}
