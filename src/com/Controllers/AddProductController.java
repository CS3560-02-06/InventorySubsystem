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
    private Button removeButton;

    @FXML
    private TextArea descriptionBox;

    //table
    @FXML
    private TableView<ProductItem> productList;

    //columns
    @FXML
    private TableColumn<ProductItem, String> name;

    @FXML
    private TableColumn<ProductItem, Integer> productID;

    @FXML
    private TableColumn<ProductItem, Integer> categoryID;

    @FXML
    private TableColumn<ProductItem, String> description;

    @FXML
    private TableColumn<ProductItem, Integer> supplierID;

    @FXML
    private TextField nameBox;

    // @FXML
    // private TextField supplierBox;

    // @FXML
    // private TextField categoryBox;


    @FXML
    private ChoiceBox<Integer> supplierBox;

    @FXML
    private ChoiceBox<Integer> categoryBox;

    private int indexToInsert;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        // TEST STUFF REMOVE LATER
        ProductItem test = new ProductItem(1, "among", 1, 1, "us");
        ProductItem test2 = new ProductItem(2, "bagong", 1, 1, "us");
        ProductItem test3 = new ProductItem(3, "wagong", 1, 1, "us");
        InventoryManager.AddProductItem(test);
        InventoryManager.AddProductItem(test2);
        InventoryManager.AddProductItem(test3);
        // TEST STUFF REMOVE LATER
        productID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("productid"));
        name.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("name"));
        categoryID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("category"));
        supplierID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("brand"));
        description.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("desc"));
        supplierID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("brand"));
        categoryID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("category"));
        supplierBox.getItems().addAll(1,2,3);
        categoryBox.getItems().addAll(1,2,3);

        ProductItem[] allItems = InventoryManager.GetProductItems();
        for (int i = 0; i < allItems.length; ++i) {
            addItem(allItems[i]);
            if(i == allItems.length-1)
            {
                indexToInsert = allItems[i].getProductID() + 1;
            }
        }
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
    public void selectCategory()
    {

    }
    public void selectSupplier()
    {

    }
    public void add(MouseEvent event) {
        ProductItem productItem = new ProductItem(1, nameBox.getText(), categoryBox.getValue(), supplierBox.getValue(), descriptionBox.getText());
        addItem(productItem);
        InventoryManager.AddProductItem(productItem);
        ++indexToInsert;
    }
    void addItem(ProductItem item)
    {
        ObservableList<ProductItem> productItems = productList.getItems();
        productItems.add(item);
        productList.setItems(productItems);
    }

    public void remove(MouseEvent event) {
        int selectedID = productList.getSelectionModel().getSelectedIndex();
        productList.getItems().remove(selectedID);

    }


}
