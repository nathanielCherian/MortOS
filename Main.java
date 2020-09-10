
/* Scrum Group 1 */
import java.util.*;

class Main {
  public static Scanner scanner;
  public static Boolean login;
  public static Account account;

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
      String input = scanner.next();

      switch (input) {

      case "add":
        System.out.println("add code here");
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

  public static void printName(String name) {

  }

  public Account login() {
    Account acc = new Account("filler", "null");
    
    System.out.print("Username: "); // here
    acc.username = scanner.nextLine();

    System.out.print("Password: ");
    acc.password = scanner.nextLine();

    return acc;
  }

} // end class
