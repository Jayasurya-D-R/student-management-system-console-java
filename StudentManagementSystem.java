import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    int marks;
    Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    void display(){
        System.out.println("Name:"+name+", Marks:"+marks);
    }
}

class Main{
    static void addStudent(ArrayList<Student> list, Scanner scan){
        System.out.println("Enter the name of the student:");
        String name= scan.nextLine();
        System.out.println("Enter the marks of the student:");
        int marks=scan.nextInt();
        scan.nextLine();
        list.add(new Student(name,marks));
        System.out.println("Student added Successfully");
    }
    static void viewStudents(ArrayList<Student> list){
        if(list.isEmpty()){
            System.out.println("No students");
        }
        else{
            for(int i=0;i<list.size();i++){
                list.get(i).display();
            }
        }
    }
    static void findTopper(ArrayList<Student> list){
        if(list.isEmpty()){
            System.out.println("There are no students to find topper");
        }
        else{
            Student top=list.get(0);
            for(int i=1;i<list.size();i++){
                if(list.get(i).marks>top.marks){
                    top=list.get(i);
                }
            }
            System.out.println("The topper of the class is:"+top.name);
        }
    }
    static void searchStudent(ArrayList<Student> list,Scanner scan){
        boolean checker=false;
        System.out.println("Enter the name of the Student:");
        String check=scan.nextLine();
        for(int i=0;i<list.size();i++){
            if(check.equals(list.get(i).name)) {
                System.out.println("Student found Successfully");
                list.get(i).display();
                checker=true;
            }
        }
        if(!checker){
            System.out.println("No student found");
        }
    }
    static void deleteStudent(ArrayList<Student> list,Scanner scan){
        boolean checker=false;
        System.out.println("Enter the name of the Student:");
        String check=scan.nextLine();
        for(int i=0;i<list.size();i++){
            if(check.equals(list.get(i).name)){
                list.remove(i);
                System.out.println("Student deleted successfully");
                checker=true;
                break;
            }
        }
        if(!checker){
            System.out.println("No student found");
        }
    }
    static void updateMarks(ArrayList<Student> list,Scanner scan){
        boolean checker=false;
        System.out.println("Enter the name of the Student:");
        String check=scan.nextLine();
        for(int i=0;i< list.size();i++){
            if(check.equals(list.get(i).name)) {
                System.out.println("Enter the new marks");
                int newmarks=scan.nextInt();
                scan.nextLine();
                list.get(i).marks=newmarks;
                System.out.println("Success");
                checker=true;
                break;
            }
        }
        if(!checker){
            System.out.println("No student found");
        }
    }
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        boolean add=true;
        while(add){
            System.out.println("------------MENU----------------");
            System.out.println("Press 1:To Add Student");
            System.out.println("Press 2:To View Students");
            System.out.println("Press 3:Find Topper");
            System.out.println("Press 4:To Exit");
            System.out.println("Press 5:To Search a Student");
            System.out.println("Press 6:To Delete Student");
            System.out.println("Press 7:To Update marks");
            int choice=scan.nextInt();
            scan.nextLine();
            if(choice==1){
                addStudent(list,scan);
            }
            else if(choice==2){
                viewStudents(list);
            }
            else if(choice==3){
                findTopper(list);
            }
            else if(choice==4){
                add=false;
            }
            else if(choice==5){
                searchStudent(list,scan);
            }
            else if(choice==6){
                deleteStudent(list,scan);
            }
            else if(choice==7){
                updateMarks(list,scan);
            }
            else{
                System.out.println("Invalid command only give input 1 or 2 or 3 or 4");
            }
        }
        scan.close();
    }
}
