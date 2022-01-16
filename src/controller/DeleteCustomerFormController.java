package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 2021-08-19
 **/
public class DeleteCustomerFormController {
    public JFXTextField txtCustomerID;
    public JFXTextField txtCustomerTitle;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCustomerCity;
    public JFXTextField txtCustomerProvince;
    public JFXTextField txtCustomerPostalCode;
    public JFXButton btnDeleteCustomer;
    public AnchorPane root;

    public void txtSelectCustomerOnAction(ActionEvent actionEvent) throws SQLException {
        String customerId = txtCustomerID.getText();

        Customer c1= new CustomerController().searchCustomer(customerId);
        if (c1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(c1);
        }
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) throws SQLException {
        if (new CustomerController().deleteCustomer(txtCustomerID.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    void setData(Customer c){
        txtCustomerID.setText(c.getId());
        txtCustomerTitle.setText(c.getName());
        txtCustomerName.setText(c.getAddress());
        txtCustomerAddress.setText(c.getAddress());
        txtCustomerCity.setText(c.getCity());
        txtCustomerProvince.setText(c.getProvince());
        txtCustomerPostalCode.setText(c.getPostalCode());

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ManageCustomerForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
