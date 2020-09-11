public class Info {

import java.util.*;
  
public static void main (String args[]) {


String GM = "Sebastian Cortez";
  
  
String jobTitle = " ";
  
System.out.println("GM: " + "please enter a job description for the employees");
jobTitle = in.nextLine();
    
  

switch (jobTitle) {
    
  case "carhop": 
    jobTitle = "carhop";
    break;
    
    
  case "shift manager":
    jobTitle = "shift manager";
    break;
    
    
  case "asst mngr":
    jobTitle = "assitant manager";
    break;
    
  case "cook":
    jobTitle = "cook";
    break;
    
  case "manager":
    jobTitle = "manager";
    
  default:
    jobTitle = "carhop";
    
    
    
}



}


}
