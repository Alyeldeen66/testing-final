package sample;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MoneyController implements Initializable {
    Money money = new Money();
    @FXML
    Button changeAccountBalance;
    @FXML
    Label balanceLabel = new Label() ;
    @FXML
    Label currentBalance = new Label();
    @FXML
    TextField text = new TextField();
    @Override
    public void initialize(URL location, ResourceBundle rb){
        balanceLabel.setText(String.valueOf(money.getBalance()));
    }
    public void setChangeAccountBalance(ActionEvent e){
        balanceLabel.setText(String.valueOf(money.AddToBalance(Integer.parseInt(text.getText()))));
        currentBalance.setText(String.valueOf(money.getBalance()));
    }



}
