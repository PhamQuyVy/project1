import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        while(true) {
            System.out.println("1. Tao tai khoan");
            System.out.println("2. Nap tien");
            System.out.println("3. Rut tien");
            System.out.println("4. Ap dung lai hang thang");
            System.out.println("5. Ap dung phi hang thang");
            System.out.println("6. Tra cuu tai khoan");
            System.out.println("7. Liet ke tai khoan");
            System.out.println("8. Lich su giao dich");
            System.out.println("9. Thong ke va sap xep");
            System.out.println("10. Thoat");
            System.out.print("Chon: ");
            int chon;
            try {
                chon = sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("Nhap sai so. Vui long nhap lai cho dung!!");
                sc.nextLine();
                continue;
            }
            
            try {
                switch(chon) {
                    case 1 -> {
                        System.out.println("Chon loai:(1: Savings, 2: Checkings, 3: Credit):");
                        int type = sc.nextInt();
                        sc.nextLine();
                        System.out.print("So tai khoan:");
                        String accNum = sc.nextLine();
                        System.out.print("Ten chu tai khoan:");
                        String name = sc.nextLine();
                        System.out.print("So du hien tai cua tai khoan:");
                        double balance = sc.nextDouble();
                        
                        if(type == 1) {
                            System.out.print("Phan tram lai suat trong nam:");
                            double rate = sc.nextDouble();
                            bank.addAccount(new SavingsAccount(accNum, name, balance, rate));
                            System.out.println("Da tao tai khoan tiet kiem thanh cong!");
                        }
                        else if(type == 2) {
                            System.out.print("Phi rut:");
                            double fee = sc.nextDouble();
                            System.out.print("Phi duy tri tai khoan hang thang:");
                            double monthlyfee = sc.nextDouble();
                            bank.addAccount(new CheckingsAccount(accNum, name, balance, fee, monthlyfee));
                            System.out.println("Da tao tai khoan thanh toan thanh cong!");
                        }
                        else if (type == 3) {
                            System.out.print("Han muc:");
                            double limit = sc.nextDouble();
                            System.out.print("Lai no hang thang:");
                            double debtrate = sc.nextDouble();
                            System.out.print("Phi hang thang:");
                            double monthfee = sc.nextDouble();
                            bank.addAccount(new CreditAccount(accNum, name, balance, limit, debtrate, monthfee));
                            System.out.println("Da tao tai khoan tin dung thanh cong!");
                        }
                    }
                    case 2 -> {
                        System.out.print("So tai khoan:");
                        String accNum = sc.nextLine();
                        System.out.print("So tien nap vao:");
                        double money = sc.nextDouble();
                        bank.deposit(accNum, money);
                        System.out.println("Nap tien thanh cong!");
                    }
                    case 3 -> {
                        System.out.print("So tai khoan:");
                        String accNum = sc.nextLine();
                        System.out.print("So tien rut:");
                        double money = sc.nextDouble();
                        bank.withdraw(accNum, money);
                        System.out.println("Rut tien thanh cong!");
                    }
                    case 4 -> {
                        bank.applyMonthlyInterest();
                        System.out.println("Da ap dung lai hang thang!");
                    }
                    case 5 -> {
                        bank.applyMonthlyFee();
                        System.out.println("Da ap dung phi hang thang!");
                    }
                    case 6 -> {
                        System.out.print("So tai khoan can tra cuu:");
                        String accNum = sc.nextLine();
                        System.out.println(bank.find(accNum));
                    }
                    case 7 -> bank.printAcc();
                    case 8 -> {
                        System.out.println("1. Theo tai khoan");
                        System.out.println("2. Tat ca giao dich");
                        System.out.println("3. Theo ngay");
                        System.out.print("Chon: ");
                        int option = sc.nextInt();
                        sc.nextLine();
                        
                        if (option == 1) {
                            System.out.print("Nhap so tai khoan:");
                            String accNum = sc.nextLine();
                            bank.printTrans(accNum);
                        } else if (option == 2) {
                            bank.printTrans();
                        } else if (option == 3) {
                            System.out.print("Nhap ngay (yyyy-mm-dd): ");
                            String ngayStr = sc.nextLine();
                            try {
                                LocalDate ngay = LocalDate.parse(ngayStr);
                                bank.printTransTheoNgay(ngay);
                            } catch (Exception e) {
                                System.out.println("Dinh dang ngay khong hop le!");
                            }
                        }
                    }
                    case 9 -> {
                        System.out.println("1. Thong ke tong quat");
                        System.out.println("2. Sap xep tang dan");
                        System.out.println("3. Sap xep giam dan");
                        System.out.print("Chon: ");
                        int option = sc.nextInt();
                        sc.nextLine();
                        
                        if (option == 1) {
                            bank.thongKe();
                        } else if (option == 2) {
                            bank.sapxep(true);
                        } else if (option == 3) {
                            bank.sapxep(false);
                        }
                    }
                    case 10 -> {
                        System.out.println("Thoat chuong trinh");
                        return;
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
            } catch(RuntimeException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
            
            System.out.println("Nhan Enter de tiep tuc...");
            sc.nextLine();
        }
    }
}
