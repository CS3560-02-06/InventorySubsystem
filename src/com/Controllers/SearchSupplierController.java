package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.lang.model.util.ElementScanner6;

import java.net.URL;

import com.InventoryManager;
import com.Supplier;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.fxml.Initializable;

public class SearchSupplierController implements Initializable{

    @FXML
    private MenuItem producItem;
    @FXML
    private MenuItem inventoryItem;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;
    @FXML
    private MenuItem userGuide;
    @FXML
    private MenuItem searchSupplier;


    @FXML
    private Button searchButton;

    @FXML
    private TextField supplierIDBox;


    @FXML
    private TableView<Supplier> supplierList;
    @FXML
    private TableColumn<Supplier, Integer> supplierID;
    @FXML
    private TableColumn<Supplier, String> supplierName;
    @FXML
    private TableColumn<Supplier, String> phone;
    @FXML
    private TableColumn<Supplier, String> email;
    @FXML
    private AnchorPane myAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        supplierID.setCellValueFactory(new PropertyValueFactory<Supplier, Integer>("supplierID"));
        supplierName.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<Supplier, String>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<Supplier, String>("email"));

        Supplier[] allItems = InventoryManager.GetSuppliers();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
        }
    }

    public SearchSupplierController() {

    }

    public void SelectProductItem(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/addnewproduct.fxml");
    }

    public void SelectInventoryItem(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/addnewInventory.fxml");
    }
    
    public void SelectSearchProduct(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/SearchProduct.fxml");
    }

    public void SelectSearchInventory(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/SearchInventory.fxml");
    }

    public void SelectUserGuide(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/homePage.fxml");
    }

    public void SelectSearchSupplier(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/SearchSupplier.fxml");
    }
    
    public void search(MouseEvent event) {

        if(supplierIDBox.getText().isEmpty())
        {
            Stage stage = (Stage) myAnchorPane.getScene().getWindow();
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.initModality(Modality.APPLICATION_MODAL);
            errorAlert.initOwner(stage);

            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Please check all required fields.");
            errorAlert.showAndWait();
            return;
        }
        supplierList.getItems().clear();
        int supplierID = -1;
        // String supplierName = "";
        if(!supplierIDBox.getText().isEmpty())
        {
            supplierID = Integer.valueOf(supplierIDBox.getText());
        }
        // productName = nameBox.getText();

        Supplier supplier;
        // Supplier[] productItemList;
        if(supplierID != -1)
        {
            supplier = InventoryManager.SearchForSupplier(supplierID);
            addItem(supplier);
            //If productItem is found

        }
        // else if(!nameBox.getText().isEmpty())
        // {
        //     productItemList = InventoryManager.SearchForProduct(productName);
        //     for (ProductItem PI : productItemList) {
        //         addItem(PI);
        //     }
        //     //If productItemList is found
        // }
        else
        {
            Supplier[] allItems = InventoryManager.GetSuppliers();
            for (int i = 0; i < allItems.length; ++i) {
                addItem(allItems[i]);
            }
        }
        
    }
    
    void addItem(Supplier item)
    {
        ObservableList<Supplier> suppliers = supplierList.getItems();
        suppliers.add(item);
        supplierList.setItems(suppliers);
    }
}
