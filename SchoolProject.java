package schoolproject;
import java.util.Scanner;
  class Employee {
        int id;
        String name;
        String address;
        float age;
        float salary;
    }

     class Student {
        int id;
        String name;
        String address;
        float age;
        int classNumber;
    }
public class SchoolProject {
 static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        while(true){
        System.out.println("Please select a department:");
        System.out.println("1. Students");
        System.out.println("2. Employees");
        System.out.println("3.Exite");
        int departmentChoice = scanner.nextInt();

        switch (departmentChoice) {
            case 1:
                manageStudents();
                break;
            case 2:
                manageEmployees();
                break;
            case 3:
                System.out.println("programe finesh");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid department choice.");
                break;
        }
    }}

    public static void manageStudents() {
       
        Student[] students = new Student[20];
        students = addStudent(students);
        
        
        int choice = 0;
        do{
            System.out.println("Please select an operation:");
            System.out.println("1. Add a student");
            System.out.println("2. Delete a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    students = addStudent(students);
                    break;
                case 2:
                    System.out.println("Enter the student ID: ");
                    int studentId = scanner.nextInt();
                    students = removeStudent(students, studentId);
                    break;
                case 3:
                    System.out.println("Enter the student name: ");
                    String searchName = scanner.next();
                    searchStudent(students, searchName);
                    break;
                case 4:
                    displayStudents(students);
                    break;
                case 5:
                    System.out.println("choose any namber to rerurn");
                     int nam=scanner.nextInt();
                    break;
                default:
                    System.out.println("Please choose a valid option.");
            }
            System.out.println();
        }while(choice != 5);
    }

    public static void manageEmployees() {
        
        Employee[] employees = new Employee[20];
        employees = addEmployee(employees);
    int    choice = 0;
        do{
            System.out.println("Please select an operation:");
            System.out.println("1. Add an employee");
            System.out.println("2. Delete an employee");
            System.out.println("3. Search for an employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employees = addEmployee(employees);
                    break;
                case 2:
                    System.out.println("Enter the employee ID: ");
                    int employeeId = scanner.nextInt();
                    employees = removeEmployee(employees, employeeId);
                    break;
                case 3:
                    System.out.println("Enter the employee name: ");
                    String searchName = scanner.next();
                    searchEmployee(employees, searchName);
                    break;
                case 4:
                    displayEmployees(employees);
                    break;
                case 5:
                   System.out.println("choose any namber to rerurn");
                   int nam=scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Enter the ID of the employee to pay salary:");
                    int employeeIdToPay = scanner.nextInt();
                    System.out.println("Enter the amount to pay:");
                    double amount = scanner.nextDouble();
                    paySalary(employees, employeeIdToPay, amount);
                    break; 
                default:
                    System.out.println("Please choose a valid option.");
            }
            System.out.println();
        }while(choice!=5);
    }

    public static Employee[] addEmployee(Employee[] employees) {
        System.out.println("Enter the number of employees:");
        int numEmployees = scanner.nextInt();
        for (int j = 0; j <  numEmployees; j++) {
        for (int i = 0; i < employees.length; i++) {
         if (employees[i] == null) {
            employees[i] = new Employee();
            System.out.println("Enter the name of employee " + (i + 1) + ":");
            employees[i].name = scanner.next();
            System.out.println("Enter the age of employee " + (i + 1) + ":");
            employees[i].age = scanner.nextFloat();
            scanner.nextLine(); // Clear the newline character
            System.out.println("Enter the address of employee " + (i + 1) + ":");
            employees[i].address = scanner.nextLine();
            System.out.println("Enter the ID of employee " + (i + 1) + ":");
            employees[i].id = scanner.nextInt();
            System.out.println("Enter the salary of employee " + (i + 1) + ":");
            employees[i].salary = scanner.nextFloat();
            System.out.println();
    break;    }
        
    }}
 return employees;   }

    public static void searchEmployee(Employee[] employees, String name) {
        boolean found = false;
        for (Employee employee : employees) 
            if (employee.name.equals(name)) {
                found = true;
                break;
            } 
 
    if (found) {
        System.out.println("Employee found.");
    } else {
        System.out.println("Employee not found.");
    }
}

public static Employee[] removeEmployee(Employee[] employees, int id) {
    int index = -1;
    for (int i = 0; i < employees.length; i++) {
        if (employees[i].id == id) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        Employee[] updatedEmployees = new Employee[employees.length - 1];
        for (int i = 0, j = 0; i < employees.length; i++) {
            if (i != index) {
                updatedEmployees[j] = employees[i];
                j++;
            }
        }
        System.out.println("Employee deleted successfully.");
        return updatedEmployees;
    } else {
        System.out.println("Employee not found.");
        return employees;
    }
}

public static void displayEmployees(Employee[] employees) {
    System.out.println();
    for (int i = 0; i < employees.length; i++) {
        System.out.println("Employee " + (i + 1) + ":");
        System.out.println("Name: " + employees[i].name);
        System.out.println("Age: " + employees[i].age);
        System.out.println("Address: " + employees[i].address);
        System.out.println("ID: " + employees[i].id);
        System.out.println("Salary: " + employees[i].salary);
        System.out.println();
    }
}
   public static void paySalary(Employee[] employees,
int id, double amount) {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee != null && employee.id == id) {
                found = true;
                employee.salary += amount;
                break;
            }
        }

        if (found) {
            System.out.println("Salary paid successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }  

    public static Student[] addStudent(Student[] students) {
         System.out.println("Enter the number of students: ");
        int size = scanner.nextInt();
        for (int j = 0; j< size; j++)
        for (int i = 0; i < students.length; i++) 
            if(students[i]==null){
            students[i] = new Student();
            System.out.println("Enter the name of student " + (i + 1) + ":");
            students[i].name = scanner.next();
            System.out.println("Enter the age of student " + (i + 1) + ":");
            students[i].age = scanner.nextFloat();
            scanner.nextLine(); // Clear the newline character
            System.out.println("Enter the address of student " + (i + 1) + ":");
            students[i].address = scanner.nextLine();
            System.out.println("Enter the ID of student " + (i + 1) + ":");
            students[i].id = scanner.nextInt();
            System.out.println("Enter the class number of student " + (i + 1) + ":");
            students[i].classNumber = scanner.nextInt();
            System.out.println();
        break;}
        return students;
    }

    public static void searchStudent(Student[] students, String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.name.equals(name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Student found.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static Student[] removeStudent(Student[] students, int id) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].id == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Student[] updatedStudents = new Student[students.length - 1];
            for (int i = 0, j = 0; i < students.length; i++) {
                if (i != index) {
                    updatedStudents[j] = students[i];
                    j++;
                }
            }
            System.out.println("Student deleted successfully.");
            return updatedStudents;
        } else {
            System.out.println("Student not found.");
            return students;
        }
    }

    public static void displayStudents(Student[] students) {
        System.out.println();
       for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + " name: " + students[i].name);
            System.out.println("Student " + (i + 1) + " ID: " + students[i].id);
            System.out.println("Student " + (i + 1) + " age: " + students[i].age);
            System.out.println("Student " + (i + 1) + " address: " + students[i].address);
            System.out.println("Student " + (i + 1) + " class number: " + students[i].classNumber);
        }
    }}

