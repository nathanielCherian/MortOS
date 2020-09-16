
/* Scrum Group 1 */
import java.util.*;
import java.lang.Math;
import java.util.Random;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

class Main {
  public static Scanner scanner;
  public static Boolean login;
  public static Account account;
  public static Random rand = new Random(); //instance of random class

  public static void main(String[] args) {

    account = login();

    Boolean login = account.checkAccount();

    if (!login) {
      System.out.println("Access denied.");
    } else {
      printLogin(account);
    }

    while (login) {
      System.out.print("MortOS> ");
      scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      int int_random = rand.nextInt(100);
      if (int_random <= 10){
        System.out.println("HEY HEY HEY!");
      }else if(int_random <= 30){
        System.out.println("CODE CODE CODE!");

      }

      switch (input) {

      case "add":
        add_command();
        break;

      case "pythag":
        pythag_command();
        break;

      case "cls":
        System.out.print("\u001B[2J" + "\u001B[0;0H");  
        break;

      case "anim":
        Anim.main(null);
        break;
      case "exit":
        login = false;
        System.out.println("bye!");
        break;

      case "":
        break;

      default:
        System.out.println("Mr. Mortensen says: " + input);
        break;
      } // end switch
    } // end while


  } // end main
  // so basically we're going to create a terminal with commands in it, and when
  // the user puts in a command, it performs a certain action. it'd help if you
  // guys learned java on like codecademy or something bc idk why mort is making
  // us do this first week lmao
  // goal is to use inputs and outputs

  public static void printLogin(Account account) {
    String intro_text = "" + 
    "                   _     ___  __    \n" + 
    "  /\\/\\   ___  _ __| |_  /___\\/ _\\   \n"+ 
    " /    \\ / _ \\| '__| __|//  //\\ \\    \n" + 
    "/ /\\/\\ \\ (_) | |  | |_/ \\_// _\\ \\   \n"+ 
    "\\/    \\/\\___/|_|   \\__\\___/  \\__/   \n";

    System.out.println(intro_text);
    System.out.println("\t\t\t\t by Scrum Group 1");
    System.out.print("\n");

    System.out.println("logged in as '" + account.username + "'");

  }

  public static void add_command() {

    try{
    
    System.out.print("enter num1: ");
    Float num1 = scanner.nextFloat();

    System.out.print("enter num2: ");
    Float num2 = scanner.nextFloat();

    Float sum = num1 + num2;

    System.out.println(num1.toString() + " + " + num2.toString() + " = " + sum.toString());
    } catch(Exception e){
      System.out.println("ENTER A NUMBER!");
    }

  }

  public static void pythag_command() {

    try{

      System.out.print("enter side1: ");
      Float side1 = scanner.nextFloat();

      System.out.print("enter side2: ");
      Float side2 = scanner.nextFloat();  

      Double pythag = Math.sqrt((side1*side1) + (side2*side2));

      System.out.println("side3: " + pythag.toString());


    } catch(Exception e){
      System.out.println("ENTER A NUMBER!");
    }

  }

  public static Account login() {
    scanner = new Scanner(System.in);

    Account acc = new Account("filler", "null", false);
    
    System.out.print("Username: "); // here
    acc.username = scanner.nextLine();

    if (acc.username.equals("Guest")) {
      acc.guest = true;
    }
    
    if (!acc.guest) {
      System.out.print("Password: ");
      acc.password = scanner.nextLine();
    }
    return acc;
  }

} // end class
