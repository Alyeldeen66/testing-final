package sample.Products;
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
import com.github.plushaze.traynotification.animations.Animations;
import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;

import javafx.event.ActionEvent;

public class ProductsController {

    int currentBalance = Money.balance;
    boolean isValueInEGP = false;
    boolean isValueInUSD = true;
    private Stage stage;
    private Scene scene;
    @FXML
    Button payBills ;
    @FXML
    Label savingLabel = new Label();
    @FXML
    Label foreignLabel = new Label();
    @FXML
    Label investmentLabel = new Label();
    @FXML
    private TableView<Bills> myTable;
    @FXML
    private TableColumn<Bills,String> name;
    @FXML
    private TableColumn<Bills,Integer> amount;
    @FXML
    private TableColumn<Bills,Integer> number;
    @FXML
    private TableColumn<Bills,String> status;



    public void increaseAmountOfSavingLabel(ActionEvent e){
        int value = Integer.parseInt(savingLabel.getText()) + 1000;
        savingLabel.setText(String.valueOf(value));
    }
    public void increaseAmountOfForeignLabel(ActionEvent e){
        if(isValueInUSD) {
            int value = Integer.parseInt(foreignLabel.getText()) + 50;
            foreignLabel.setText(String.valueOf(value));
        }
    }
    public void getAmountInEGP(ActionEvent e){
        if(isValueInUSD) {
            int valueInEGP = (int) (Integer.parseInt(foreignLabel.getText()) * 18.5);
            foreignLabel.setText(String.valueOf(valueInEGP));
            isValueInUSD = false;
            isValueInEGP = true;

        }
    }
    public void getAmountInUSD(ActionEvent e){
        if(isValueInEGP) {
            int valueInUSD = (int) (Integer.parseInt(foreignLabel.getText()) / 18.5);
            foreignLabel.setText(String.valueOf(valueInUSD));
            isValueInEGP = false;
            isValueInUSD = true ;
        }
    }
    public void increaseAmountOfInvestmentLabel(ActionEvent e){
        int value = Integer.parseInt(investmentLabel.getText()) + 1000;
        investmentLabel.setText(String.valueOf(value));
    }
    public void decreaseAmountOfSavingLabel(ActionEvent e){
        if(Integer.parseInt(savingLabel.getText()) >1000) {
            int value = Integer.parseInt(savingLabel.getText()) - 1000;
            savingLabel.setText(String.valueOf(value));
        }
    }
    public void decreaseAmountOfForeignLabel(ActionEvent e){
        if(Integer.parseInt(foreignLabel.getText()) > 50){
        int value = Integer.parseInt(foreignLabel.getText()) - 50;
        foreignLabel.setText(String.valueOf(value));
        }
    }
    public void decreaseAmountOfInvestmentLabel(ActionEvent e){
        if(Integer.parseInt(investmentLabel.getText()) > 1000) {
            int value = Integer.parseInt(investmentLabel.getText()) - 1000;
            investmentLabel.setText(String.valueOf(value));
        }
    }
    public void buySavingCertificate(ActionEvent e){
        if(Integer.parseInt(savingLabel.getText()) <= Money.balance){
            Money.purchase(Integer.parseInt(savingLabel.getText()));
            savingLabel.setText("1000");
            String title = "Buy saving certificate";
            String message = "Success" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.SUCCESS);
            tray.showAndDismiss(Duration.ONE);
        }
        else{
            String title = "Insufficient balance";
            String message = "Fail" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.ERROR);
            tray.showAndDismiss(Duration.ONE);
        }
    }
    public void buyForeignCertificate(ActionEvent e){
        if(isValueInUSD){
        if(Integer.parseInt(foreignLabel.getText()) <= (Money.balance / 18.5)){
            int valueInDollar = (int)(Integer.parseInt(foreignLabel.getText()) * 18.5);
            Money.purchase(valueInDollar);
            foreignLabel.setText("50");
            String title = "Buy foreign certificate";
            String message = "Success" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.SUCCESS);
            tray.showAndDismiss(Duration.ONE);
        }
        else{
            String title = "Insufficient balance";
            String message = "Fail" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.ERROR);
            tray.showAndDismiss(Duration.ONE);
        }
        }
        else{
            if(Integer.parseInt(foreignLabel.getText()) <= (Money.balance)){
                Money.purchase(Integer.parseInt(foreignLabel.getText()));
                foreignLabel.setText("50");
                String title = "Buy foreign certificate";
                String message = "Success" ;
                TrayNotification tray = new TrayNotification();
                tray.setAnimation(Animations.FADE);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotification(Notifications.SUCCESS);
                tray.showAndDismiss(Duration.ONE);
            }
            else{
                String title = "Insufficient balance";
                String message = "Fail" ;
                TrayNotification tray = new TrayNotification();
                tray.setAnimation(Animations.FADE);
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotification(Notifications.ERROR);
                tray.showAndDismiss(Duration.ONE);
            }

        }
    }
    public void buyInvestmentCertificate(ActionEvent e){
        if(Integer.parseInt(investmentLabel.getText()) <= Money.balance){
            Money.purchase(Integer.parseInt(investmentLabel.getText()));
            investmentLabel.setText("1000");
            String title = "Buy investment certificate";
            String message = "Success" ;
            TrayNotification tray = new TrayNotification();
            tray.setAnimation(Animations.FADE);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotification(Notifications.SUCCESS);
            tray.showAndDismiss(Duration.ONE);
        }
        else{
            String title = "Insufficient balance";
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
