import java.time.LocalDateTime;
public class CheckingsAccount  extends BankAccount implements IFeeDeDuctible
{
    double monthly_fee;
    double fee;
    public CheckingsAccount(String AccountNumber,String OwnerName,double Balance,LocalDateTime createdAt,double monthly_fee, double fee)
    {
        super(AccountNumber,OwnerName,Balance,createdAt);
        this.monthly_fee=monthly_fee;
        this.fee=fee;
    }
     public CheckingsAccount(String AccountNumber, String OwnerName, double Balance, double fee, double monthly_fee) {
        super(AccountNumber, OwnerName, Balance, LocalDateTime.now());
        this.fee = fee;
        this.monthly_fee = monthly_fee;
    }
   @Override
   public void withdraw(double amount)
   {
    if(amount<=0) throw new NegativeAmountException("So tien rut phai nhieu hon 0 VND");
    double total=amount+fee;
    if (total>Balance) throw new InsufficientFundsException("So du khong du de rut kem tinh phi!!");
    Balance-=total;
   }
   @Override
   public void applyMonthlyFee()
   {
    if (monthly_fee>Balance) throw new InsufficientFundsException("Khong du so du de tru phi duy tri tai khoan hang thang!");
    Balance-=monthly_fee;
   }
}
