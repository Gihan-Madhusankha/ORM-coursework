package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Gihan Madhusankha
 * 2022-06-29 1:11 PM
 **/

public class LoginFormController {
    public JFXButton btnLogin;
    public Rectangle loginContext;
    public JFXTextField txtUserName;
    public Label lblCreateAnAccount;
    public JFXPasswordField txtHidePwd;
    public JFXTextField txtShowPwd;
    public ImageView imgCloseEye;
    public ImageView imgOpenEye;
    String password;

    public void initialize() {
        txtShowPwd.setVisible(false);
        imgOpenEye.setVisible(false);

        lblCreateAnAccount.setOnMouseClicked(event -> {
            Stage stage = (Stage) loginContext.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"))));
                stage.setTitle("Sign up");
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void enteredMouseEffect(MouseEvent event) {
        DropShadow glow = new DropShadow();
        glow.setColor(Color.WHITE);
        btnLogin.setEffect(glow);
    }

    public void exitedMouseEffect(MouseEvent event) {
        btnLogin.setEffect(null);
    }

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText() != null && txtHidePwd.getText() != null) {
            Stage stage = (Stage) loginContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
            stage.setTitle("Dashboard");
            stage.centerOnScreen();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something went wrong..!").show();
        }

    }

    public void openEyeOnAction(MouseEvent event) {
        txtShowPwd.setVisible(false);
        txtHidePwd.setVisible(true);
        imgCloseEye.setVisible(true);
        imgOpenEye.setVisible(false);
    }

    public void CloseEyeOnAction(MouseEvent event) {
        txtShowPwd.setVisible(true);
        txtHidePwd.setVisible(false);
        imgCloseEye.setVisible(false);
        imgOpenEye.setVisible(true);
    }

    public void showPasswordKeyReleasedOnAction(KeyEvent keyEvent) {
        password = txtShowPwd.getText();
        txtHidePwd.setText(password);
    }

    public void HidePasswordKeyReleasedOnAction(KeyEvent keyEvent) {
        password = txtHidePwd.getText();
        txtShowPwd.setText(password);
    }


}
