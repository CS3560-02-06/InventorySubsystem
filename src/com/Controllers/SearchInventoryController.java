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
import java.time.*;

public class SearchInventoryController implements Initializable{

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
    private TextField productIDBox;
    @FXML
    private TextField inventoryIDBox;

    @FXML
    private TableView<InventoryItem> inventoryList;

    @FXML
    private TableColumn<InventoryItem, Integer> productID;
    @FXML
    private TableColumn<InventoryItem, Integer> inventoryID;
    @FXML
    private TableColumn<InventoryItem, Double> price;
    @FXML
    private TableColumn<InventoryItem, Integer> amount;
    @FXML
    private TableColumn<InventoryItem, Integer> amountInStock;
    @FXML
    private TableColumn<InventoryItem, Double> size;
    @FXML
    private TableColumn<InventoryItem, String> color;
    @FXML
    private TableColumn<InventoryItem, LocalDate> receiptDate;
    @FXML
    private TableColumn<InventoryItem, LocalDate> expirationDate;
    @FXML
    private TableColumn<InventoryItem, Integer> locationID;

    @FXML
    private AnchorPane myAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        price.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("Price"));
        amount.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Amount"));
        color.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Color"));
        inventoryID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("InventoryID"));
        locationID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("Location"));
        productID.setCellValueFactory(new PropertyValueFactory<InventoryItem, Integer>("ProductID"));
        size.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("Size"));
        receiptDate.setCellValueFactory(new PropertyValueFactory<InventoryItem, LocalDate>("RecDate"));
        expirationDate.setCellValueFactory(new PropertyValueFactory<InventoryItem, LocalDate>("ExpDate"));

        InventoryItem[] allItems = InventoryManager.GetInventoryItems();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
        }
    }
    
    public SearchInventoryController() {

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

        int productID = -1;
        int inventoryID = -1;
        if(!productIDBox.getText().isEmpty())
        {
            productID = Integer.valueOf(productIDBox.getText());
        }
        else
        {
            Stage stage = (Stage) myAnchorPane.getScene().getWindow();
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.initModality(Modality.APPLICATION_MODAL);
            errorAlert.initOwner(stage);

            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Please...(do something)");
            errorAlert.showAndWait();
            return;
        }
        inventoryList.getItems().clear();

        if(!inventoryIDBox.getText().isEmpty())
        {
            inventoryID = Integer.valueOf(inventoryIDBox.getText());
        }
        InventoryItem inventoryItem;
        InventoryItem[] inventoryItemList;

        if(productID == -1 && inventoryID == -1)
        {
            InventoryItem[] allItems = InventoryManager.GetInventoryItems();
            for (int i = 0; i < allItems.length; ++i) {
                addItem(allItems[i]);
            }
        }
        else if(inventoryID == -1)
        {
            inventoryItemList = InventoryManager.SearchForInventoryItem(productID);
            if(inventoryItemList == null)
            {
                return;
            }
            for (InventoryItem II : inventoryItemList)
            {
                addItem(II);
            }
            //If inventoryItemList is found
        }
        else
        {
            inventoryItem = InventoryManager.SearchForInventoryItem(productID, inventoryID);
            if(inventoryItem == null)
            {
                return;
            }
            addItem(inventoryItem);
            //If inventoryItme is found
        }
        
    }
    void addItem(InventoryItem item)
    {
        ObservableList<InventoryItem> inventoryItem = inventoryList.getItems();
        inventoryItem.add(item);
        inventoryList.setItems(inventoryItem);
    }
}
