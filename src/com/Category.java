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
   
   public int GetCategoryID()
   {
      return categoryID;
   }
   public String GetName()
   {
      return name;
   }
}
