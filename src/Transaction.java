import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction 
{
    private String id;
    private String AccountNumber;
    private String Type;
    private double Amount;
    private LocalDateTime timestamp;
    private String note;
    public Transaction(String id, String AccountNumber,String Type,double Amount,LocalDateTime timestamp,String note)
    {
        this.id=id;
        this.AccountNumber=AccountNumber;
        this.Type=Type;
        this.Amount=Amount;
        this.timestamp=timestamp;
        this.note=note;
    }
    public Transaction(String AccountNumber, String Type, double Amount, String note) {
        this.id = UUID.randomUUID().toString();
        this.AccountNumber = AccountNumber;
        this.Type = Type;
        this.Amount = Amount;
        this.timestamp = LocalDateTime.now();
        this.note = note;
    }
    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    public double getAmount() {
        return Amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getNote() {
        return note;
    }
    @Override
    public String toString() {
        return "Transaction{" +"ID:'" + id + '\'' + ", So tai khoan:'" + AccountNumber + '\'' + ", Loai gia dich:'" + Type + '\'' +", So du hien tai: " + Amount +", Thoi gian thuc hien giao dich:" + timestamp + ", Ghi chu'" + note + '\'' + '}';
    }
}
