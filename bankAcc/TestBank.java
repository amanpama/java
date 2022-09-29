public class TestBank{


public static void main(String [] args){
    BankAcc user1 = new BankAcc(21 , 42.0);
    // this is adding money
    // System.out.println(user1.getcheckingBalance());
    // System.out.println(user1.getsavingBalance());
    // user1.addMoneySaving(60);
    // System.out.println(user1.getsavingBalance());
    // user1.addMoneyChecking(22);
    // System.out.println(user1.getcheckingBalance());
    
    //This is subtracting money

    user1.subtractMoneyChecking(100);
    System.out.println(user1.getcheckingBalance());
    user1.subtractMoneySaving(90);
    System.out.println(user1.getsavingBalance());
    user1.getTotalMoney();
    System.out.println(user1.getTotalMoney());
    }
    
}