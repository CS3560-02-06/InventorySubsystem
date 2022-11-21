package com;

public class ProductItem
{
   int productID;
   String name;
   int categoryID;
   int brandID;
   String description;

   // Constructor
   public ProductItem(int newID, String newName, int newCategory, int newBrand, String newDesc)
   {
      productID = newID;
      name = newName;
      categoryID = newCategory;
      brandID = newBrand;
      description = newDesc;
   }

   // Getters
   public int getProductID(){return productID;}
   public String getName(){return name;}
   public int getCategory(){return categoryID;}
   public int getBrand(){return brandID;}
   public String getDesc(){return description;}

   // Setters
   public void setProductID(int newID){productID = newID;}
   public void setName(String newName){name = newName;}
   public void setCategory(int newCategory){categoryID = newCategory;}
   public void setBrand(int newBrand){brandID = newBrand;}
   public void setDesc(String newDesc){description = newDesc;}
}
