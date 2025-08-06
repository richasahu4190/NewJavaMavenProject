package Aug05;

	class Person {
	    String name;
	    float age;

	    Person(String name, float age) {
	        this.name = name;
	        this.age = age;
	    }

	    public String toString() {
	        return name + ", Age: " + age;
	    }
	}

	class Account {
	    static long nextAccNum = 1001;
	    long accNum;
	    double balance;
	    Person accHolder;

	    Account(double balance, Person accHolder) {
	        this.accNum = nextAccNum++;
	        this.balance = balance;
	        this.accHolder = accHolder;
	    }

	    void deposit(double amt) {
	        balance += amt;
	    }

	    void withdraw(double amt) {
	        if (balance - amt >= 500)
	            balance -= amt;
	        else
	            System.out.println("Min balance INR 500 must be maintained.");
	    }

	    public String toString() {
	        return "AccNo: " + accNum + ", Balance: INR " + balance + ", Holder: " + accHolder;
	    }
	}

	public class Lab2_1 {
	    public static void main(String[] args) {
	        Person smith = new Person("Smith", 30);
	        Account a1 = new Account(2000, smith);

	        Person kathy = new Person("Kathy", 28);
	        Account a2 = new Account(3000, kathy);

	        a1.deposit(2000);       
	        a2.withdraw(2000);      

	        System.out.println(a1); 
	        System.out.println(a2);
	    }
	}


