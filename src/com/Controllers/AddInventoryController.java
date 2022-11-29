package com.Controllers;

import java.io.IOException;

import com.InventoryManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class AddInventoryController {

    @FXML
    private MenuItem addProduct;
    @FXML
    private MenuItem addInventory;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;
    
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
}
