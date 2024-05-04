import java.sql.*;
import java.util.*;
import java.io.*;

public class CarDataBaseProgram{
   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
   
      Connection connection = null;
   //define database
      String url = "jdbc:mariadb://localhost:3306/car_db";
      String user = "Car_DB";
      String pwd = "123";
   
   //check connection
      try {
         connection = DriverManager.getConnection(url , user , pwd);
      }
      //catch
   
   //start the program
      try {
      
      //connect the tables
         Statement EmpTable = connection.createStatement();
         Statement BraTable = connection.createStatement();
         Statement CarTable = connection.createStatement();
         Statement AssocCarTable = connection.createStatement();
         Statement OwnTable = connection.createStatement();
         Statement OwnCarTable = connection.createStatement();
         Statement InsuTable = connection.createStatement();
         Statement CarRegTable = connection.createStatement();
      
      
         int choice;
      
         do {
            //menu
            System.out.println("Choose from the following Menu:");
            System.out.println("1) Insert new record");
            System.out.println("2) Display all the records");
            System.out.println("3) Exit");
         
            choice = input.nextInt();
         
         //Excute user selection
            switch (choice) {
                
                //let the user choose the desierd table to insert
               case 1:
                  {
                  
                     System.out.println("Choose the table to insert to:");
                     System.out.println("1) Employee");
                     System.out.println("2) Branch");
                     System.out.println("3) Car");
                     System.out.println("4) Associated Car");
                     System.out.println("5) Owner");
                     System.out.println("6) Owner Car");
                     System.out.println("7) Insurance");
                     System.out.println("8) Car Registration");
                  
                     int TableChoice = input.nextInt();
                  
                     switch (TableChoice) {
                     //insert to employee table
                        case 1:
                           String EID = input.next();
                           String Ename = input.next();
                           String EPhone = input.next();
                           String Email = input.next();
                           String DoB = input.next();
                        
                           String EmpQuery = "INSERT INTO EMPLOYEE VALUES(" + EID +",'"+ Ename +"',"+ EPhone +",'"+ Email +"',"+ DoB +")";
                           EmpTable.executeUpdate(EmpQuery);
                           break;
                     
                     //insert to branch table
                        case 2:
                           String BranchID = input.next();
                           String BPhone = input.next();
                           String City = input.next();
                           String State = input.next();
                           String ZIP = input.next();
                           String mgrID = input.next();
                        
                           String BraQuery = "INSERT INTO BRANCH VALUES(" + BranchID +",'"+ BPhone +"',"+ City +",'"+ State +"',"+ ZIP +"',"+ mgrID +")";
                           BraTable.executeUpdate(BraQuery);
                           break;
                     
                     //insert to car table
                        case 3:
                           int Price = input.nextInt();
                           String license_number= input.next();
                           String Make = input.next();
                           int Year = input.nextInt();
                           String Model = input.next();
                        
                           String CarQuery = "INSERT INTO CAR VALUES(" + Price +",'"+ license_number +"',"+ Make +",'"+ Year +"',"+ Model  +")";
                           CarTable.executeUpdate(CarQuery);
                           break;
                     
                     //insert to associated car table
                        case 4:
                           String licenseNum= input.next();
                           String BrID = input.next();
                           String EmpID = input.next();
                        
                           String AssocCarQuery = "INSERT INTO ASSOCIATED_CAR VALUES(" + licenseNum +",'"+ BrID +"',"+ EmpID +")";
                           AssocCarTable.executeUpdate(AssocCarQuery);
                           break;
                     
                     //insert to owner table
                        case 5:
                           String OwnerID = input.next();
                           String OwnerName = input.next();
                        
                           String OwnQuery = "INSERT INTO OWNER VALUES(" + OwnerID +",'"+ OwnerName +")";
                           OwnTable.executeUpdate(OwnQuery);
                           break;
                     
                     //insert to owned car table
                        case 6:
                           licenseNum= input.next();
                           String OwnID = input.next();
                           String percent_owned = input.next();
                        
                           String OwnCarQuery = "INSERT INTO OWNED_CAR VALUES(" + licenseNum +",'"+ OwnID +"',"+ percent_owned +")";
                           OwnCarTable.executeUpdate(OwnCarQuery);
                           break;
                     
                     //insert to insurance table
                        case 7:
                           String InsuranceID = input.next();
                           String InsDetails = input.next();
                           licenseNum= input.next();
                           String type = input.next();
                        
                           String InsuQuery = "INSERT INTO INSURANCE VALUES(" + InsuranceID +",'"+ InsDetails +"',"+ licenseNum +",'"+ type +")";
                           InsuTable.executeUpdate(InsuQuery);
                           break;
                     
                     //insert to car registration table
                        case 8:
                           InsuranceID = input.next();
                           String RegDate = input.next();
                           String RegExDate = input.next();
                        
                           String CarRegQuery= "INSERT INTO CAR_REGISTRATION VALUES(" + InsuranceID +",'"+ RegDate +",'"+ RegExDate +")";
                           CarRegTable.executeUpdate(CarRegQuery);
                           break;
                     
                        default:
                           System.out.println("Invalid table choice. No record inserted.");
                     }
                  }
                  break;
            
            //-----------------------------------------------------------------------------------------//
            
            
            //let the user choose the desierd table to display the records
               case 2:
               {
                  System.out.println("Choose the table to display from:");
                  System.out.println("1) Employee");
                  System.out.println("2) Branch");
                  System.out.println("3) Car");
                  System.out.println("4) Associated Car");
                  System.out.println("5) Owner");
                  System.out.println("6) Owned Car");
                  System.out.println("7) Insurance");
                  System.out.println("8) Car Registration");
               
                  int tableChoice = input.nextInt();
               
                  switch (tableChoice) {
                  //display employee table records
                     case 1:
                        ResultSet rs = null;
                        rs = EmpTable. executeQuery ("SELECT * FROM EMPLOYEE");
                        while ( rs.next() ) {
                           System.out.print(rs.getString ("EID") + "\n");
                           System.out.print (rs.getString ("Ename") + "\n");
                           System.out.print (rs. getString ("Ephone") + "\n");
                           System.out.print (rs. getString ("Email ") + "\n");
                           System.out.print (rs. getString ("DoB")+ "\n");
                           System.out.println ();
                        }
                        EmpTable.close ();
                        connection.close ();
                        break;
                  
                  //display branch table records
                     case 2:
                        ResultSet rs1 = null;
                        rs1 = BraTable. executeQuery ("SELECT * FROM BRANCH ");
                        while (rs1.next () ) {
                           System.out.print(rs1.getString ("BranchID") + "\n");
                           System.out.print (rs1.getString ("Bphone") + "\n");
                           System.out.print (rs1. getString ("City ") + "\n");
                           System.out.print (rs1. getString ("State ") + "\n");
                           System.out.print (rs1. getString ("ZIP")+ "\n");
                           System.out.print (rs1. getString ("mgrID")+ "\n");
                           System.out.println ();
                        }
                        BraTable.close ();
                        connection.close ();
                        break;
                  
                  //display car table records
                     case 3:
                        ResultSet rs2 = null;
                        rs2 = CarTable. executeQuery ("SELECT * FROM CAR ");
                        while (rs2.next () ) {
                           System.out.print(rs2.getInt ("Price") + "\n");
                           System.out.print (rs2.getString ("license_number") + "\n");
                           System.out.print (rs2. getString ("Make ") + "\n");
                           System.out.print (rs2. getInt ("Year ") + "\n");
                           System.out.print (rs2. getString ("Model")+ "\n");
                           System.out.println ();
                        }
                        CarTable.close ();
                        connection.close ();
                     
                        break;
                  
                  //display associated car table records
                     case 4:
                        ResultSet rs3 = null;
                        rs3 = AssocCarTable. executeQuery ("SELECT * FROM ASSOCIATED_CAR ");
                        while (rs3.next () ) {
                           System.out.print (rs3.getString ("licenseNum") + "\n");
                           System.out.print (rs3. getString ("BrID ") + "\n");
                           System.out.print (rs3. getString ("EmpID")+ "\n");
                           System.out.println ();
                        }
                        AssocCarTable. close ();
                        connection.close ();
                        break;
                  
                  //display owner table records
                     case 5:
                        ResultSet rs4 = null;
                        rs4 = OwnTable. executeQuery ("SELECT * FROM OWNER ");
                        while (rs4.next () ) {
                           System.out.print (rs4.getString ("OwnerID") + "\n");
                           System.out.print (rs4. getString ("OwnerName ") + "\n");
                           System.out.println ();
                        }
                        OwnTable. close ();
                        connection.close ();
                        break;
                  
                  //display ownerd car table records
                     case 6:
                        ResultSet rs5 = null;
                        rs5 = OwnCarTable. executeQuery ("SELECT * FROM OWNED_CAR");
                        while ( rs5.next() ) {
                           System.out.print (rs5.getString ("licenseNum") + "\n");
                           System.out.print (rs5. getString ("OwnID ") + "\n");
                           System.out.print (rs5. getString ("percent_owned")+ "\n");
                           System.out.println ();
                        }
                        OwnCarTable. close ();
                        connection.close ();
                        break;
                  
                  //display insurance table records
                     case 7:
                        ResultSet rs6 = null;
                        rs6 = InsuTable. executeQuery ("SELECT * FROM INSURANCE ");
                        while (rs6.next () ) {
                           System.out.print (rs6.getString ("InsuranceID") + "\n");
                           System.out.print (rs6. getString ("InsDetails ") + "\n");
                           System.out.print (rs6. getString ("licenseNum")+ "\n");
                           System.out.print (rs6. getString ("type")+ "\n");
                           System.out.println ();
                        }
                        InsuTable. close ();
                        connection.close ();
                        break;
                  
                  //display car registration table records
                     case 8:
                        ResultSet rs7 = null;
                        rs7 = CarRegTable. executeQuery ("SELECT * FROM CAR_REGISTRATION ");
                        while (rs7.next () ) {
                           System.out.print (rs7.getString ("RegDate") + "\n");
                           System.out.print (rs7. getDate("RegExDate ") + "\n");
                           System.out.println ();
                        }
                        CarRegTable. close ();
                        connection.close ();
                        break;
                     default:
                        System.out.println("Invalid table choice. No records displayed.");
                  } 
                  break;
               }
            
            //-----------------------------------------------------------------------------------------//
            
            //exit the program
               case 3:
                  System.out.println("Exiting...");
                  break;
                        
            //to inform user
               default:
                  System.out.println("Invalid choice. Please choose again.");
            
            
            }//end switch
         }//end do
         while(choice!=3);
      
      } //end try
            //catch
   
   }//end the main
}//end the class