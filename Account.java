public class Account {
  String username;
  String password;
  
  String[] userlist = {"meme", "dank"};
  String[] passlist = {"lord", "meme"};
  
  public Account (String user, String pass) {
    username = user;
    password = pass;
  }

  public Boolean checkAccount () {
    int userIndex;
    int i;
    

    for (i = 0; i < userlist.length; i++) { //its .length i looked it up okay
      if (userlist[i].equals(username)) { 
        if(passlist[i].equals(password))
          return true;
      }
    }
    return false;
  } //end checkAccount

} // end class