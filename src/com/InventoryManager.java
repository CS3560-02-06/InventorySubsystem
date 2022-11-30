package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import java.io.*;

public class InventoryManager extends Application
{
   private static Stage stg;

   String url = "jdbc:mysql://localhost:3306/INVENTORY_SUBSYSTEM";
   static String userName = "root";
   static String password = "3560";
   static String portNumber = "3306";
   static String serverName = "localhost";
   static String dbms = "mysql";
   static String dbName = "INVENTORY_SUBSYSTEM";
   static Connection con;
   public static void main( String[] args ){
      try {
         con = getConnection();
         
         runUpdateSqlQuery("DROP DATABASE IF EXISTS `INVENTORY_SUBSYSTEM`");
         runUpdateSqlQuery("CREATE DATABASE `INVENTORY_SUBSYSTEM`");
         runUpdateSqlQuery("USE `INVENTORY_SUBSYSTEM`");
         
         runUpdateSqlScript("src/com/Queries/createTables.sql");
         runUpdateSqlScript("src/com/Queries/insertValues.sql");

         // TEST STUFF REMOVE LATER

         ProductItem newP = new ProductItem(1, "sdfsdf", 1, 2, "gogo");
         AddProductItem(newP);
         Date newDate = new Date(1, 1, 1);
         InventoryItem newItem = new InventoryItem(1, 0, 5.5, 1, 3.5, "Blue", newDate, newDate, 0);
         AddInventoryItem(newItem);

         // TEST STUFF REMOVE LATER

         launch();
       } catch (SQLException e) {
         e.printStackTrace(System.err);
       } catch (Exception e) {
         e.printStackTrace(System.err);
       } finally {
         closeConnection(con);
       }
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
       stg = primaryStage;
       File f = new File("src/com/homePage.fxml");
       Parent root = FXMLLoader.load(f.toURI().toURL());

       primaryStage.setScene(new Scene(root));
       primaryStage.setTitle("Inventory");
       primaryStage.show();
   }

   public void ChangeScene(String fxml) throws IOException {
       Parent pane = FXMLLoader.load(getClass().getResource("/"+fxml));
       stg.getScene().setRoot(pane);
   }

   /**
   * Opens a new connection to a database.
   */
   public static Connection getConnection() throws SQLException {
      Connection conn = null;
      Properties connectionProps = new Properties();
      connectionProps.put("user", userName);
      connectionProps.put("password", password);
      connectionProps.put("dbName", dbName);
  
      conn = DriverManager.getConnection(
         "jdbc:" + dbms + "://" +
         serverName +
         ":" + portNumber + "/",
         connectionProps);
      System.out.println("Connected to database");
      return conn;
   }
   /**
   * Closes a connection to a database.
   * @param connArg The connection to close.
   */
   public static void closeConnection(Connection connArg) {
      System.out.println("Releasing all open resources ...");
      try {
         if (connArg != null) {
            connArg.close();
            connArg = null;
         }
      }
      catch (SQLException sqle) {
         sqle.printStackTrace(System.err);
      }
   }

   /**
    * Reads and executes a .sql script file for update functions.
    * @param fileName The name of the input file.
    * @throws IOException Throws if an error occurs while reading or writing data.
    * @throws SQLException Throws if an error occurs while executing SQL operations.
    */
   public static void runUpdateSqlScript(String fileName) throws IOException, SQLException
   {
      Statement statement = con.createStatement();
      File file = new File(fileName);
      if (!file.exists())
      {
         System.out.println("file not found.");
         System.exit(0);
      }
      Scanner inputFile = new Scanner(file);
      while (inputFile.hasNextLine())
      {
      String query = inputFile.nextLine();
      statement.executeUpdate(query);
      }
      System.out.println("Query sucessfully read!");
      inputFile.close();
   }

   /**
    * Reads and executes a .sql script file.
    * @param fileName The name of the input file.
    * @throws IOException Throws if an error occurs while reading or writing data.
    * @throws SQLException Throws if an error occurs while executing SQL operations.
    */
   public static void runSqlScript(String fileName) throws IOException, SQLException
   {
      Statement statement = con.createStatement();
      File file = new File(fileName);
      if (!file.exists())
      {
         System.out.println("file not found.");
         System.exit(0);
      }
      Scanner inputFile = new Scanner(file);
      while (inputFile.hasNextLine())
      {
      String query = inputFile.nextLine();
      ResultSet result = statement.executeQuery(query);
      ResultSetMetaData rsmd = result.getMetaData();
      int cols = rsmd.getColumnCount();
      while(result.next())
      {
         for (int i = 1; i <= cols; ++i)
         {
            System.out.print(result.getString(i) + " : ");
         }
         System.out.println();
      }
   }
   System.out.println("Query sucessfully read!");
   inputFile.close();
   }
/**
 * Executes an update sql query.
   * @param query The query to execute.
   * @throws IOException Throws if an error occurs while reading or writing data.
   * @throws SQLException Throws if an error occurs while executing SQL operations.
   */
   public static void runUpdateSqlQuery(String query)
   {
      try{
         Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         statement.executeUpdate(query);
      }catch(SQLException se) {
         se.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   /**
    * Executes a sql query.
    * @param query The query to execute.
    * @throws IOException Throws if an error occurs while reading or writing data.
    * @throws SQLException Throws if an error occurs while executing SQL operations.
    */
   public static ResultSet runSqlQuery(String query)
   {
      try{
         Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet result = statement.executeQuery(query);
         return result;
      }catch(SQLException se) {
         se.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   /**
    * Finds and returns every ProductItem in the database.
    */
   static public ProductItem[] GetProductItems()
   {
      try{
         String sql = "SELECT * FROM product_items";
         ResultSet rs = runSqlQuery(sql);

         rs.last();
         int rows = rs.getRow();
         rs.beforeFirst();
         ProductItem[] result = new ProductItem[rows];
         int currRow = 0;
         while(rs.next())
         {
            ProductItem item = new ProductItem(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), rs.getString(5));
            result[currRow] = item;
            ++currRow;
         }
         return result;
      }catch(SQLException se) {
         se.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   /**
    * Adds a new ProductItem to the database.
    * @param newItem The new item to add.
    */
   static public void AddProductItem(ProductItem newItem)
   {
      String sql = "INSERT INTO product_items " + "VALUES (" + newItem.productID + ", '" + newItem.name + "', "
      + newItem.categoryID + ", " + newItem.supplierID + ", '" + newItem.description + "')";
      runUpdateSqlQuery(sql);
   }
   /**
    * Removes an existing ProductItem from the database.
    * @param productID The ID of the item to remove.
    */
   static public void RemoveProductItem(int productID)
   {
      String sql = "DELETE FROM product_items WHERE product_id = " + productID;
      runUpdateSqlQuery(sql);
   }
   /**
    * Updates an existing ProductItem's information in the database.
    * @param ID The ID of the ProductItem to update.
    * @param newItem a ProductItem holding the updated information.
    */
   static public void UpdateProductItem(int ID, ProductItem newItem)
   {
      String sql = "UPDATE product_items SET product_id = '" + newItem.productID + "', product_name = '" + newItem.name
      + "', category_id_fk = '" + newItem.categoryID + "', supplier_id_fk = '" + newItem.supplierID
      + "', description = '" + newItem.name + "' WHERE `product_id`=" + ID;
      runUpdateSqlQuery(sql);
   }
   /**
    * Adds a new InventoryItem to the database.
    * @param newItem The new item to add.
    */

   static public void AddInventoryItem(InventoryItem newItem)
   {
      String sql = "INSERT INTO inventory_items " + "VALUES (" + newItem.productID + ", " + newItem.inventoryID + ", "
      + newItem.price + ", " + newItem.amountInStock + ", " + newItem.size + ", '" + newItem.color + "', '"
      + newItem.receiptDate + "', '" + newItem.expirationDate + "', " + newItem.locationID + ")";
      System.out.println(sql);
      runUpdateSqlQuery(sql);
   }
   /**
    * Removes an existing ProductItem from the database.
    * @param productID The ID of the product this item is a part of.
    * @param inventoryID The ID of the item to remove.
    */
   static public void RemoveInventoryItem(int productID, int inventoryID)
   {

   }
   /**
    * Updates an existing InventoryItem's information in the database.
    * @param productID The ID of the product this item is a part of.
    * @param inventoryID The ID of the InventoryItem to update.
    * @param newItem an InventoryItem holding the updated information.
    */
   static public void UpdateInventoryItem(int productID, int inventoryID, InventoryItem newItem)
   {

   }
   /**
    * Formats an request for more stock and sends it to a supplier.
    */
   static public void OrderMoreStock()
   {
      // Will contain a loop for each inventory item to be ordered
   }
   /**
    * Searches for a specific ProductItem in the database.
    * @param ID The ID of the ProductItem to search for.
    */
   static public ProductItem SearchForProduct(int ID)
   {
      Connection conn = null;
            Statement stmt = null;
      ProductItem productItem;

      try 
      {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/INVENTORY_SUBSYSTEM", "root", "3560");
         stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("SELECT * FROM product_items WHERE product_id =" + ID);

         // while ( rs.next() ) 
         // {
         // 	String lastName = rs.getString("Lname");
         // 	System.out.println(lastName);
         // }

         productItem = new ProductItem(ID, rs.getString("name"), rs.getInt("categoryID"), 
                  rs.getInt("supplierID"), rs.getString("desc"));

         conn.close();

         return productItem;
                  
         } catch (Exception e) {
         System.err.println("Got an exception! ");
         System.err.println(e.getMessage());
      }
      return null;
   }
   /**
    * An override for the search function that searches by name instead.
    * @param name The name of the ProductItem to search for.
    */
   static public void SearchForProduct(String name)
   {

   }
   /**
    * Searches for a specific InventoryItem in the database.
    * @param productID The ID of the ProductItem this InventoryItem is a part of.
    * @param inventoryID The ID of this specific InventoryItem.
    */
   static public void SearchForInventoryItem(int productID, int inventoryID)
   {

   }
   /**
    * An override for the search function that searches by productID only.
    * @param productID The ID of the ProductItem this InventoryItem is a part of.
    */
   static public void SearchForInventoryItem(int productID)
   {

   }
}