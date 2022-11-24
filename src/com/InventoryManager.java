package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.sql.*;
import java.util.*;

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
         //runUpdateSqlScript("Queries/createDatabase.sql", myConnection);
         //runUpdateSqlScript("Queries/use.sql", myConnection);
         //runUpdateSqlScript("Queries/createTables.sql", myConnection);
         //runUpdateSqlScript("Queries/insertValues.sql", myConnection);
         //runSqlScript("Queries/select.sql");
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
       File f = new File("src/com/guitest.fxml");
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
    * Adds a new ProductItem to the database.
    * @param newItem The new item to add.
    */
   static void AddProductItem(ProductItem newItem) throws SQLException
   {
      Connection conn = null;
      Statement stmt = null;

      try{
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/INVENTORY_SUBSYSTEM", "root", "3560");
         stmt = conn.createStatement();

         String sql = "INSERT INTO product_items " + "VALUES (" + newItem.productID + ", '" + newItem.name + "', " + newItem.categoryID + ", " + 
         newItem.brandID + ", '" + newItem.description + "')";

         stmt.executeUpdate(sql);
         
      }catch(SQLException se) {
         se.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(stmt != null){
               conn.close();
            }
         }catch(SQLException se) {

         }

         try{
            if(conn != null){
               conn.close();
            }
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
   }
   /**
    * Removes an existing ProductItem from the database.
    * @param productID The ID of the item to remove.
    */
   static void RemoveProductItem(int productID)
   {

   }
   /**
    * Updates an existing ProductItem's information in the database.
    * @param ID The ID of the ProductItem to update.
    * @param newItem a ProductItem holding the updated information.
    */
   static void UpdateProductItem(int ID, ProductItem newItem)
   {

   }
   /**
    * Adds a new InventoryItem to the database.
    * @param newItem The new item to add.
    * @param productID The ID of the product this item is a part of.
    */
   static void AddInventoryItem(InventoryItem newItem, int productID)
   {

   }
   /**
    * Removes an existing ProductItem from the database.
    * @param productID The ID of the product this item is a part of.
    * @param inventoryID The ID of the item to remove.
    */
   static void RemoveInventoryItem(int productID, int inventoryID)
   {

   }
   /**
    * Updates an existing InventoryItem's information in the database.
    * @param productID The ID of the product this item is a part of.
    * @param inventoryID The ID of the InventoryItem to update.
    * @param newItem an InventoryItem holding the updated information.
    */
   static void UpdateInventoryItem(int productID, int inventoryID, InventoryItem newItem)
   {

   }
   /**
    * Formats an request for more stock and sends it to a supplier.
    */
   static void OrderMoreStock()
   {
      // Will contain a loop for each inventory item to be ordered
   }
   /**
    * Searches for a specific ProductItem in the database.
    * @param ID The ID of the ProductItem to search for.
    */
   static void SearchForProduct(int ID)
   {

   }
   /**
    * An override for the search function that searches by name instead.
    * @param name The name of the ProductItem to search for.
    */
   static void SearchForProduct(String name)
   {

   }
   /**
    * Searches for a specific InventoryItem in the database.
    * @param productID The ID of the ProductItem this InventoryItem is a part of.
    * @param inventoryID The ID of this specific InventoryItem.
    */
   static void SearchForInventoryItem(int productID, int inventoryID)
   {

   }
   /**
    * An override for the search function that searches by productID only.
    * @param productID The ID of the ProductItem this InventoryItem is a part of.
    */
   static void SearchForInventoryItem(int productID)
   {

   }
}
