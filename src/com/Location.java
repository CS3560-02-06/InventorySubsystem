package com;

public class Location
{
   int locationID;
   String name;

   public Location (int newID, String newName)
   {
      locationID = newID;
      name = newName;
   }

   public int GetLocationID()
   {
      return locationID;
   }
   
   public String GetName()
   {
      return name;
   }
}
