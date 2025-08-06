package Aug05;

	abstract class Accounts{
	    double balance;

	    Accounts(double balance) {
	        this.balance = balance;
	    }

	    void deposit(double amt) {
	        balance += amt;
	    }

	    abstract boolean withdraw(double amt); // abstract method

	    void show() {
	        System.out.println("Balance: " + balance);
	    }
	}

	class SavingsAccounts extends Accounts {
	    final double minBalance = 1000;

	    SavingsAccounts(double balance) {
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

	class CurrentAccounts extends Accounts {
	    double overdraft = 2000;

	    CurrentAccounts(double balance) {
	        super(balance);
	    }

	    @Override
	    boolean withdraw(double amt) {
	        if (balance + overdraft >= amt) {
	            balance -= amt;
	            return true;
	        }
	        return false;
	    }
	}

	public class Lab5 {
	    public static void main(String[] args) {
	        Accounts sa = new SavingsAccounts(5000);
	        Accounts ca = new CurrentAccounts(1000);

	        sa.withdraw(4500); 
	        ca.withdraw(2500); 

	        sa.show();
	        ca.show();
	    }
	}



