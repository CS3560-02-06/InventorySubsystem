package com;

public class Category
{
   int categoryID;
   String name;

   public Category(int newID, String newName)
   {
      categoryID = newID;
      name = newName;
   }
   
   public int getCategoryID()
   {
      return categoryID;
   }
   public String getName()
   {
      return name;
   }
}
