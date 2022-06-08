package sample;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuViewController implements Initializable {
        private Stage stage;
        private Scene scene;

        public void initialize(URL location, ResourceBundle rb){
        }
        public void switchToMenuView(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        public void switchToMainScene(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        public void switchToMyAccountScene(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("MyAccount.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        public void switchToBillsScene(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("Bills.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        public void switchToProductsScene(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        public void switchToTransferMoneyScene(javafx.event.ActionEvent e) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("TransferMoney.fxml"));
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
        }


}
