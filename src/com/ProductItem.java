package com;

public class ProductItem
{
   int productID;
   String name;
   int categoryID;
   int supplierID;
   String description;

   // Constructor
   public ProductItem(int newID, String newName, int newCategory, int newsupplier, String newDesc)
   {
      productID = newID;
      name = newName;
      categoryID = newCategory;
      supplierID = newsupplier;
      description = newDesc;
   }

   // Getters
   public int getProductID(){return productID;}
   public String getName(){return name;}
   public int getCategory(){return categoryID;}
   public int getBrand(){return supplierID;}
   public String getDesc(){return description;}

   // Setters
   public void setProductID(int newID){productID = newID;}
   public void setName(String newName){name = newName;}
   public void setCategory(int newCategory){categoryID = newCategory;}
   public void setBrand(int newsupplier){supplierID = newsupplier;}
   public void setDesc(String newDesc){description = newDesc;}
}
