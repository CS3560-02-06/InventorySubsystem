package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.Date;

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

public class SearchInventoryController {

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
    private Button searchButton;

    @FXML
    private TextField productIDBox;
    @FXML
    private TextField inventoryIDBox;

    @FXML
    private TableView<InventoryItem> InventoryList;

    @FXML
    private TableColumn<InventoryItem, Integer> productID;
    @FXML
    private TableColumn<InventoryItem, Integer> inventoryID;
    @FXML
    private TableColumn<InventoryItem, Double> price;
    @FXML
    private TableColumn<InventoryItem, Integer> amountInStock;
    @FXML
    private TableColumn<InventoryItem, Double> size;
    @FXML
    private TableColumn<InventoryItem, String> color;
    @FXML
    private TableColumn<InventoryItem, Date> receiptDate;
    @FXML
    private TableColumn<InventoryItem, Date> expirationDate;
    @FXML
    private TableColumn<InventoryItem, Integer> locationID;

    // @Override
    // public void initialize(URL url, ResourceBundle resourceBundle){
    //     productID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("productID"));
    //     name.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("name"));
    //     categoryID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("category"));
    //     supplierID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("brand"));
    //     description.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("desc"));
    //     supplierBox.getItems().addAll(1,2,3);
    //     categoryBox.getItems().addAll(1,2,3);

    //     ProductItem[] allItems = InventoryManager.GetProductItems();
    //     for (int i = 0; i < allItems.length; ++i) {
    //         addItem(allItems[i]);
    //         if(i == allItems.length-1)
    //         {
    //             indexToInsert = allItems[i].getProductID() + 1;
    //         }
    //     }
    // }
    
    public SearchInventoryController() {

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

    public void search(MouseEvent event) {
        int productID = -1;
        int inventoryID = -1;
        productID = Integer.valueOf(productIDBox.getText());
        inventoryID = Integer.valueOf(inventoryIDBox.getText());

        InventoryItem inventoryItem;
        InventoryItem[] inventoryItemList;

        if(productID == -1)
        {
            //error

        }
        else if(inventoryID == -1)
        {
            inventoryItemList = InventoryManager.SearchForInventoryItem(productID);

            //If inventoryItemList is found
        }
        else
        {
            inventoryItem = InventoryManager.SearchForInventoryItem(productID, inventoryID);

            //If inventoryItme is found
        }
        
    }
}
