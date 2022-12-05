package com;

public class Supplier
{
   int supplierID;
   String name;
   String phone;
   String email;

   public Supplier(int newID, String newName, String newPhone, String newEmail)
   {
      supplierID = newID;
      name = newName;
      phone = newPhone;
      email = newEmail;
   }

   public int getSupplierID()
   {
      return supplierID;
   }
   public String getName()
   {
      return name;
   }
   public String getPhone()
   {
      return phone;
   }
   public String getEmail()
   {
      return email;
   }
}
