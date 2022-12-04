package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import com.InventoryItem;
import com.InventoryManager;
import com.ProductItem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.fxml.Initializable;

public class AddInventoryController {

    @FXML
    private MenuItem addProduct;
    @FXML
    private MenuItem addInventory;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;
    // @FXML
    // private MenuItem removeInventory;
    // @FXML
    // private MenuItem removeProduct;
    // @FXML
    // private MenuItem updateInventory;
    // @FXML
    // private MenuItem updateProduct;

    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;

    @FXML
    private TextField productIDBox;
    @FXML
    private TextField priceBox;
    @FXML
    private TextField sizeBox;
    @FXML
    private TextField colorBox;
    @FXML
    private TextField stockBox;
    @FXML
    private TextField recieptBox;
    @FXML
    private TextField expirationBox;
    @FXML
    private TextField locationBox;

    private int indexToInsert = 1;
    
    public AddInventoryController() {

    }

    public void SelectAddProduct(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/addnewproduct.fxml");
    }

    public void SelectAddInventory(ActionEvent event) throws IOException {
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

    public void add(MouseEvent event) {
        // InventoryItem inventoryItem = new InventoryItem(Integer.parseInt(productIDBox.getText()), indexToInsert, Double.parseDouble(priceBox.getText()), 
        //                                             Integer.parseInt(stockBox.getText()), Double.parseDouble(sizeBox.getText()), colorBox.getText(), 
        //                                             recieptBox.getText(), expirationBox.getText(), Integer.parseInt(locationBox.getText()));
        // InventoryManager.AddInventoryItem(inventoryItem);
        // ++ indexToInsert;
    }

    public void remove(MouseEvent event) {

    }
}
