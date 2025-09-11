import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank 
{
    private List<BankAccount> accounts=new ArrayList<>();
    private List<Transaction> transactions=new ArrayList<>();
    public void addAccount( BankAccount acc)
    {
        for (BankAccount x:accounts)
        {
            if (x.getAccountNumber().equals(acc.getAccountNumber()))
            {
                throw new DuplicateAccountException("So tai khoan nay da bi trung. Vui long nhap lai!!");
                        }
                    }
                    accounts.add(acc);
                    transactions.add(new Transaction(
            acc.getAccountNumber(), "CREATE", acc.getBalance(), "Tao tai khoan moi"));

    }
    public BankAccount find(String AccountNumber)
    {
        for (BankAccount acc:accounts)
        {
            if (acc.getAccountNumber().equals(AccountNumber)) return acc;
        }
        throw new AccountNotFoundException("Hien tai khong tim thay tai khoan nay!");
    }
    public void deposit(String accNum,double amount )
    {
        BankAccount acc=find(accNum);
        acc.deposit(amount);
        transactions.add(new Transaction(accNum,"Thanh toan hoa don",amount,"Chuyen Tien"));
    }    
    public  void withdraw(String accNum, double amount)
    {
        BankAccount acc=find(accNum);
        acc.withdraw(amount);
        transactions.add(new Transaction(accNum,"Rut tien",amount,"Rut tien"));
    }

    public void applyMonthlyInterest() {
    for (BankAccount acc : accounts) {
        if (acc instanceof IInterestBearing ) {
            IInterestBearing interestAccount = (IInterestBearing) acc;
                double oldBalance = acc.getBalance();
                interestAccount.applyMonthlyInterest();
                double interestAmount = acc.getBalance() - oldBalance;
                 
                if (interestAmount != 0) {
                    transactions.add(new Transaction(
                        acc.getAccountNumber(),"INTEREST",interestAmount,"Ap dung lai hang thang "));
        }
    }
}
    }
    public void applyMonthlyFee() {
    for (BankAccount acc : accounts) {
        if (acc instanceof IFeeDeDuctible f) {
            double balance = acc.getBalance();
            f.applyMonthlyFee();
            double fee= balance - acc.getBalance();
            if (fee != 0) {
                transactions.add(new Transaction(acc.getAccountNumber(),"FEE",fee,"Tru phi"));
            }
        }
    }
}
    public void printAcc()
    {
        for(BankAccount acc:accounts)
        {
            System.out.println("Thong tin cua tai khoan:"+acc);
        }
    }
     public void printTrans(String accNum) {
        for (Transaction trans : transactions) {
            if (trans.getAccountNumber().equals(accNum)) {
                System.out.println(trans);
            }
        }
    }
    public void printTrans()
    {
        for (Transaction trans:transactions)
        {
              
            System.out.println(trans);
              
        }
    }
    public void thongKe()
    {
        if(accounts.isEmpty())
        {
            System.out.println("Khong co tai khoan nao");
            return;
        }
        double sodu=0;
        BankAccount caonhat=accounts.get(0);
        BankAccount thapnhat=accounts.get(0);
            for (BankAccount acc:accounts)
            {
                sodu+=acc.getBalance();
                if (acc.getBalance()>caonhat.getBalance())
                {
                    caonhat=acc;
                }
                if (acc.getBalance()<thapnhat.getBalance())
                {
                    thapnhat=acc;
                }
            }
            System.out.println("Tong so du: " + sodu);
            System.out.println("Tai khoan co so du cao nhat: " + caonhat);
            System.out.println("Tai khoan co so du thap nhat: " + thapnhat);
    }
     public void sapxep(boolean tangdan) {
        List<BankAccount> sortedAccounts = new ArrayList<>(accounts);

        if (tangdan) {
            Collections.sort(sortedAccounts); 
        } else {
            Collections.sort(sortedAccounts, Collections.reverseOrder()); 
        }

        for (BankAccount acc : sortedAccounts) {
            System.out.println(acc);
        }
        for (BankAccount acc : sortedAccounts) {
        System.out.println(acc);
    }
    }
    public void printTransTheoNgay(LocalDate ngay) {
        System.out.println(" Giao dich ngay " + ngay);
        for (Transaction trans : transactions) {
            if (trans.getTimestamp().toLocalDate().equals(ngay))
             {
                System.out.println(trans);

            }
        }
    }
}
