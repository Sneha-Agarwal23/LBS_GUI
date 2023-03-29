package library;

import java.util.Scanner;

public class Student {
	public String student_name;
	public String student_id;
	public String student_stream;
	public int student_year;
	public String student_mobile;
	
	Scanner sc = new Scanner(System.in);
	
	public int book_count = 0;
	Book issued_book[] = new Book[3];		//Max number of books allowed per student at a time
	
	public Student(String name, String id, String stream, String year,String mob)
	{
		//System.out.println("Enter Student's Name: ");
		this.student_name = name;		//= sc.nextLine();
		
		//System.out.println("Enter Student's ID: ");
		this.student_id = id;			//sc.nextLine();
		
		//System.out.println("Enter Student's Stream: ");
		this.student_stream = stream;		//sc.nextLine();
		
		//System.out.println("Enter Student's Year: ");
		this.student_year = Integer.parseInt(year);			//sc.nextInt();
		
		//sc.nextLine();
		//System.out.println("Enter Student's Mobile No: ");
		this.student_mobile = mob;			//sc.nextLine();
	}
	
	/*public static void main(String args[])
	{
		Student obj = new Student();
	}*/
	

}