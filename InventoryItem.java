import java.sql.Date;

public class InventoryItem
{
   int productID;
   int inventoryID;
   double price;
   int amountInStock;
   double size;
   String color;
   Date receiptDate;
   Date expirationDate;
   int locationID;

   // Constructor
   public InventoryItem(int newPID, int newIID, double newPrice, int newAmount, double newSize, String newColor, Date newRDate, Date newEDate, int newLoc)
   {
      productID = newPID;
      inventoryID = newIID;
      price = newPID;
      amountInStock = newAmount;
      size = newSize;
      color = newColor;
      receiptDate = newRDate;
      expirationDate = newEDate;
      locationID = newLoc;
   }

   // Getters
   public int getProductID(){return productID;}
   public int getInventoryID(){return inventoryID;}
   public double getPrice(){return price;}
   public int getAmount(){return amountInStock;}
   public double getSize(){return size;}
   public String getColor(){return color;}
   public Date getRecDate(){return receiptDate;}
   public Date getExpDate(){return expirationDate;}
   public int getLocation(){return locationID;}

   // Setters
   public void setProductID(int newID){productID = newID;}
   public void setInventoryID(int newID){inventoryID = newID;}
   public void setPrice(int newPrice){price = newPrice;}
   public void setAmount(int newAmount){amountInStock = newAmount;}
   public void setSize(int newSize){size = newSize;}
   public void setColor(String newColor){color = newColor;}
   public void setRecDate(Date newDate){receiptDate = newDate;}
   public void setExpDate(Date newDate){expirationDate = newDate;}
   public void setLocation(int newLocID){locationID = newLocID;}
}
