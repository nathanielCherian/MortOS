public class Heli extends BaseAnim {

    public Heli(int w, int h) {
        super(w, h);
    }

    public void heli() {

        System.out.println("                            ||");
        System.out.println("                         __ ||                                        ___");
        System.out.println("                         ] ''''---...._                             .' //");
        System.out.println("                   _,-'''==============`--.                       .'/)//");
        System.out.println("                 ,' ) ,--. .-----.         `.___________________.' ///_");
        System.out.println("               .'  / /___| |_____|                       _______  ()  _>");
        System.out.println("              /   / /____| |__|__|             ,----'''''       `//  \\");
        System.out.println("            .<`=='===========================.'                 (/`.  \\");
        System.out.println("           (  `.----------------------------/                       `._\\");
        System.out.println("            `-._\\_                ____...-'");
        System.out.println("                  '''--ii--''''77");
        System.out.println("                 .____//______//____,");
        System.out.println("                 `------------------'");
        System.out.println("                   Jett's Helicopter");
    }

    public void animate() {

        clear();
        for(int i = 0; i < 10; i++) {

            clear();
            for(int n = 0; n < 27; n++) {

                System.out.println("___________________________    _________________________");
                System.out.println("`--------------------------`()'--------------------------'");
                System.out.println("\u001B[2J");
                String cursor_move = BUILDER_ESCAPE + "0;0H";
                System.out.print(cursor_move+"\033[0m");
            }
            for(int p = 27; p > 0; p--) {
                
            }
        }  
    }
    public String printrotor(int x, String s) {

        String rotorlength = new String(new char[x]).replace("\0", s);
        return rotorlength;
    }
}
