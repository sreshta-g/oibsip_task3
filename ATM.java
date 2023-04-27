
import java.util.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;

class accountofbank{
    static  void registers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("your  name:");
        ATM.name=sc.nextLine();
        System.out.println("Enter username :");
        String username=sc.nextLine();
        System.out.println(" password registration  :");
        String password=sc.nextLine();
        System.out.println("press your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println(" REGISTERED SUCCESSFULLY!");
        System.out.println("---------------");
        ATM.promptDetails();
        while(true){
            display(ATM.name);
            int noOfchoices=sc.nextInt();
            if(noOfchoices==1){
                login(username,password);
                break;
            }
            else {
                if(noOfchoices==2){
                    System.exit(0);
                }
                else{
                    System.out.println(" enter again, invalid value");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transactions{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("press withdraw amount :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("payment Rs"+wcash+"/- successfully withdrawn");
            System.out.println("-----------------------");
        }
        else{
            System.out.println("withdraw cash insufficient balance");
            System.out.println("------------------------");
        }
        ATM.promptDetails();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Give payment amount for deposit :");
        int dcash=sc.nextInt();
        ATM.balanceupdation(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("payment  Rs."+dcash+"/-  successfully deposited!");
        System.out.println("---------------------------");
        ATM.promptDetails();
    }
    static void transferDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the reciever:");
        String s=sc.nextLine();
        System.out.println("reciever account number");
        int num=sc.nextInt();
        System.out.println("Transferred payment is:");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("payment successfully."+tcash+"/-  yeah , it got transferred");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("sorry , insufficient balance , No transfer takes place");
            System.out.println("---------------------------");
        }
    }
}
class checking{
    static void balancechecker(){
        System.out.println("------------------");
        System.out.println("  Available balance of bank account:");
        ATM.balanceshower();
        System.out.println("---------------------------");
        ATM.promptDetails();
    }
}
class his{
    static void transactionHistoryDetails(){
            System.out.println("---------------------");
            System.out.println("History Transaction:");
            int p=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(p)+" ");
                    p++;
                }
                System.out.println("----------------");
            }
            }
            else {
                System.out.println("oops! account is empty");
            }
            ATM.promptDetails();
    }
}


public class ATM{
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void balanceupdation(int dcash){
        balance=balance+dcash;
    }
    static void balanceshower(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("option selection :");
        System.out.println("1.Register");
        System.out.println("2.Exit");
        System.out.println(" No of choice Enter");
        int choice =sc.nextInt();
        if (choice==1){
            accountofbank.registers();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select value from the given options :");
                homepage();
            }
        }
    }
    static void promptDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdrawal ");
        System.out.println("2. Deposits ");
        System.out.println("3. Transfer details ");
        System.out.println("4.  balance checker ");
        System.out.println("5. Transaction History details ");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transactions.withdraw();
            case 2:
                transactions.deposit();
            case 3:
                transactions.transferDetails();
            case 4:
                checking.balancechecker();
            case 5:
                his.transactionHistoryDetails();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}