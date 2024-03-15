import java.util.Random;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void debit(int amount) {
        balance += amount;
        System.out.println("\tПополнение: +" + amount);
        System.out.println("Баланс: " + balance);
    }

    public synchronized void credit(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("\tСнятие: -" + amount);
            System.out.println("Баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств для снятия!");
        }
    }

    public int getBalance(){
        return this.balance;
    }
}

public class First {
    public static void main(String[] args) {
        // Создание объекта банка с начальным балансом 1000
        BankAccount account = new BankAccount(10000);
        System.out.println("Баланс: " + account.getBalance());


        Thread debitThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int amount = random.nextInt(1000) + 1;
                account.debit(amount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread creditThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int amount = random.nextInt(1000) + 1;
                account.credit(amount);
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        debitThread.start();
        creditThread.start();
    }
}