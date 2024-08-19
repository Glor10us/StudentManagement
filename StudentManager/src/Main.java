
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tunkyo
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> stuList = new ArrayList<>();

        System.out.println("====================================");
        System.out.println("Welcome to Student Management System");
        System.out.println("OPTIONS:");
        System.out.println("1. Add new student");
        System.out.println("2. Edit a student");
        System.out.println("3. Delete a student");
        System.out.println("4. Search a student");
        System.out.println("5. Display all students");
        System.out.println("====================================");
        System.out.print("Your option(1,2,3,4): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();

                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();

                String email;
                while (true) {
                    System.out.print("Email: ");
                    email = sc.nextLine();

                    if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                        break;
                    } else {
                        System.out.println("Invalid email.Please try again");
                    }
                }

                System.out.println("GRADE:");
                System.out.print("Grade for PRF192: ");
                double prf192 = sc.nextDouble();
                System.out.print("Grade for MAE101: ");
                double mae101 = sc.nextDouble();
                System.out.print("Grade for CSI101: ");
                double csi101 = sc.nextDouble();

                Student.Grade grade = new Student().new Grade(prf192, mae101, csi101);

                Student newStu = new Student(id, name, email, grade);
                stuList.add(newStu);
                System.out.println("Added new student");
                
                for(Student student : stuList) {
                    student.displayStudent();
                }
                break;

            default:
                System.out.println("Invalid choice. Please try again");
                break;

        }
    }
}