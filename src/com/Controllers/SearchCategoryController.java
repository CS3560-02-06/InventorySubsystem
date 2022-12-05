package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.lang.model.util.ElementScanner6;

import java.net.URL;

import com.InventoryManager;
import com.Category;

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

public class SearchCategoryController implements Initializable{

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
    private MenuItem searchCategory;


    @FXML
    private Button searchButton;

    @FXML
    private TextField categoryIDBox;


    @FXML
    private TableView<Category> categoryList;
    @FXML
    private TableColumn<Category, Integer> categoryID;
    @FXML
    private TableColumn<Category, String> categoryName;
    @FXML
    private AnchorPane myAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        categoryID.setCellValueFactory(new PropertyValueFactory<Category, Integer>("category"));
        categoryName.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));

        Category[] allItems = InventoryManager.GetCategories();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
        }
    }

    public SearchCategoryController() {

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

        if(categoryIDBox.getText().isEmpty())
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
        categoryList.getItems().clear();
        int categoryID = -1;
        // String categoryName = "";
        if(!categoryIDBox.getText().isEmpty())
        {
            categoryID = Integer.valueOf(categoryIDBox.getText());
        }
        // productName = nameBox.getText();

        Category category;
        // Category[] productItemList;
        if(categoryID != -1)
        {
            category = InventoryManager.SearchForCategory(categoryID);
            addItem(category);
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
            Category[] allItems = InventoryManager.GetCategories();
            for (int i = 0; i < allItems.length; ++i) {
                addItem(allItems[i]);
            }
        }
        
    }
    
    void addItem(Category item)
    {
        ObservableList<Category> categorys = categoryList.getItems();
        categorys.add(item);
        categoryList.setItems(categorys);
    }
}
