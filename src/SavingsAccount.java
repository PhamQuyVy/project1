import java.time.LocalDateTime;
public class SavingsAccount extends BankAccount implements IInterestBearing
 {
    private double annual_rate;
    public SavingsAccount(String AccountNumber,String OwnerName,double Balance, LocalDateTime createdAt,double annual_rate)
    {
        super(AccountNumber,OwnerName,Balance,createdAt);
        this.annual_rate=annual_rate;
    }
     public SavingsAccount(String AccountNumber, String OwnerName, double Balance, double annual_rate) {
        super(AccountNumber, OwnerName, Balance, LocalDateTime.now());
        this.annual_rate = annual_rate;
    }
    
    @Override
    public void withdraw(double amount)
    {
        if (amount<=0) 
        {
            throw new NegativeAmountException(" So tien rut ra phai nhieu hon 0 VND");
        }
        if (amount>Balance) throw new InsufficientFundsException("So du khong du de thuc hien thao tac rut tien.  Vui long nhap lai so tien can rut.Xin chan thanh cam on!!!");
        Balance-=amount;

    }
    @Override
    public void applyMonthlyInterest()
    {
        double rate=annual_rate/12/100;
        Balance+=Balance*rate;
    }

}
