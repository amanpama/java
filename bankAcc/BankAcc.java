public class BankAcc{

private double checkingBalance;
private double savingBalance;
public static int accountsCreated = 0;
public static double totalBread = 0.0;

    //Constructor
    public BankAcc(double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        accountsCreated++;
        totalBread+= checkingBalance;
        totalBread+= savingBalance;
    }
    //METHODS   
    public void addMoneyChecking(double bread ){
        this.checkingBalance += bread;
        totalBread += bread;
    }
    public void addMoneySaving(double bread ){
        this.savingBalance += bread;
        totalBread += bread;
    }
    public void subtractMoneyChecking(double bread ){
        if(checkingBalance < totalBread){
        System.out.println("ur broke in checking");
        }
        else{
            this.checkingBalance -= bread;
            totalBread -= bread; 
        }
    }
    public void subtractMoneySaving(double bread ){
        if(savingBalance < totalBread){
            System.out.println("ur broke in savings");
        }
        else{
            this.savingBalance -= bread;
            totalBread -= bread;
        }
    }
    public double getTotalMoney(){
        return this.checkingBalance + this.savingBalance;
    }
    


    //getter and setters
    // public void addMoney(String , double ){
    public double getcheckingBalance(){
        return this.checkingBalance;
    }
    public double getsavingBalance(){
        return this.savingBalance;
    }
}