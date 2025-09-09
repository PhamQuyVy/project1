import java.time.LocalDateTime;
public class CreditAccount extends BankAccount implements IInterestBearing,IFeeDeDuctible
 {
    private double limit;
    private double fee;
    private double interest;
    public CreditAccount(String AccountNumber,String OwnerName,double Balance,LocalDateTime createdAt, double limit,double fee,double interest)
    {
        super(AccountNumber,OwnerName,Balance,createdAt);
        this.limit=limit;
        this.fee=fee;
        this.interest=interest;
    }
    public CreditAccount(String AccountNumber, String OwnerName, double Balance, double limit, double fee, double interest) {
        super(AccountNumber, OwnerName, Balance, LocalDateTime.now());
        this.limit = limit;
        this.fee = fee;
        this.interest = interest;
    }
    @Override
    public void withdraw(double amount)
    {
        if (amount<=0) throw new NegativeAmountException("So tien rut phai nhieu hon 0 VND");
        if (Balance-amount<-limit) throw new OverdraftLimitException(" Vuot muc han tin dung");
        Balance-=amount;
    }
    @Override
    public void applyMonthlyInterest()
    {
        if (Balance<0)
        {
            double rate=interest/12/100;
            double lai=Math.abs(Balance)*rate; 
            Balance-=lai;
        }
    }
    @Override
    public void applyMonthlyFee()
    {
        Balance-=fee;
    }
}
