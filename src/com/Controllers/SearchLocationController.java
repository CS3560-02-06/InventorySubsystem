package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.lang.model.util.ElementScanner6;

import java.net.URL;

import com.InventoryManager;
import com.Location;

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

public class SearchLocationController implements Initializable{

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
    private MenuItem searchLocation;


    @FXML
    private Button searchButton;

    @FXML
    private TextField locationIDBox;


    @FXML
    private TableView<Location> locationList;
    @FXML
    private TableColumn<Location, Integer> locationID;
    @FXML
    private TableColumn<Location, String> locationName;
    @FXML
    private AnchorPane myAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        locationID.setCellValueFactory(new PropertyValueFactory<Location, Integer>("location"));
        locationName.setCellValueFactory(new PropertyValueFactory<Location, String>("name"));

        Location[] allItems = InventoryManager.GetLocations();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
        }
    }

    public SearchLocationController() {

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
    public void SelectSearchCategory(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/SearchCategory.fxml");
    }
    
    public void SelectSearchLocation(ActionEvent event) throws IOException {
        InventoryManager m = new InventoryManager();
        m.ChangeScene("com/SearchLocation.fxml");
    }
    
    public void search(MouseEvent event) {

        if(locationIDBox.getText().isEmpty())
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
        locationList.getItems().clear();
        int locationID = -1;
        // String locationName = "";
        if(!locationIDBox.getText().isEmpty())
        {
            locationID = Integer.valueOf(locationIDBox.getText());
        }
        // productName = nameBox.getText();

        Location location;
        // Location[] productItemList;
        if(locationID != -1)
        {
            location = InventoryManager.SearchForLocation(locationID);
            addItem(location);
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
            Location[] allItems = InventoryManager.GetLocations();
            for (int i = 0; i < allItems.length; ++i) {
                addItem(allItems[i]);
            }
        }
        
    }
    
    void addItem(Location item)
    {
        ObservableList<Location> locations = locationList.getItems();
        locations.add(item);
        locationList.setItems(locations);
    }
}
