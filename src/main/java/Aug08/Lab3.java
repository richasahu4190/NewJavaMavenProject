package Aug08;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class Lab3 {
    public static void main(String[] args) {
        String fileName = "src/main/java/Aug08/employee.txt";

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Alice", 50000));
        list.add(new Employee(102, "Bob", 60000));
        list.add(new Employee(103, "Charlie", 80000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Employees saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> readList = (List<Employee>) ois.readObject();
            System.out.println("Employees from file:");
            for (Employee e : readList) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
