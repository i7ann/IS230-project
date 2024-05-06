package CarDataBase;

import java.sql.*;
import java.util.*;

public class CarDataBaseProgram{

public static void main(String[] args) throws Exception{
   
      Scanner input = new Scanner(System.in);
      
      Connection connection = null;
   //define database
      String url = "jdbc:mariadb://localhost:3306/car_db";
      String user = "root";
      String pwd = "";
   
   //check connection
     
      try {
          connection = DriverManager.getConnection(url , user , pwd);
       }
       catch(SQLException e){
          e.printStackTrace();
       }

      System.out.println("*Successfully connected to database*");
      
   //start the program
      try {
      
      //connect to the table
         Statement BraTable = connection.createStatement();
      
         int choice;
      
         do {
            //menu
        	 System.out.println("Welcome to Car Rental DataBase");
        	  System.out.println("-------------------------------------");
            System.out.println("Table Branch:");
            System.out.println("1) Insert new record");
            System.out.println("2) Display all the records");
            System.out.println("3) Exit");
            System.out.println("Choose an operation:)");
         	  System.out.println("-------------------------------------");
         
            choice = input.nextInt();
         
         //Execute user selection
            switch (choice) {
                
                //let the user choose the desired table to insert
               case 1:
                  {
                	  
                  char answer = ' ';
                	
                  //assume that user will enter valid data type
                  while (answer!= 'N') {
                	  
                	  String BranchID="" , BPhone="" , ZIP="", City="", State="";
                		
                     //insert to branch table
                	   	System.out.println("Branch - INSERTION:");
                	   	
                	   	//check user input validation
                	    try {
                	    	
                        System.out.print("Branch ID: ");
                          BranchID = input.next();
                          if (BranchID.length() > 9) 
                        	  throw new InputMismatchException("");
                	    	
                	    	
                       	System.out.print("Branch Phone Number: ");
                          BPhone = input.next();
                          if (BPhone.length() > 10) 
                        	  throw new InputMismatchException("");
                	    	
                       	System.out.print("Branch City: ");
                          City = input.next();
                          if (City.length() > 20) 
                        	  throw new InputMismatchException("");
              	    	
                       	System.out.print("Branch State: ");
                          State = input.next();
                          if (State.length() > 10) 
                        	  throw new InputMismatchException("");
              	    	
                       	System.out.print("Branch Zip Code: ");
                          ZIP = input.next();
                          if (ZIP.length() > 5) 
                        	  throw new InputMismatchException("");
                         
                	    }
                          catch(InputMismatchException e) {
                    		 System.out.println("*invalid input, program will closed, try again:)*");
                    		 System.exit(0);
                    	  }
                	   
                
                  
                        
                           String BraQuery = "INSERT INTO BRANCH VALUES('"+ BranchID +"' , '"+ BPhone +"' , '"+ City +"' , '"+ State +"' , '"+ ZIP +"' , null )";
                           BraTable.executeUpdate(BraQuery);
                           System.out.println("*Branch added successfully*");
                           
                           System.out.println("Insert a new record (Y/N)?");
                           answer = input.next().charAt(0);
                  }
                           break;
                  }
            
            //-----------------------------------------------------------------------------------------//
            
            
            //let the user choose the desired table to display the records
               case 2:
               {
                  
                  //display branch table records
                    
                        ResultSet rs = null;
                        rs = BraTable. executeQuery ("SELECT * FROM BRANCH ");
                        while (rs.next ()) {
                           System.out.println("Branch ID: " + rs.getString("BranchID"));
                           System.out.println("Branch Phone Number: " + rs.getString("Bphone"));
                           System.out.println("Branch City: " + rs.getString("City"));
                           System.out.println("Branch State: " + rs.getString("State"));
                           System.out.println("Branch Zip Code: " + rs.getString("ZIP"));
          
                        BraTable.close ();
                        break;
                        }
               }
            //-----------------------------------------------------------------------------------------//
            
            //exit the program
               case 3:
                  System.out.println("Exiting...");
                  break;
                        
            //to inform user
               default:
                  System.out.println("*Invalid choice. Please choose again*");
            
            
            }//end switch
         }//end do
         while(choice!=3);
      
      } //end try
      catch(SQLException e) {
         System.out.println("*An error occurred*");
         e.printStackTrace();
      }
            
      finally {
         if ( connection != null ) //check closing connection
            try{
               connection.close();
            }
            catch(SQLException e) {
               System.out.println("*Error closing connection*");
            }
      }//end finally
   
   }//end the main
}//end the class
