package College;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DataBase {
    private String  firstName;
    private String lastName;
    private int gradeYear;
    private int numberofcourse;
    private int dropcourse;
    private String courses;
    private final static double  tuitionFee=16000;
    private final static double costOfCourse=600;
    private static int studentID=0;
    private double totalbalance=tuitionFee;
    public DataBase(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter Student First Name");
        this.firstName=obj.nextLine();
        System.out.println("Enter Student Last Name");
        this.lastName=obj.nextLine();
        System.out.println("Enter Student Class Level in number \n1:freshmen\n2:Sophomore\n3:Junior\n4:Senior");
        this.gradeYear=obj.nextInt();
        setStudentId();
        System.out.println(firstName + " "+ lastName +" " + studentID);
        StudentCourseDetails();
    }
    private void setStudentId(){
        studentID++;
        DataBase.studentID=studentID;
    }

    private void StudentCourseDetails(){
        Scanner checkState=new Scanner(System.in);
        System.out.println("1: Check totalBalance to  paid");
        System.out.println("2:Add Course");
        System.out.println("3.Pay Balance");
        System.out.println("4.Exit");
        System.out.println("Enter a Number for DashBoard");
        int checkStateNumber=checkState.nextInt();
        if(checkStateNumber == 1){
            totalBalance();
        }else if(checkStateNumber == 2){
            AddCourse();
        } else if(checkStateNumber == 3) {
            PayBalance();
        }else{
            return;
        }
    }



    public void CourseList(){
        Scanner courseselect=new Scanner(System.in);
        ArrayList<String> CourseSelectStudents=new ArrayList<String>();
        System.out.println("There are the course we offer .");
        System.out.println("1. History 101");
        System.out.println("2. Mathematics 112");
        System.out.println("3. Calculus");
        System.out.println("4. Public Speaking");
        System.out.println("5. Chemsitry");
        System.out.println("Enter a Number of Course you want to join");
        numberofcourse=courseselect.nextInt();
        courseselect.nextLine();
        if(numberofcourse>=0 && numberofcourse<=5){
            for(int i=0;i<numberofcourse;i++){
                System.out.println("Enter the name of the Course");
                String CourseAdd=courseselect.nextLine();
                CourseSelectStudents.add(CourseAdd);
            }
            System.out.println("The Course you want to Join");
            for(String i:CourseSelectStudents){
                System.out.println(i);
            }
            StudentCourseDetails();
        } else{
            System.out.println("OOPs We Only Offer 5 Course");
            CourseList();
        }
        }



//    course we offer
    public void AddCourse(){
        Scanner courseselect=new Scanner(System.in);
        System.out.println("Did you want to add extra course? Cost is $600 per Course");
        System.out.println("Type Y FOR Yes and N for No");
       String state=courseselect.nextLine();
       if(state.trim().toUpperCase().equals("Y")){
          CourseList();
       }else{
           StudentCourseDetails();
       }

    }

   public void totalBalance(){
       totalbalance=tuitionFee+costOfCourse*numberofcourse;
      System.out.println("The balance you need to pay is " + totalbalance);
       StudentCourseDetails();

    }

//    Pay tuition
    public  void PayBalance(){
        Scanner payment=new Scanner(System.in);
        System.out.println("Enter a Amount you want to pay");
        int paymentBalance=payment.nextInt();
        if(totalbalance<=0){
            System.out.println("You are Finacially Clear");
            System.out.println("The amount to pay is " + 0.0);
            StudentCourseDetails();

        }else{
            totalbalance=totalbalance-paymentBalance;
            System.out.println("The remaining balance to paid is " + totalbalance );
            StudentCourseDetails();
        }

    }



}
