import java.time.LocalDateTime;
public  abstract class BankAccount implements Comparable<BankAccount>
{
    protected String AccountNumber;
    protected String OwnerName;
    protected double Balance;
    protected LocalDateTime createdAt;
    public BankAccount(String AccountNumber,String OwnerName,double Balance,LocalDateTime createdAt)
    {
        if (Balance < 0) {
            throw new NegativeAmountException("So du ban dau khong the am");
        }
        this.AccountNumber=AccountNumber;
        this.OwnerName=OwnerName;
        this.Balance=Balance;
        this.createdAt = LocalDateTime.now();
    }
    public String getAccountNumber()
    {
        return AccountNumber;
    }
    public String getOwnerName()
    {
        return OwnerName;
    }
    public double getBalance()
    {
        return Balance;
    }

    public void deposit(double amount)
    {
        if (amount<=0) throw new NegativeAmountException("So tien nop vao phai lon hon 0 VND");
        Balance+=amount;
    }
    public abstract  void withdraw(double amount);

    @Override
    public String toString() {
        return "So tai khoan: " + AccountNumber + ", Chu tai khoan: " + OwnerName + ", So du: " + Balance;
    }
   @Override
    public int compareTo(BankAccount other)
     {
        return Double.compare(this.Balance, other.Balance);
    }
}
