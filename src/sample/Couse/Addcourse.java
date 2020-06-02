package Todo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Addcourse implements Initializable {
    public TextField Field = new TextField();
    public Label PIN = new Label();
    @FXML
    Button SubmitButton = new Button();
// Private varabile
    private Connection connection;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PIN.setText(Random.getAlphaNumericString(6));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/database_choicelist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void courseSubmit() throws SQLException {
        if(Field.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Enter the value inn the field");
             alert.showAndWait();
        }


        String query = "INSERT INTO `subjectlist`(`id`, `Field`, `Pincode`) VALUES  (null ,?,?)";

        PreparedStatement preparedStmt = connection.prepareStatement(query);

        preparedStmt.setString(1, Field.getText());
        preparedStmt.setString(2, PIN.getText());

        try {
            preparedStmt.execute();
            Field.setText("");
            PIN.setText(Random.getAlphaNumericString(6));
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("SQL database error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }
}
