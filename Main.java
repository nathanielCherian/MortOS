
/* Scrum Group 1 */
import java.util.*;
import java.lang.Math;
import java.util.Random;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
 


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

      case "currency":
        currency_command();
        break;

      case "add":
        add_command();
        break;

      case "subtract":
        subtract_command();
        break;

      case "multiply":
        multiply_command();
        break;
      
      case "divide":
        divide_command();
        break;

      case "pythag":
        pythag_command();
        break;

      case "cls":
        System.out.print("\u001B[2J" + "\u001B[0;0H");  
        break;

      case "wave":
        String[] qargs = {"wave"};
        Anim.main(qargs);
        break;

      case "boom":
        String[] bargs = {"boom"};
        Anim.main(bargs);
        break;

      case "base":
        BaseAnim bs = new BaseAnim(80, 40);
        bs.grid();
        break;

      case "launch":
        Launch la = new Launch(200, 40);
        la.present(30.0, 30.0);
        break;
      
      case"im":
        System.out.print("Filename: ");
        String filename = scanner.nextLine();

        System.out.print("Scale factor (2, 4, 8, 16): ");
        int SCALE_FACTOR = scanner.nextInt();

        Image im = new Image(filename, SCALE_FACTOR);
        int[][] gs = im.to_grayscale();
        int[][] scaled_gs = im.scale(gs);
        im.to_ascii(scaled_gs);
        break;

      case "gif":

        System.out.print("Directory: ");
        String directory = scanner.nextLine();

        System.out.print("Scale factor (2, 4, 8, 16): ");
        int sf = scanner.nextInt();

        System.out.print("Delay(ms): ");
        int delay = scanner.nextInt();

        Gif g = new Gif();
        g.animate(directory, sf, delay);
        break;

      case "exit":
        login = false;
        System.out.println("bye!");
        break;
      
      case "":
        break;

      case "rfile":
        if (!account.guest) {
          readFile();
        } else {
          System.out.println("Insufficient Permissions");
        }
        
        break;

      case "wfile":
        if (!account.guest) {
          writeFile();
        } else {
          System.out.println("Insufficient Permissions");
        }
        
        break;
      
      case "vietnamese":
        System.out.println("Câu này là Tiếng Việt. Tôi muốn thấy khả năng của Unicode.");
        break;

      case "fibonacci":
        System.out.println("What term do you want?");
        try {
          int num = scanner.nextInt();
          Fibonacci f = new Fibonacci(num);
          System.out.println("The " + num + " term of the Fibonacci Sequence is " + f.fib(num));
          f.printSeq();
        } catch (Exception e) {
          System.out.println("That's not a number :(");
          break;
        }
        break;

      case "pas":
        Pascal.pascal(10);
        break;

      case "help":
        try {

          File help = new File("help.txt");
          Scanner reader = new Scanner(help);
    
          while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
          }
    
          reader.close();
    
        } catch (FileNotFoundException e) {
          System.out.println("An error has occurred");
        }

        break;
      default:
        System.out.println("Mr. Mortensen says: " + input);
        break;
      } // end switch
    } // end while


  } // end main

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
    System.out.println("Use 'help' for a list of commands!");
  }
  
  public static void currency_command() {

    double amount, dollar, pound, code, euro, yen, rupee;
 
		DecimalFormat f = new DecimalFormat("##.##");
 
		Scanner sc = new Scanner(System.in);
 
		System.out.println("hi, Welcome to the Currency Converter!");
 
		System.out.println("which currency You want to Convert ? ");
		
		System.out.println("1:Ruppe \t2:Dollar \t3:Pound \n4:Euro \t5:Yen");
		code = sc.nextInt();
		
		System.out.println("How much Money you want to convert?");
		amount = sc.nextFloat();
 
		// For amounts Conversion
		if (code == 1) {
 
			dollar = amount / 70;
			System.out.println("Your " + amount + " Rupees : " + f.format(dollar) + " Dollars");
 
			pound = amount / 88;
			System.out.println("Your " + amount + " Rupees : " + f.format(pound) + " Pounds");
 
			euro = amount / 80;
			System.out.println("Your " + amount + " Rupees : " + f.format(euro) + " Euros");
 
			yen = amount / 0.63;
			System.out.println("Your " + amount + " Rupees : " + f.format(yen) + " Yen");
 
		} else if (code == 2) {
			// For Dollar Conversion
 
			rupee = amount * 70;
			System.out.println("Your " + amount + " Dollars : " + f.format(rupee) + " Rupees");
 
			pound = amount * 0.78;
			System.out.println("Your " + amount + " Dollars : " + f.format(pound) + " Pounds");
 
			euro = amount * 0.87;
			System.out.println("Your " + amount + " Dollars : " + f.format(euro) + " Euros");
 
			yen = amount * 111.087;
			System.out.println("Your " + amount + " Dollars : " + f.format(yen) + " Yen");

		} else if (code == 3) {
			// For Pound Conversion
 
			rupee = amount * 88;
			System.out.println("Your " + amount + " Pounds : " + f.format(rupee) + " Rupees");
 
			dollar = amount * 1.26;
			System.out.println("Your " + amount + " Pounds : " + f.format(dollar) + " Dollars");
 
			euro = amount * 1.10;
			System.out.println("Your " + amount + " Pounds : " + f.format(euro) + " Euros");
 
			yen = amount * 140.93;
			System.out.println("Your " + amount + " Pounds : " + f.format(yen) + " Yen");
 
		} else if (code == 4) {
			// For Euro Conversion
 
			rupee = amount * 80;
			System.out.println("Your " + amount + " Euros : " + f.format(rupee) + " Rupees");
 
			dollar = amount * 1.14;
			System.out.println("Your " + amount + " Euros : "  + f.format(dollar) + " Dollars");
 
			pound = amount * 0.90;
			System.out.println("Your " + amount + " Euros : " + f.format(pound) + " Pounds");
 
			yen = amount * 127.32;
			System.out.println("Your " + amount + " Euros : " + f.format(yen) + " Yen");
 
		} else if (code == 5) {
 
			// For Yen Conversion
 
			rupee = amount * 0.63;
			System.out.println("Your " + amount + " Yen : " + f.format(rupee) + " Rupees");
 
			dollar = amount * 0.008;
			System.out.println("Your " + amount + " Yen : " + f.format(dollar) + " Dollars");
 
			pound = amount * 0.007;
			System.out.println("Your " + amount + " Yen : " + f.format(pound) + " Pounds");
 
			euro = amount * 0.007;
			System.out.println("Your " + amount + " Yen : " + f.format(euro) + " Euros");
		} 
		else {
			System.out.println("Invalid Input");
		}
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

  public static void subtract_command() {

    try{
    
    System.out.print("enter num1: ");
    Float num1 = scanner.nextFloat();

    System.out.print("enter num2: ");
    Float num2 = scanner.nextFloat();

    Float sum = num1 - num2;

    System.out.println(num1.toString() + " - " + num2.toString() + " = " + sum.toString());
    } catch(Exception e){
      System.out.println("ENTER A NUMBER!");
    }

  }

  public static void multiply_command() {

    try{
    
    System.out.print("enter num1: ");
    Float num1 = scanner.nextFloat();

    System.out.print("enter num2: ");
    Float num2 = scanner.nextFloat();

    Float sum = num1 * num2;

    System.out.println(num1.toString() + " * " + num2.toString() + " = " + sum.toString());
    } catch(Exception e){
      System.out.println("ENTER A NUMBER!");
    }

  }
  
  public static void divide_command() {

    try{
    
    System.out.print("enter num1: ");
    Float num1 = scanner.nextFloat();

    System.out.print("enter num2: ");
    Float num2 = scanner.nextFloat();

    Float sum = num1 / num2;

    System.out.println(num1.toString() + " / " + num2.toString() + " = " + sum.toString());
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

  public static void readFile() {
    String fileName = getFile();
    
    try {

      File f = new File(fileName);
      Scanner reader = new Scanner(f);

      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        System.out.println(data);
      }

      reader.close();

    } catch (FileNotFoundException e) {
      System.out.println("An error has occurred");
    }
  }

  public static void writeFile() {
    String fileName = getFile();

    if (fileName.contains(".java") || fileName.contains(".class") || fileName.contains(".md") || fileName.equals("help.txt")) {

      System.out.println("stop trying to brick the code you ape");

    } else {
      scanner = new Scanner(System.in);

      try {

        FileWriter w = new FileWriter(fileName);
        System.out.print("What would you like to write to this file? ");
        String line = scanner.nextLine();

        String writing = "";
        Scanner r = new Scanner(fileName);
        while (r.hasNextLine()) {
          String data = r.nextLine();
          writing += data + "\n";
          System.out.println(writing);
        }
        w.write(writing + line);
        r.close();
        w.close();

      } catch (IOException e) {
        
        System.out.println("An error has occurred");

      } //end try
    } //end else
  } //end func

  public static String getFile() {
    String fileName;
    Scanner r = new Scanner(System.in);
    System.out.print("Enter a file name: ");
    fileName = r.nextLine();
    r.close();
    return fileName;
  }

} // end class
