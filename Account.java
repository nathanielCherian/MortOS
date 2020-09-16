public class Account {
  String username;
  String password;
  Boolean guest;

  String[] userlist = {"nathanc", "anthonyv", "u"};
  String[] passlist = {"codingrocks", "101beast", "p"};

  public Account (String user, String pass, Boolean guestCheck) {
    username = user;
    password = pass;
    guest = guestCheck;
  }

  public Boolean checkAccount () {
    int i;

    if (username.equals("Guest")) {
      guest = true;
      return true;
    }

    for (i = 0; i < userlist.length; i++) {
      if (userlist[i].equals(username)) { 
        if(passlist[i].equals(password))
          return true;
      }
    }
    return false;
  } //end checkAccount

} // end class