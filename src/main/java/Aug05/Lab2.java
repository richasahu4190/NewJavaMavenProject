package Aug05;

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
    }

    boolean withdraw(double amt) {
        if (balance - amt >= 500) {
            balance -= amt;
            return true;
        }
        return false;
    }
 

	    void show() {
	        System.out.println("Balance: " + balance);
	    }
	}

	class SavingsAccount extends BankAccount {
	    final double minBalance = 1000;

	    SavingsAccount(double balance) {
	        super(balance);
	    }

	    @Override
	    boolean withdraw(double amt) {
	        if (balance - amt >= minBalance) {
	            balance -= amt;
	            return true;
	        }
	        return false;
	    }
	}

	class CurrentAccount extends BankAccount {
	    double overdraftLimit = 2000;

	    CurrentAccount(double balance) {
	        super(balance);
	    }

	    @Override
	    boolean withdraw(double amt) {
	        if (balance + overdraftLimit >= amt) {
	            balance -= amt;
	            return true;
	        }
	        return false;
	    }
	}

	public class Lab2 {
	    public static void main(String[] args) {
	        SavingsAccount sa = new SavingsAccount(5000);
	        CurrentAccount ca = new CurrentAccount(1000);

	        sa.withdraw(4500); 
	        ca.withdraw(2500); 

	        System.out.println("Savings Account:");
	        sa.show();

	        System.out.println("Current Account:");
	        ca.show();
	    }
	}


