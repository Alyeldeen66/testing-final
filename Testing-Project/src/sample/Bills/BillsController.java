package sample.Bills;
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

public class BillsController implements Initializable {
    int currentBalance = Money.balance;
    private Stage stage;
    private Scene scene;
    @FXML
    Button payBills ;
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

    static ObservableList<Bills> list = FXCollections.observableArrayList(
            new Bills("Gas Bill",200,"Unpaid",1),
            new Bills("Water Bill",400,"Unpaid",2),
            new Bills("Electric Bill",1000,"Unpaid",3),
            new Bills("Phone Bill",700,"Unpaid",4)
    );

    @Override
    public void initialize(URL location, ResourceBundle rb){
            number.setCellValueFactory(new PropertyValueFactory<Bills,Integer>("number"));
            name.setCellValueFactory(new PropertyValueFactory<Bills,String>("name"));
            status.setCellValueFactory(new PropertyValueFactory<Bills,String>("status"));
            amount.setCellValueFactory(new PropertyValueFactory<Bills,Integer>("amount"));
            myTable.setItems(list);
      }

    public void deleteSelectedRow(ActionEvent e){
            ObservableList<Bills> billProduct;
            billProduct = myTable.getSelectionModel().getSelectedItems();
            if(billProduct.get(0).getAmount() <= Money.getBalance()){
                Money.purchase(billProduct.get(0).getAmount());
                list.remove(billProduct.get(0));
                String title = "Pay Bill";
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
