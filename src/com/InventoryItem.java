package com;

import java.time.*;

public class InventoryItem
{
   int productID;
   int inventoryID;
   double price;
   int amountInStock;
   double size;
   String color;
   LocalDate receiptDate;
   LocalDate expirationDate;
   int locationID;


   // Constructor
   public InventoryItem(int newPID, int newIID, double newPrice, int newAmount, double newSize, String newColor, LocalDate newRDate, LocalDate newEDate, int newLoc)
   {
      productID = newPID;
      inventoryID = newIID;
      price = newPrice;
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
   public LocalDate getRecDate(){return receiptDate;}
   public LocalDate getExpDate(){return expirationDate;}
   public int getLocation(){return locationID;}

   // Setters
   public void setProductID(int newID){productID = newID;}
   public void setInventoryID(int newID){inventoryID = newID;}
   public void setPrice(double newPrice){price = newPrice;}
   public void setAmount(int newAmount){amountInStock = newAmount;}
   public void setSize(double newSize){size = newSize;}
   public void setColor(String newColor){color = newColor;}
   public void setRecDate(LocalDate newDate){receiptDate = newDate;}
   public void setExpDate(LocalDate newDate){expirationDate = newDate;}
   public void setLocation(int newLocID){locationID = newLocID;}
}
