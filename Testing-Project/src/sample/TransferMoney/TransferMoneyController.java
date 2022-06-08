package sample.TransferMoney;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Bills.Bills;
import sample.Money;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;

import javafx.event.ActionEvent;
public class TransferMoneyController {
    private Stage stage;
    private Scene scene;
    @FXML
    TextField accountNumber  = new TextField();
    @FXML
    TextField amountOfTransfer = new TextField();

    public void transfer(ActionEvent e){
        if(Money.balance >= Integer.parseInt(amountOfTransfer.getText()) && Integer.parseInt(amountOfTransfer.getText()) >=50 && Integer.parseInt(amountOfTransfer.getText())< 50000){
            Money.purchase(Integer.parseInt(amountOfTransfer.getText()));
            accountNumber.setText(null);
            amountOfTransfer.setText(null);
            String title = "Transfer Money";
            String message = "Success" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.SUCCESS);
            tray.showAndDismiss(Duration.ONE);
        }
        else{
            accountNumber.setText(null);
            amountOfTransfer.setText(null);
            String title = "Transfer";
            String message = "Fail" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.ERROR);
            tray.showAndDismiss(Duration.ONE);
        }

    }


    public void switchToMenuView(javafx.event.ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/MenuView.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
