package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import com.InventoryManager;
import com.ProductItem;

import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
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


public class AddProductController implements Initializable{

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
    private Button cancelButton;

    @FXML
    private ChoiceBox<?> categoryBox;

    @FXML
    private TextArea descriptionBox;

    //table
    @FXML
    private TableView<ProductItem> productList;

    //columns
    @FXML
    private TableColumn<ProductItem, String> name;

    @FXML
    private TableColumn<ProductItem, Integer> producdID;

    @FXML
    private TableColumn<ProductItem, Integer> categoryID;

    @FXML
    private TableColumn<ProductItem, String> description;

    @FXML
    private TableColumn<ProductItem, Integer> supplier;



    @FXML
    private TextField nameBox;

    @FXML
    private ChoiceBox<?> supplierBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("name"));
        description.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("desc"));
    }

    
    public AddProductController() {

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
	System.out.println(descriptionBox.getText());
        ProductItem productItem = new ProductItem(1, nameBox.getText(), 1, 1, descriptionBox.getText());
        ObservableList<ProductItem> productItems = productList.getItems();
        productItems.add(productItem);
        productList.setItems(productItems);
        InventoryManager.AddProductItem(productItem);
    }

    public void cancel(MouseEvent event) throws IOException {
        //InventoryManager m = new InventoryManager();

    }


}
