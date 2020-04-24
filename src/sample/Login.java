package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;


public class Login implements Initializable {

    public String[][] User = new String[4][2];

    public TextField Username;
    public TextField PasswordShow;
    public PasswordField Password;
    public Button ShowButton;
    public Button HideButton;
    public Label Error;


    Stage stage = new Stage();

    public void check(int ways) throws Exception{

        if (ways == 1){ // open the window
            Parent root;
            root = FXMLLoader.load(Login.class.getResource("LoginVeiw.fxml"));
            stage.setScene(new Scene(root, 804, 476));
            stage.show();
        }
        else {//close the window
//            stage.close();
            System.out.println("hello");
            stage.hide();

        }
    }

    public void getUser(){
        for (int i = 0; i < 4; i++) {
            User[i][0] = "FA19-BSSE-000"+(i+1);
            User[i][1] = "FA19-BSSE-000"+(i+1);
            System.out.println(User[i][0]);
        }
    }

    public void LoginButton(ActionEvent event) throws Exception {
        String name = Username.getText();
        String password = (Password.getText());
        String Cpassword = (PasswordShow.getText());
        String pass = null;
        int number = 0;

        if(password != Cpassword)
            if(password.length() < Cpassword.length()){
                pass = Cpassword;
            }else{
                pass = password;
            }
//        for (int i = 0; i < name.length(); i++) {
//            match = name.matches(User[i][0]);
//            if (match){
//                number = i;
//                break;
//            }
//        }
//        if (!match){
//          //Error display userName is not coorect
//            Error.setVisible(true);
//            Error.setText("User name not Found(Incorrect Username)");
//        }
//        else{
//            if (password.matches(User[number][1])){
//            }
//            else{
//                Error.setVisible(true);
//                Error.setText("Password not Valid(Incorrect password)");
//            }
//        }

        boolean match = name.equals("FA19-BSSE-0000");

        if (!match){
//          //Error display userName is not coorect
            Error.setVisible(true);
            Error.setText("User name not Found(Incorrect Username)");
        }
        else{
            match = pass.equals("User_0011");
            if (!match){
                Error.setVisible(true);
                Error.setText("Password not Valid(Incorrect password)");
            }
            else{
//                check(2);
                System.out.println("Login succesfully");
                MainView Veiw = new MainView();
                Veiw.setMainView();

            }

        }

    }

    public void ShowPassword(){
        String value = Password.getText();
        Password.setVisible(false);
        ShowButton.setVisible(false);
        PasswordShow.setText(value);

        PasswordShow.setVisible(true);
        HideButton.setVisible(true);
    }

    public void HidePassword(){
        String value = PasswordShow.getText();
        PasswordShow.setVisible(false);
        HideButton.setVisible(false);
        Password.setText(value);

        Password.setVisible(true);
        ShowButton.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
