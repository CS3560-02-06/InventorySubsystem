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

   public int GetSupplierID()
   {
      return supplierID;
   }
   public String GetName()
   {
      return name;
   }
   public String GetPhone()
   {
      return phone;
   }
   public String GetEmail()
   {
      return email;
   }
}
