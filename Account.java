public class Account {
  String username;
  String password;

  String[] userlist = {"nathanc", "anthonyv", "u"};
  String[] passlist = {"codingrocks", "101beast", "p"};

  public Account (String user, String pass) {
    username = user;
    password = pass;
  }

  public Boolean checkAccount () {
    int i;

    if (username.equals("Guest")) {
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