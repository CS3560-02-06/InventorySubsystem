public class InventoryManager
{
   /**
    * Adds a new ProductItem to the database.
    * @param newItem The new item to add.
    */
   static void AddProductItem(ProductItem newItem)
   {
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
