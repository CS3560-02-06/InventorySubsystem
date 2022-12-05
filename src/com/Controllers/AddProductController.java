package com.Controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import com.Category;
import com.InventoryManager;
import com.ProductItem;
import com.Supplier;

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


public class AddProductController implements Initializable{

    @FXML
    private MenuItem producItem;
    @FXML
    private MenuItem inventoryItem;
    @FXML
    private MenuItem searchProduct;
    @FXML
    private MenuItem searchInventory;

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
    private ChoiceBox<String> supplierBox;

    @FXML
    private ChoiceBox<String> categoryBox;

    private int indexToInsert = 1;
    private Supplier[] suppliers;
    private Category[] categories;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        productID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("productID"));
        name.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("name"));
        categoryID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("category"));
        supplierID.setCellValueFactory(new PropertyValueFactory<ProductItem, Integer>("brand"));
        description.setCellValueFactory(new PropertyValueFactory<ProductItem, String>("desc"));
        suppliers = InventoryManager.GetSuppliers();
        for (Supplier supplier : suppliers)
        {
            supplierBox.getItems().add(supplier.GetName());
        }
        categories = InventoryManager.GetCategories();
        for (Category category : categories) {
            categoryBox.getItems().addAll(category.GetName());
        }

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
    public void selectCategory()
    {

    }
    public void selectSupplier()
    {

    }
    public void add(MouseEvent event) {
        int category = InventoryManager.FindCategory(categories, categoryBox.getValue());
        int supplier = InventoryManager.FindSupplier(suppliers, supplierBox.getValue());
        ProductItem productItem = new ProductItem(indexToInsert, nameBox.getText(), category, supplier, descriptionBox.getText());
        addItem(productItem);
        InventoryManager.AddProductItem(productItem);
        ++indexToInsert;
    }
    /*
    * When the update button is clicked this method is called
    */
    public void updateInventory(MouseEvent event) {
       // Get the table item that is selected
       ProductItem clickedItem = productList.getSelectionModel().getSelectedItem();
       if(clickedItem == null) {
           System.out.println("Please select an item"); // Add error message here
           return;
       }
       
       // Update item in database
        int category = InventoryManager.FindCategory(categories, categoryBox.getValue());
        int supplier = InventoryManager.FindSupplier(suppliers, supplierBox.getValue());
       ProductItem updatedItem = new ProductItem(clickedItem.getProductID(), nameBox.getText(), category, supplier, descriptionBox.getText());
       InventoryManager.UpdateProductItem(clickedItem.getProductID(), updatedItem);

       // Update item render
       clickedItem.setName(updatedItem.getName());
       clickedItem.setDesc(updatedItem.getDesc());
       clickedItem.setBrand(updatedItem.getBrand());
       clickedItem.setCategory(updatedItem.getCategory());

       productList.refresh();
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
