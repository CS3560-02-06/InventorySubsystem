package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import com.InventoryManager;
import com.InventoryItem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.sql.Date;

public class AddInventoryController implements Initializable{

    @FXML
    private MenuItem addProduct;
    @FXML
    private MenuItem addInventory;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;
    @FXML
    private MenuItem removeInventory;
    @FXML
    private MenuItem removeProduct;
    @FXML
    private MenuItem updateInventory;
    @FXML
    private MenuItem updateProduct;

    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;

    @FXML
    private TableView<InventoryItem> inventoryList;

    @FXML
    private TableColumn<InventoryItem, Integer> amount;
    @FXML
    private TableColumn<InventoryItem, Integer> price;
    @FXML
    private TableColumn<InventoryItem, String> color;
    @FXML
    private TableColumn<InventoryItem, Integer> inventoryID;
    @FXML
    private TableColumn<InventoryItem, Integer> locationID;
    @FXML
    private TableColumn<InventoryItem, Integer> productID;
    @FXML
    private TableColumn<InventoryItem, Integer> size;

    @FXML
    private ChoiceBox<Integer> locationBox;
    @FXML
    private TextField amountBox;
    @FXML
    private TextField colorBox;
    @FXML
    private TextField priceBox;
    @FXML
    private TextField productIDBox;
    @FXML
    private TextField sizeBox;

    private int indexToInsert = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        price.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Price"));
        amount.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Amount"));
        color.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Color"));
        inventoryID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("InventoryID"));
        locationID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Location"));
        productID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("ProductID"));
        size.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Size"));
        locationBox.getItems().addAll(1,2,3);

        InventoryItem[] allItems = InventoryManager.GetInventoryItems();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
        }
    }

    
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
        Date temp = new Date(1, 1, 1);
        int productID = Integer.parseInt(productIDBox.getText());
        InventoryItem[] itemsOnProduct = InventoryManager.SearchForInventoryItem(productID);
        if(itemsOnProduct == null)
        {
            indexToInsert = 1;
        }
        else
        {
            for (int i = 0; i < itemsOnProduct.length; ++i) {
                if(i == itemsOnProduct.length-1)
                {
                    indexToInsert = itemsOnProduct[i].getInventoryID() + 1;
                }
            }
        }
        InventoryItem inventoryItem = new InventoryItem(productID, indexToInsert,
                                                    Double.parseDouble(priceBox.getText()), Integer.parseInt(amountBox.getText()),
                                                    Integer.parseInt(sizeBox.getText()), colorBox.getText(), temp, temp, locationBox.getValue());
        addItem(inventoryItem);
        InventoryManager.AddInventoryItem(inventoryItem);
        ++indexToInsert;
    }

    void addItem(InventoryItem item)
    {
        ObservableList<InventoryItem> inventoryItem = inventoryList.getItems();
        inventoryItem.add(item);
        inventoryList.setItems(inventoryItem);
    }

    public void remove(MouseEvent event) {
        int selectedID = inventoryList.getSelectionModel().getSelectedIndex();
        inventoryList.getItems().remove(selectedID);

    }

}




