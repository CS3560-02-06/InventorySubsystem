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

   public int getLocation()
   {
      return locationID;
   }
   
   public String getName()
   {
      return name;
   }
}
