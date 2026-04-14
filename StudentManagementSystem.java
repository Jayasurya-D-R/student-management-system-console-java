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
            int choice=scan.nextInt();
            scan.nextLine();
            if(choice==1){
                System.out.println("Enter the name of the student:");
                String name= scan.nextLine();
                System.out.println("Enter the marks of the student:");
                int marks=scan.nextInt();
                list.add(new Student(name,marks));
                System.out.println("Student added Successfully");
            }
            else if(choice==2){
                if(list.isEmpty()){
                    System.out.println("No students");
                }
                else{
                    for(int i=0;i<list.size();i++){
                        list.get(i).display();
                    }
                }
            }
            else if(choice==3){
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
            else if(choice==4){
                add=false;
            }
            else{
                System.out.println("Invalid command only give input 1 or 2 or 3 or 4");
            }
        }
        scan.close();
    }
}
