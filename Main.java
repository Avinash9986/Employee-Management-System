package ems;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        int id ;
        String name ;
        EmployeeDoaIntrf dao = new EmpioyeeDaoImpl() ;

        System.out.println("welocme to employee managemen System") ;

        Scanner sc =new Scanner(System.in) ;
        do{
            System.out.println("1. Add Employee\n"+"2.show all the epmloyee\n"+
                    "3.show employee based on id\n"+
                    "4.Update the employee \n"+
                    "5. Delete the employee\n") ;

            System.out.println("ENTER CHOICE : ") ;
            int ch = sc.nextInt() ;
            switch (ch){
                case 1 :
                    Employee emp = new Employee() ;
                    System.out.println("Enter ID :");
                    id = sc.nextInt() ;
                    System.out.println("Enter name :");
                    name = sc.next() ;
                    System.out.println("Enter Salary :");
                    double salary = sc.nextInt() ;
                    System.out.println("Enter AGE :");
                    int age = sc.nextInt() ;
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEM(emp);
                    break ;
                case 2 :
                    dao.showem();
                    break;
                case 3:
                    System.out.println("Enter thr id to show details");
                    int empid = sc.nextInt() ;
                    dao.showemid(empid);
                    break;
                case 4 :
                    System.out.println("Enter the id update the details :");
                    id= sc.nextInt() ;
                    System.out.println("Enter the new name: ");
                    name= sc.next() ;
                    dao.updateem(id,name);
                    break;
                case 5 :
                    System.out.println("Enter the ID to delete: ");
                    id = sc.nextInt() ;
                    dao.deleteem(id);
                    break;
                case 6 :
                    System.out.println("GThank you for using application");
                    System.exit(0);

                default:
                    System.out.println("enter the valid choices") ;
                    break ;
            }
         }while(true) ;


    }
}
