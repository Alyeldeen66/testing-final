package sample;
import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;

public class MyAccountController implements Initializable {
    int money = Money.balance;
    private Stage stage;
    private Scene scene;
    @FXML
    Label statement = new Label();
    @FXML
    Label myAccountBalance = new Label();
    @FXML
   TextField amount = new TextField();
    @Override
    public void initialize(URL location, ResourceBundle rb){
        statement.setMinWidth(200.0);
        myAccountBalance.setText(String.valueOf(money));
    }
    public void switchToMenuView(javafx.event.ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void successNotification(ActionEvent e ){
        String title = "Add balance";
        String message = "Success" ;
        TrayNotification tray = new TrayNotification();
        tray.setAnimation(Animations.FADE);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotification(Notifications.SUCCESS);
        tray.showAndDismiss(Duration.ONE);
    }
    public static void failNotification(ActionEvent e ){
        String title = "Add balance";
        String message = "Fail" ;
        TrayNotification tray = new TrayNotification();
        tray.setAnimation(Animations.FADE);
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotification(Notifications.ERROR);
        tray.showAndDismiss(Duration.ONE);
    }
    public void addToCurrentBalance(ActionEvent e){
       if(Integer.parseInt(amount.getText()) > 50 && Integer.parseInt(amount.getText()) < 50000){
            successNotification(e);
            Money.AddToBalance(Integer.parseInt(amount.getText()));
            myAccountBalance.setText(String.valueOf(Money.getBalance()));
        }
        else{
            failNotification(e);
       }
 }

}
