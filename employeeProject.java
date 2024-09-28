
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;

import java.io.*;
import java.util.*;
class employee{
    int empId;
    String empName;
    int salary;
    
    employee(int empNo,String empName,int salary){
        this.empId=empId;
        this.empName=empName;
        this.salary=salary;
    }
    public String toString(){
        return empId+" "+empName+" "+salary;
    }
}
public class employeeProject {
    
    public static void main(String[] args) throws Exception{
        int choice =-1;
        Scanner sc=new Scanner(System.in);
        Scanner s=new Scanner(System.in);
        File f = new File("employee.txt");
       ArrayList<employee> al = new ArrayList<employee>();
       ObjectOutputStream oos = null;
       ObjectInputStream ois = null;
        do{
            System.out.println("1.Add employee");
            System.out.println("2.Display employee");
            System.out.println("3.Delete employee");
            System.out.println("4.update employee");
            System.out.println("0. exit");
            choice=sc.nextInt();
            switch(choice){
                case 1: 
                System.out.println("how many employee you want");
                int a = sc.nextInt();
                for(int i=0;i<a;i++){
                     System.out.println("enter employee Id:");
                     int empId=sc.nextInt();

                     System.out.println("enter employee Name:");
                     String empName=s.nextLine();

                     System.out.println("enter employee Salary:");
                     int salary=sc.nextInt();

                     al.add(new employee(empId, empName, salary));
                }
                     break;
               case 2:
                  System.out.println(al);
                  break;
            }

        }while(choice!=0);
    }
}
