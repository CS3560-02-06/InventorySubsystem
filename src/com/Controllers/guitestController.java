package com.Controllers;

import java.io.IOException;

import com.InventoryManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;

public class guitestController {

    @FXML
    private MenuItem productItem;
    @FXML
    private MenuItem inventoryItem;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;
    @FXML
    private Menu edit;
    @FXML
    private Menu search;


    
    public guitestController() {

    }

    public void SelectProductItem(ActionEvent event) throws IOException {
        System.out.println("null");
        InventoryManager m = new InventoryManager();
        m.ChangeScene("src/com/addnewproduct.fxml");
    }


    public void SelectInventoryItem(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("src/com/addinventoryproduct.fxml");
    }
    
    public void SelectSearchProduct(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("src/com/SearchPrudoct.fxml");
    }

    public void SelectSearchInventory(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("src/com/SearchInventory.fxml");
    }
}
